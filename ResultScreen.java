package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	
	JLabel titleLabel;
	JTextArea helpText;
	JButton exit;

	
	public ResultScreen(){
		
		setLayout(new BorderLayout());
		
		//title panel
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("Ω√«Ë∞·∞˙");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);
		
		//content panel
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.GRAY);
		helpText = new JTextArea();
		helpText.setEditable(false);
		showResultList();
		
		helpText.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,13));
		helpText.setBackground(Color.GRAY);
		helpText.setForeground(Color.WHITE);
		contentPanel.add(helpText);
		add(contentPanel,BorderLayout.CENTER);
		
		//button panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		exit = new JButton("≥™∞°±‚");
		buttonPanel.add(exit);
		exit.addActionListener(this);
		add(buttonPanel,BorderLayout.SOUTH);
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
		if(e.getSource() == exit){
			
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
			
		}
	}
}
