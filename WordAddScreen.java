package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.regex.Pattern;

import javax.swing.*;

import leaf.Word;
import leaf.WordBook;

public class WordAddScreen extends JDialog implements ActionListener {

	ImageIcon icon;
	JPanel framePanel;
	JPanel contentPanel;
	JPanel buttonPanel;

	JLabel wordLabel;
	JLabel meanLabel;
	JLabel levelLabel;

	JTextField wordField;
	JTextField meanField;
	JTextField levelField;

	JButton addButton;

	Word addWord;
	WordBook wordBook;
	WordBookScreen wordBookScreen;

	public WordAddScreen(WordBook wordBook, WordBookScreen wordBookScreen) {

		icon = new ImageIcon("img_menu/add_word_back.png");
		this.wordBook = wordBook;
		this.wordBookScreen = wordBookScreen;

		setSize(600, 200);
		setTitle("add word");

		framePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		framePanel.setLayout(null);

		// content panel
		// contentPanel = new JPanel();
		// contentPanel.setBackground(Color.BLACK);

		wordLabel = new JLabel("¥‹æÓ:");
		wordLabel.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 20));
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setSize(50, 40);
		wordLabel.setLocation(100, 35);

		meanLabel = new JLabel("∂Ê:");
		meanLabel.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 20));
		meanLabel.setForeground(Color.WHITE);
		meanLabel.setSize(40, 40);
		meanLabel.setLocation(310, 35);

		levelLabel = new JLabel("¡÷¡¶:");
		levelLabel.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 20));
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setSize(70, 40);
		levelLabel.setLocation(430, 35);

		// 3∞≥¿« JTextField
		wordField = new JTextField(10);
		wordField.setSize(120, 30);
		wordField.setLocation(160, 40);

		meanField = new JTextField(10);
		meanField.setSize(120, 30);
		meanField.setLocation(350, 40);

		levelField = new JTextField(5);
		levelField.setSize(30, 30);
		levelField.setLocation(510, 40);
		levelField.setText("00");

		/*
		 * contentPanel.add(wordLabel); contentPanel.add(wordField);
		 * contentPanel.add(meanLabel); contentPanel.add(meanField);
		 * contentPanel.add(levelLabel); contentPanel.add(levelField);
		 * framePanel.add(contentPanel,BorderLayout.CENTER);
		 */

		framePanel.add(wordLabel);
		framePanel.add(wordField);
		framePanel.add(meanLabel);
		framePanel.add(meanField);
		//framePanel.add(levelLabel);
		//framePanel.add(levelField);

		// button panel
		// buttonPanel = new JPanel();
		// buttonPanel.setBackground(Color.BLACK);

		addButton = new JButton(new ImageIcon("img_menu/add_word.png"));
		addButton.addActionListener(this);
		addButton.setSize(40, 40);
		addButton.setLocation(280, 100);
		addButton.setBorderPainted(false);
		addButton.setFocusPainted(true);
		addButton.setContentAreaFilled(false);

		framePanel.add(addButton);

		// framePanel.add(buttonPanel,BorderLayout.SOUTH);

		this.add(framePanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}

	public Word getAddWord() {
		return addWord;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			addWord = new Word(wordField.getText(), meanField.getText(),
					levelField.getText());
			boolean engflag = Pattern.matches("^[a-zA-Z]*$", wordField.getText());
			boolean korflag = Pattern.matches("^[∞°-∆R]*$", meanField.getText());
			boolean numflag = Pattern.matches("^[0-9]{2}$", levelField.getText());
			System.out.println(engflag);
			System.out.println(korflag);
			System.out.println(numflag);
//			if((wordField.getText()==null)||(meanField.getText()==null)){
//				JOptionPane.showMessageDialog(this, "ø√πŸ∏£∞‘ ¿‘∑¬µ«¡ˆ æ æ“Ω¿¥œ¥Ÿ. ¿Á¿‘∑¬«ÿ¡÷ººø‰.");	
//			}
			if (engflag&&korflag) {
				if(wordField.getText().isEmpty()||meanField.getText().isEmpty()){
					JOptionPane.showMessageDialog(this, "ø√πŸ∏£∞‘ ¿‘∑¬µ«¡ˆ æ æ“Ω¿¥œ¥Ÿ. ¿Á¿‘∑¬«ÿ¡÷ººø‰.");	
				}else{
					//System.out.println(wordField.getText());
					//System.out.println(meanField.getText());
					
					wordBook.getWordsList().add(addWord);
					wordBook.refreshData();
					wordBookScreen.defaultTableModel.setDataVector(
							wordBook.getRowData(), wordBook.getColnames());
					JOptionPane.showMessageDialog(this, wordField.getText()+" ∞° ¥‹æÓ¿Âø° √ﬂ∞°µ«æ˙Ω¿¥œ¥Ÿ.");
				}
				dispose();
			} else {
				
				JOptionPane.showMessageDialog(this, "ø√πŸ∏£∞‘ ¿‘∑¬µ«¡ˆ æ æ“Ω¿¥œ¥Ÿ. ¿Á¿‘∑¬«ÿ¡÷ººø‰.");	
				dispose();
			}
			
		}

	}

}
