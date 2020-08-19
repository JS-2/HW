package lab.ssafy.corona.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
    private JTextField inputTextField;
    private JButton sendButton, saveButton;

    private ChatConnect chatConnect;
    private String name;

    public ChatClientSwing(String ip, int port) {
    	chatConnect = new ChatConnect( this, ip, port, name);
    	createUI();
    }
    
    public ChatConnect getChatConnect() {
    	return chatConnect;
    }
    

    private void createUI() {
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        saveButton = new JButton("저장");
        
        box.add(inputTextField);
        box.add(sendButton);
        box.add(saveButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 입력 값 
				String str = inputTextField.getText();
				if ( str != null && str.trim().length() > 0 ) {

					chatConnect.send(str);
					
				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};
		
		ActionListener saveListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				try {
					fw = new FileWriter("chat.txt");
					fw.write(textArea.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if(fw != null)
						try {
							fw.close();
							System.out.println("chat.txt 파일 저장 완료");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				}
			}
		};
        
        inputTextField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);
        saveButton.addActionListener(saveListener);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

        	chatConnect.sendExit();
            	
            }
        });
    }

    public void updateChat(String message) {
    	textArea.append(message);
        textArea.append("\n");
    }
}