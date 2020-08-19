package lab.ssafy.corona.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ChatClient{
	
	public static void main(String[] args) 	{
		String ip = "localhost";
		int port = 4101;
		String roomName;
		ArrayList<String> fruits = new ArrayList<String>();
		JFrame waitingRoom = new JFrame("대기방");
		JLabel waitLabel = new JLabel("현재 채팅방");
		JButton createRoomButton = new JButton("방 생성하기"); 
		JList strList = new JList(fruits.toArray());
		
		ActionListener createListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				roomName = JOptionPane.showInputDialog("방 이름을 입력하세요");
			}
		};
		
		createRoomButton.addActionListener(createListener);
		waitingRoom.add("North", waitLabel);
		waitingRoom.add("Center", strList);
		waitingRoom.add("South", createRoomButton);
		waitingRoom.setBounds(500, 400, 300, 500);
		waitingRoom.setVisible(true);
		
		ChatClientSwing ui = new ChatClientSwing( ip, port, roomName );
		ui.setTitle("SSAFY V1 - connected to " + ip + ":" + port);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
        
        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        ui.getChatConnect().setName(name);
	}
}
