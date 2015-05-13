package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.event.*;

	
	public class main_back extends JPanel {
		ImageIcon back = new ImageIcon("images/back.png"); // πË∞Ê»≠∏Ìø° ≥÷¿ª ¿ÃπÃ¡ˆ ∞°¡Æø¿±‚
		Image img = back.getImage();
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);//πË∞Ê»≠∏Èø° ≥÷¿ª ¿ÃπÃ¡ˆ ¿ßƒ° º≥¡§
			
			
			g.setColor(new Color(255,255,255)); // πË∞Êø° ≥÷¿ª ±€¿⁄ ªˆªÛ
			g.setFont(new Font("Bodoni Bd BT",Font.ITALIC,50));// Georgia ±€≤√, BOLD ∆˘∆Æ, ±€¿⁄≈©±‚ 30
			g.drawString("Main", 125, 50); //πË∞Êø° ≥÷¿ª ±€¿⁄ æ≤±‚, ∞°∑Œ¿ßƒ°,ºº∑Œ¿ßƒ°
				
		}

	}


