package ru.gb.current.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientHandler {

    private final Socket socket;
    private final ru.gb.current.server.ChatServer server;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final File file;
    private String name;

    public ClientHandler(Socket socket, ru.gb.current.server.ChatServer server) {
        this.socket = socket;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            throw new RuntimeException("Something went wring during a client connection establishing.");
        }

        doAuthentication();
        file = new File("history_" + name + ".txt");
        readHistory(file);
        listenMessages();
    }

    public String getName() {
        return name;
    }

    private void doAuthentication() {
        try {
            performAuthentication();
        } catch (IOException ex) {
            throw new RuntimeException("Something went wring during a client authentication.");
        }
    }

    private void performAuthentication() throws IOException {
        while (true) {
            String inboundMessage = in.readUTF();
            if (inboundMessage.startsWith("-auth")) {
                // valid request sample: -auth l1 p1
                String[] credentials = inboundMessage.split("\\s");

                AtomicBoolean isSuccess = new AtomicBoolean(false);
                server.getAuthenticationService()
                        .findUsernameByLoginAndPassword(credentials[1], credentials[2])
                        .ifPresentOrElse(
                                username -> {
                                    if (!server.isUsernameOccupied(username)) {
                                        server.broadcastMessage(String.format("User[%s] is logged in", username));
                                        name = username;
                                        server.addClient(this);
                                        isSuccess.set(true);
                                    } else {
                                        sendMessage("Current username is already occupied.");
                                    }
                                },
                                () -> sendMessage("Bad credentials.")
                        );

                if (isSuccess.get()) break;
            } else {
                sendMessage("You need to be logged-in.");
            }
        }
    }

    public void sendMessage(String outboundMessage) {
        try (FileOutputStream fout = new FileOutputStream(file, true)){
            out.writeUTF(name + " " + outboundMessage);
            String historyMessage = outboundMessage + System.lineSeparator();
            fout.write(historyMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readHistory(File file) {
        try  {
            int counter = 1;
            out.writeUTF("Your previous 100 messages:\n");
            Scanner sc = new Scanner(file);
            while(sc.hasNext()&&counter<=100){
                out.writeUTF(sc.nextLine());
                System.out.println();
                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readMessage() {
        try {
            server.broadcastMessage(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenMessages() {
        while (true) {
            readMessage();
        }
    }
}
