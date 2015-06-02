package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ResultScreen extends JPanel implements ActionListener {
	ImageIcon icon;
	JPanel titlePanel;
	JPanel contentPanel;
	JPanel buttonPanel;
	
	JButton back;
	JButton exit;

	JLabel titleLabel;
	JTextArea helpText;
	
	public ResultScreen(){
		icon = new ImageIcon("img_menu/result_back.png");
		setLayout(new BorderLayout());
		
		//title panel
		/*titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("Ω√«Ë∞·∞˙");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);*/
		
		//content panel
		
		
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
			
		
		contentPanel.setLayout(null);
		
		
		
		helpText = new JTextArea();
		helpText.setBounds(30, 150, 530, 400);// JTextArea ≈©±‚ π◊ ¿ßƒ° ¡ˆ¡§
		helpText.setEditable(false);
		showResultList();
		
		helpText.setFont(new Font("»ﬁ∏’∆Ì¡ˆ√º",Font.BOLD,13));
		helpText.setBackground(new Color(0, 0, 0, 10));
		//setBackground(new Color(0, 0, 0, 10));
		helpText.setForeground(Color.WHITE);
		contentPanel.add(helpText);
		
		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.addActionListener(this);
		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false);
		back.setFocusPainted(true);
		back.setContentAreaFilled(false);
		
		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setSize(50, 50);
		exit.setLocation(520, 20);
		
		back.addActionListener(this);
		exit.addActionListener(this);
		
		contentPanel.add(back);
		contentPanel.add(exit);
		
		
		
		
		add(contentPanel,BorderLayout.CENTER);
		
		
		
		//button panel
		/*buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		exit = new JButton("≥™∞°±‚");
		buttonPanel.add(exit);
		exit.addActionListener(this);
		add(buttonPanel,BorderLayout.SOUTH);*/
	}

	
	public void showResultList(){
		Scanner read = null;
		try {
			read = new Scanner(new BufferedReader(new FileReader("result.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(read.hasNext()){
			helpText.append(read.nextLine());
			helpText.append("\n");
		}
		read.close();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
			}
		if(e.getSource() == exit){
			System.exit(0);
		}
	}
}
