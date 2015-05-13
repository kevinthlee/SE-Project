package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class learning {
	public static void main(String [] args){
		
		JFrame learning = new JFrame();//JFrame main ª˝º∫
		learning.setResizable(false);//«¡∑π¿” ∞Ì¡§
		
		
		learning.setTitle("¿ŸªÁ±Õ");
		learning.setSize(355,425);//∞°∑Œ 350 ºº∑Œ 400
		learning.setVisible(true);
		
		learning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//πË∞Ê ¿ÃπÃ¡ˆ ª¿‘
		Container contentPane = learning.getContentPane();
		learning_back panel = new learning_back();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setSize(350,400);
		panel.setVisible(true);//πË∞Ê»≠∏Èø° learning_back ¿ÃπÃ¡ˆ∏¶ ª¿‘
		
		//¥‹æÓ«–Ω¿ πˆ∆∞ ∫“∑Øø¿±‚
		ImageIcon normalIcon1 = new ImageIcon("images/word_learning.png"); // ¥‹æÓ«–Ω¿ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b1 = new JButton(normalIcon1);// JButton b1¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b1.setSize(150,43);
		b1.setLocation(100,110);
		panel.add(b1);//b1 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//¡Ò∞‹√£±‚ πˆ∆∞ ∫“∑Øø¿±‚
		ImageIcon normalIcon2 = new ImageIcon("images/favorite.png"); //¡Ò∞‹√£±‚ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b2 = new JButton(normalIcon2);// JButton b2¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b2.setSize(150,43);
		b2.setLocation(100,163);
		panel.add(b2);//b2 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//≈◊Ω∫∆Æ πˆ∆∞ ∫“∑Øø¿±‚
		ImageIcon normalIcon3 = new ImageIcon("images/test.png"); //¡Ò∞‹√£±‚ πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b3 = new JButton(normalIcon3);// JButton b3¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b3.setSize(150,43);
		b3.setLocation(100,216);
		panel.add(b3);//b3 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		//¡æ∑·πˆ∆∞ ∫“∑Øø¿±‚
		ImageIcon normalIcon4 = new ImageIcon("images/exit.png"); // ¡æ∑· πˆ∆∞ ¿ÃπÃ¡ˆ ∫“∑Øø¿±‚
		JButton b4 = new JButton(normalIcon4);// JButton b6¿« º±æ∞˙ ∫“æÓø¬ ¿ÃπÃ¡ˆ ª¿‘ 
		b4.setSize(30,30);
		b4.setLocation(310,5);
		panel.add(b4);//b6 πˆ∆∞¿ª ƒ¡≈Ÿ∆Æ ∆“ø° ∫Œ¬¯
		
		
		
		
	}

}
