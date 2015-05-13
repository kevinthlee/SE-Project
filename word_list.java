package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; 
import javax.swing.event.*;



public class word_list {
	public static void main(String [] args){
			
		JFrame word_list = new JFrame();//JFrame main ª˝º∫
		word_list.setResizable(false);//«¡∑π¿” ∞Ì¡§
		//main.setUndecorated(true);//«¡∑π¿” ∞°¿Â¿⁄∏Æ º˚±Ë
		
		
		
		//πË∞Ê ¿ÃπÃ¡ˆ ª¿‘	
		word_list.setTitle("¿ŸªÁ±Õ");
		word_list.setSize(355,425);//∞°∑Œ 350 ºº∑Œ 400
		word_list.setVisible(true);
		
		word_list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = word_list.getContentPane();
		word_list_back panel = new word_list_back();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(350,400);
		panel.setVisible(true);//πË∞Ê»≠∏Èø° ui_back¿ª ª¿‘
		
		//panel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
				
		
		word_list.setLayout(null); // πˆ∆∞ ª¿‘¿ª Layout ∞™ null ≥Î∞°¥Ÿ∑Œ «—¥Ÿ.
		
		// ¡æ∑·«œ±‚ πˆ∆∞
		ImageIcon normalIcon1 = new ImageIcon("images/exit.png"); // ¡æ∑· πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b1 = new JButton(normalIcon1);// JButton b1¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b1.setSize(30,30);
		b1.setLocation(310,5);
		panel.add(b1);//b1 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		
		//JList ??? or JText ??? I/O ƒ⁄¥ıøÕ ªÛ¿« »ƒ ∞·¡§
		
		
		
		
	}
}
