package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*;



public class main {
	public static void main(String [] args){
			
		JFrame main = new JFrame();//JFrame main ª˝º∫
		main.setResizable(false);//«¡∑π¿” ∞Ì¡§
		//main.setUndecorated(true);//«¡∑π¿” ∞°¿Â¿⁄∏Æ º˚±Ë
		
		
		
		//πË∞Ê ¿ÃπÃ¡ˆ ª¿‘	
		main.setTitle("¿ŸªÁ±Õ");
		main.setSize(355,425);//∞°∑Œ 350 ºº∑Œ 400
		main.setVisible(true);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = main.getContentPane();
		main_back panel = new main_back();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(350,400);
		panel.setVisible(true);//πË∞Ê»≠∏Èø° ui_back¿ª ª¿‘
		
		//panel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
				
		
		main.setLayout(null); // πˆ∆∞ ª¿‘¿ª Layout ∞™ null ≥Î∞°¥Ÿ∑Œ «—¥Ÿ.
		
		// «–Ω¿«œ±‚ πˆ∆∞
		ImageIcon normalIcon1 = new ImageIcon("images/learning.png"); // «–Ω¿«œ±‚ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b1 = new JButton(normalIcon1);// JButton b1¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b1.setSize(150,43);
		b1.setLocation(100,80);
		panel.add(b1);//b1 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//√ﬂ∞°¥‹æÓ ∏ÆΩ∫∆Æ πˆ∆∞
		ImageIcon normalIcon2 = new ImageIcon("images/list.png"); // √ﬂ∞°¥‹æÓ ∏ÆΩ∫∆Æ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b2 = new JButton(normalIcon2);// JButton b2¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b2.setSize(150,43);
		b2.setLocation(100,128);
		panel.add(b2);//b2 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//«–Ω¿≈Î∞Ë πˆ∆∞
		ImageIcon normalIcon3 = new ImageIcon("images/static.png"); // «–Ω¿≈Î∞Ë πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b3 = new JButton(normalIcon3);// JButton b3¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b3.setSize(150,43);
		b3.setLocation(100,176);
		panel.add(b3);//b2 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//«¡∑Œ±◊∑• ¡§∫∏
		ImageIcon normalIcon4 = new ImageIcon("images/information.png"); // «¡∑Œ±◊∑• ¡§∫∏ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b4 = new JButton(normalIcon4);// JButton b4¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b4.setSize(150,43);
		b4.setLocation(100,224);
		panel.add(b4);//b4 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//µµøÚ∏ª
		ImageIcon normalIcon5 = new ImageIcon("images/help.png"); // µµøÚ∏ª πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b5 = new JButton(normalIcon5);// JButton b5¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b5.setSize(150,43);
		b5.setLocation(100,272);
		panel.add(b5);//b5 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//¡æ∑·πˆ∆∞
		ImageIcon normalIcon6 = new ImageIcon("images/exit.png"); // ¡æ∑· πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b6 = new JButton(normalIcon6);// JButton b6¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b6.setSize(30,30);
		b6.setLocation(310,5);
		panel.add(b6);//b6 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
	}
	
}
