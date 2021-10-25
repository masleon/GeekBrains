import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    public ChatFrame() {
        setTitle("My chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea);
        add(mainPanel);
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel,BorderLayout.SOUTH);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        textPanel.add(textField,BorderLayout.CENTER);
        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        textPanel.add(sendButton,BorderLayout.EAST);
        setVisible(true);
    }
    private void sendMessage(){
        textArea.setText(new StringBuilder(textArea.getText()).append("\n").append(textField.getText()).toString());
        textField.setText("");
    }
}
