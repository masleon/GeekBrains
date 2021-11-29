package ru.gb.current.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {

    private final ServerSocket socket;
    private final ru.gb.current.server.AuthenticationService authenticationService;
    private final Set<ru.gb.current.server.ClientHandler> loggedClients;
    private final Logger logger = LogManager.getLogger(ChatServer.class);

    public ChatServer() {
        try {
            authenticationService = new ru.gb.current.server.AuthenticationService();
            loggedClients = new HashSet<>();
            this.socket = new ServerSocket(8888);

            while (true) {
                //System.out.println("Waiting for a new connection...");
                logger.info("Waiting for a new connection...");
                Socket client = socket.accept();
                //System.out.println("Client accepted.");
                logger.info("Client accepted.");
                new Thread(() -> new ru.gb.current.server.ClientHandler(client, this)).start();
            }
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException("Something went wrong during connection establishing.", e);
        }
    }

    public ru.gb.current.server.AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public synchronized void addClient(ru.gb.current.server.ClientHandler client) {
        loggedClients.add(client);
    }

    public synchronized void removeClient(ru.gb.current.server.ClientHandler client) {
        loggedClients.remove(client);
    }

    public synchronized boolean isUsernameOccupied(String username) {
        return loggedClients.stream()
                .anyMatch(c -> c.getName().equals(username));
    }

    public synchronized void broadcastMessage(String message) {
        loggedClients.forEach(ch -> ch.sendMessage(message));
    }
}
