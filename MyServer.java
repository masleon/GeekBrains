import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    private ServerSocket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public MyServer() {
        try {
            socket = new ServerSocket(8080);
            scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        Socket accepted = socket.accept();
        in = new DataInputStream(accepted.getInputStream());
        out = new DataOutputStream(accepted.getOutputStream());

        new Thread(() -> {
            while (true){
                try {
                    String message = in.readUTF();
                    if (message.equals("/Q")) {
                        System.out.println();
                        System.out.println("Client is closed.");
                        in.close();
                        out.close();
                        socket.close();
                        break;
                    }
                    System.out.println();
                    System.out.println("Client: " + message);
                    System.out.print("Enter message:");
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        })
                .start();

        while (true){
            System.out.print("Enter message:");
            String message = scanner.nextLine();
            out.writeUTF(message);
            if (message.equals("/Q")) {
                in.close();
                out.close();
                socket.close();
                break;
            }
        }

    }
}
