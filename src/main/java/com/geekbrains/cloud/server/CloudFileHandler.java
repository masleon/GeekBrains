package com.geekbrains.cloud.server;

import sun.reflect.generics.tree.FieldTypeSignature;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class CloudFileHandler implements Runnable{


    private final Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private byte[] buf;
    private static final int BUFFER_SIZE=256;
    private File serverDir;

    public CloudFileHandler(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Client connected");
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        buf = new byte[BUFFER_SIZE];
        serverDir = new File("C:\\Temp");
    }

    @Override
    public void run() {
        try
        {
            while (true){
                String command = dis.readUTF();
                if (command.equals("#file_message#")){
                    String name = dis.readUTF();
                    long size = dis.readLong();
                    File newFile = serverDir.toPath().resolve(name).toFile();
                    try (OutputStream fos = new FileOutputStream(newFile)) {
                        for (int i = 0; i < (size + BUFFER_SIZE - 1) / BUFFER_SIZE; i++) {
                            int countBytes = dis.read(buf);
                            fos.write(buf,0,countBytes);
                        }
                    }
                    System.out.println("File '" + name + "' is uploaded");
                }
                else if (command.equals("#file_download#")){
                    String item = dis.readUTF();
                    File selected = serverDir.toPath().resolve(item).toFile();
                    if (selected.isFile()){
                        dos.writeUTF("#file_message#");
                        dos.writeUTF(selected.getName());
                        dos.writeLong(selected.length());
                        try (InputStream fis = new FileInputStream(selected)){
                            while (fis.available()>0){
                                int countBytes = fis.read(buf);
                                dos.write(buf,0,countBytes);
                            }
                        }
                        dos.flush();
                    }
                }
                else if (command.equals("#get_Items#")){
                    String[] items = serverDir.list();
                    for (String item:items
                         ) {
                        dos.writeUTF(item);
                    }
                    dos.writeUTF("#over#");
                }
                else {
                    System.err.println("unknown command: " + command);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
