package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*;

public class login {
	public static void main(String [] args){
		
	
		JFrame log = new JFrame();//JFrame log ª˝º∫
		log.setResizable(false);//«¡∑π¿” ∞Ì¡§
		
		log.setTitle("¿ŸªÁ±Õ");
		log.setSize(355,425);//∞°∑Œ 350 ºº∑Œ 400
		log.setVisible(true);
		
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//πË∞Ê ¿ÃπÃ¡ˆ ª¿‘			
		Container contentPane = log.getContentPane();
		login_back panel = new login_back();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(350,400);
		panel.setVisible(true);//πË∞Ê»≠∏Èø° login_back¿ª ª¿‘
		
		//login πˆ∆∞ ∫“∑Øø¿±‚
		log.setLayout(null);
		ImageIcon normalIcon = new ImageIcon("images/login.png"); // πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b1 = new JButton(normalIcon);// JButton b1¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b1.setSize(180,50);
		b1.setLocation(80,270);
		panel.add(b1);//login πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
			
		//ªÁøÎ¿⁄ ∞Ë¡§ ¿‘∑¬ TextField ∫“∑Øø¿±‚
		JTextField j1 = new JTextField(20);//JTextField j1 º±æ
		panel.add(j1);// ªÁøÎ¿⁄ ∞Ë¡§ ¿‘∑¬ √¢¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		j1.setSize(100,30);
		j1.setLocation(120,200);
				
		
	}
	
}
