package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; 
import javax.swing.event.*;

public class login_back extends JPanel {
	ImageIcon back = new ImageIcon("images/login_back.png"); 
	Image img = back.getImage();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		g.setColor(Color.WHITE);
		g.drawString("", 100, 100);
	}
	
	public static void main(String [] args){
		new login();
	}
	    

}
