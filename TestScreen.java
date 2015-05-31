package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import leaf.Test;

public class TestScreen extends JPanel implements ActionListener{
	ImageIcon icon;
	JPanel titlePanel;
	
	JPanel testPanel;
	JPanel testNorthPanel;
	JPanel testCenterPanel;
	JPanel testSouthPanel;
	JPanel buttonPanel;
	
	JButton nextButton;
	
	JTextField answerField;
	JTextPane quizArea;
	JRadioButton answer1;
	JRadioButton answer2;
	JRadioButton answer3;
	JRadioButton answer4;
	JRadioButton answer5;
	JRadioButton dummyRadio;
	ButtonGroup multipleAnswer;
	
	
	JLabel titleLabel, nameLabel;
	
	JButton exit;
	
	Test test;
	
	public TestScreen() {
		
		setLayout(new BorderLayout());
		
		test = new Test(Main.getMenu().getChoiceScreen().getTestChoiceScreen().getTestType(), Main.getMenu().getChoiceScreen().getTestChoiceScreen().getSelectDay(), this);
		
		/*
		icon = new ImageIcon("img_menu/learning_back.png");
		setLayout(new BorderLayout());
		// setLayout(null);
		
		testPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		*/
		
		// title Panel
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("Test");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		
		nameLabel = new JLabel(" - "+test.getSelectedDay());
		nameLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		titlePanel.add(nameLabel);
		titlePanel.setPreferredSize(new Dimension(0,200));
		add(titlePanel,BorderLayout.NORTH);
		
		// test Panel
		testPanel = new JPanel();
		testPanel.setLayout(new BorderLayout());
		testSouthPanel = new JPanel();
		testSouthPanel.setBackground(Color.BLACK);
		testCenterPanel = new JPanel();
		testNorthPanel = new JPanel();
		testNorthPanel.setBackground(Color.BLACK);
		quizArea = new JTextPane();
		quizArea.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,40));
		quizArea.setEditable(false);
		testNorthPanel.setPreferredSize(new Dimension(0,150));
		testNorthPanel.add(quizArea);
		
		if(test.getTestType() == Test.TEST_TYPE_1){
			answerField = new JTextField(30);
			testCenterPanel.add(answerField);
		}else{
			answer1 = new JRadioButton("");
			answer2 = new JRadioButton("");
			answer3 = new JRadioButton("");
			answer4 = new JRadioButton("");
			answer5 = new JRadioButton("");
			dummyRadio = new JRadioButton();
			multipleAnswer = new ButtonGroup();
			multipleAnswer.add(answer1);
			multipleAnswer.add(answer2);
			multipleAnswer.add(answer3);
			multipleAnswer.add(answer4);
			multipleAnswer.add(answer5);
			multipleAnswer.add(dummyRadio);
			testCenterPanel.add(answer1);
			testCenterPanel.add(answer2);
			testCenterPanel.add(answer3);
			testCenterPanel.add(answer4);
			testCenterPanel.add(answer5);
		}
		
		nextButton = new JButton("¥Ÿ¿Ω");
		testSouthPanel.add(nextButton);
		nextButton.addActionListener(this);
		
		testPanel.add(testNorthPanel,BorderLayout.NORTH);
		testPanel.add(testCenterPanel,BorderLayout.CENTER);
		testPanel.add(testSouthPanel,BorderLayout.SOUTH);
		add(testPanel,BorderLayout.CENTER);
		
		// button Panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		exit = new JButton("≥™∞°±‚");
		exit.addActionListener(this);
		buttonPanel.add(exit);
		
		add(buttonPanel,BorderLayout.SOUTH);
		
		//Ω√«ËΩ√¿€
		test.submitQuiz();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			test.endTest();
			Main.getMenu().remove(this);
			Main.getMenu().getFramePanel().setVisible(true);
		}else if(e.getSource() == nextButton){
			
			test.checkAnswer();
			test.submitQuiz();
			
		}
	}
	
	public JRadioButton getAnswer1(){
		return answer1;
	}
	
	public JRadioButton getAnswer2(){
		return answer2;
	}
	
	public JRadioButton getAnswer3(){
		return answer3;
	}
	
	public JRadioButton getAnswer4(){
		return answer4;
	}
	
	public JRadioButton getAnswer5(){
		return answer5;
	}
	
	public JRadioButton getDummyRadio(){
		return dummyRadio;
	}
	
	public JTextPane getQuizArea(){
		return quizArea;
	}
	
	public JTextField getAnswerField(){
		return answerField;
	}

}
