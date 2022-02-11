package com.geekbrains.cloud.client;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_it;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private File currentDir;
    public TextField clientPath;
    public TextField serverPath;
    public ChoiceBox<String> disks;
    public ListView clientView;
    public ListView serverView;

    private DataInputStream dis;
    private DataOutputStream dos;
    private byte[] buf;
    private static final int BUFFER_SIZE = 256;

    private void initNet(){
        try{
            buf = new byte[BUFFER_SIZE];
            Socket socket = new Socket("localhost",8199);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    private void updateClientView(){
        Platform.runLater(()->{
            clientPath.setText(currentDir.getAbsolutePath());
            clientView.getItems().clear();
            clientView.getItems().add("...");
            clientView.getItems().addAll(currentDir.list());
        });
    }
    private void updateServerView(){
        Platform.runLater(()->{
            try {
                dos.writeUTF("#get_Items#");
                serverView.getItems().clear();
                while (true) {
                    String item = dis.readUTF();
                    if (item.equals("#over#")) break;
                    else serverView.getItems().add(item);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void upload(ActionEvent actionEvent) throws IOException {
        String item = (String) clientView.getSelectionModel().getSelectedItem();
        File selected = currentDir.toPath().resolve(item).toFile();
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
        updateClientView();
        updateServerView();
    }

    public void download(ActionEvent actionEvent) throws IOException {
        dos.writeUTF("#file_download#");
        dos.writeUTF((String) serverView.getSelectionModel().getSelectedItem());
        try
        {

                String command = dis.readUTF();
                if (command.equals("#file_message#")){
                    String name = dis.readUTF();
                    long size = dis.readLong();
                    File newFile = currentDir.toPath().resolve(name).toFile();
                    try (OutputStream fos = new FileOutputStream(newFile)) {
                        for (int i = 0; i < (size + BUFFER_SIZE - 1) / BUFFER_SIZE; i++) {
                            int countBytes = dis.read(buf);
                            fos.write(buf,0,countBytes);
                        }
                    }
                    System.out.println("File '" + name + "' is downloaded");
                }
                else {
                    System.err.println("unknown command: " + command);
                }
                updateClientView();
                updateServerView();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentDir = new File(System.getProperty("user.home"));
        File[] paths = File.listRoots();
        for (File path:paths){
            disks.getItems().add(path.toString());
        };
        updateClientView();
        initNet();
        updateServerView();
        clientView.setOnMouseClicked(e->{
            if (e.getClickCount()==2){
                String item = (String) clientView.getSelectionModel().getSelectedItem();
                if (item.equals("...")){
                    currentDir = currentDir.getParentFile();
                    updateClientView();
                }
                else {
                    File selected = currentDir.toPath().resolve(item).toFile();
                    if (selected.isDirectory()) {
                        currentDir = selected;
                        updateClientView();
                    }
                }
            }
        });
    }
}
