import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public MyClient() {
        try {
            socket = new Socket("127.0.0.1",8080);
            scanner = new Scanner(System.in);
            start();
       } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true){
                try {
                    String message = in.readUTF();
                    if (message.equals("/Q")) {
                        System.out.println();
                        System.out.println("Server is closed.");
                        in.close();
                        out.close();
                        socket.close();
                        break;
                    }
                    System.out.println();
                    System.out.println("Server: " + message);
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
