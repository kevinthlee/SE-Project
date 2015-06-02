package UI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
	
	ImageIcon log;
	JButton login;
	JPanel login_Panel;
	MenuScreen menuscreen;
	
	
	public login(){
		
		
		log = new ImageIcon("Img_menu/login_back.png");
		
		login_Panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(log.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
				
		login = new JButton(new ImageIcon("img_menu/login.png"));
		login.setSize(145, 35);
		login.setLocation(227, 75);
		
		login_Panel.add(login);
		login.addActionListener(this);
		
		add(login_Panel, BorderLayout.CENTER);
				
	}
	
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login){
			login_Panel.setVisible(false);
			
			menuscreen = new MenuScreen();

			
		}
		
	}
	
	

}
