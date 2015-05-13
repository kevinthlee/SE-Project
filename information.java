package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*;



public class information {
	public static void main(String [] args){
			
		JFrame information = new JFrame();//JFrame main ª˝º∫
		information.setResizable(false);//«¡∑π¿” ∞Ì¡§
		//main.setUndecorated(true);//«¡∑π¿” ∞°¿Â¿⁄∏Æ º˚±Ë
		
		
		
		//πË∞Ê ¿ÃπÃ¡ˆ ª¿‘	
		information.setTitle("¿ŸªÁ±Õ");
		information.setSize(355,425);//∞°∑Œ 350 ºº∑Œ 400
		information.setVisible(true);
		
		information.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = information.getContentPane();
		information_back panel = new information_back();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(350,400);
		panel.setVisible(true);//πË∞Ê»≠∏Èø° ui_back¿ª ª¿‘
		
		//panel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
				
		
		information.setLayout(null); // πˆ∆∞ ª¿‘¿ª Layout ∞™ null ≥Î∞°¥Ÿ∑Œ «—¥Ÿ.
		
		// ¡æ∑·«œ±‚ πˆ∆∞
		ImageIcon normalIcon1 = new ImageIcon("images/exit.png"); // ¡æ∑· πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b1 = new JButton(normalIcon1);// JButton b1¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b1.setSize(30,30);
		b1.setLocation(310,5);
		panel.add(b1);//b1 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
				
	}
	
	public static class information_back extends JPanel {
		ImageIcon back = new ImageIcon("images/information_back.png"); // πË∞Ê»≠∏Ìø° ≥÷¿ª ¿ÃπÃ¡ˆ ∞°¡Æø¿±‚
		Image img = back.getImage();
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);//πË∞Ê»≠∏Èø° ≥÷¿ª ¿ÃπÃ¡ˆ ¿ßƒ° º≥¡§
			
			
			g.setColor(new Color(255,255,255)); // πË∞Êø° ≥÷¿ª ±€¿⁄ ªˆªÛ
			g.setFont(new Font("Bodoni Bd BT",Font.ITALIC,50));
			g.drawString("Information", 45, 50); //πË∞Êø° ≥÷¿ª ±€¿⁄ æ≤±‚, ∞°∑Œ¿ßƒ°,ºº∑Œ¿ßƒ°
				
		}
	}
		
}

