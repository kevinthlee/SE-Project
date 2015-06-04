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
import leaf.WordBook;

public class TestScreen extends JPanel implements ActionListener {
	ImageIcon icon;

	// JPanel titlePanel;
	JPanel testPanel;
	JPanel testNorthPanel;
	JPanel testCenterPanel;
	JPanel testSouthPanel;
	JPanel buttonPanel;

	JButton nextButton;
	JButton back;
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
		test = new Test(Main.getMenu().getChoiceScreen().getTestChoiceScreen()
				.getTestType(), Main.getMenu().getChoiceScreen()
				.getTestChoiceScreen().getSelectDay(), this);
		
		icon = new ImageIcon("img_menu/test_back.png");

		// setLayout(new BorderLayout());
		// setLayout(null);

		testPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		testPanel.setLayout(new BorderLayout());
		testPanel.setLayout(null);

		// title Panel
		/*
		 * titlePanel = new JPanel(); titlePanel.setBackground(Color.BLACK);
		 * titleLabel = new JLabel("Test"); titleLabel.setFont(new
		 * Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25)); titleLabel.setForeground(Color.WHITE);
		 */

		nameLabel = new JLabel(test.getSelectedDay());
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		nameLabel.setSize(150, 40);
		nameLabel.setLocation(250, 130);

		testPanel.add(nameLabel);

		// testPanel.setPreferredSize(new Dimension(0,200));

		// test Panel

		/*
		 * testSouthPanel = new JPanel();
		 * testSouthPanel.setBackground(Color.BLACK); testCenterPanel = new
		 * JPanel(); testNorthPanel = new JPanel();
		 * testNorthPanel.setBackground(Color.BLACK);
		 */

		quizArea = new JTextPane();
		quizArea.setForeground(Color.BLACK);
		quizArea.setBackground(null);
		quizArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 35));
		quizArea.setEditable(false);
		quizArea.setSize(500, 120);
		quizArea.setLocation(50, 180);

		testPanel.add(quizArea);

		// testNorthPanel.setPreferredSize(new Dimension(0,150));
		System.out.println(test.getTestType());
		if (test.getTestType() == Test.TEST_TYPE_1) {
			answerField = new JTextField(70);
			answerField.setSize(150, 30);
			answerField.setLocation(225, 340);
			testPanel.add(answerField);
		} else {
			answer1 = new JRadioButton("");
			answer1.setSize(200, 30);
			answer1.setLocation(50, 310);
			answer1.setContentAreaFilled(false);

			answer2 = new JRadioButton("");
			answer2.setSize(200, 30);
			answer2.setLocation(50, 350);
			answer2.setContentAreaFilled(false);

			answer3 = new JRadioButton("");
			answer3.setSize(200, 30);
			answer3.setLocation(50, 390);
			answer3.setContentAreaFilled(false);

			answer4 = new JRadioButton("");
			answer4.setSize(200, 30);
			answer4.setLocation(50, 430);
			answer4.setContentAreaFilled(false);

			answer5 = new JRadioButton("");
			answer5.setSize(200, 30);
			answer5.setLocation(50, 470);
			answer5.setContentAreaFilled(false);

			dummyRadio = new JRadioButton();

			multipleAnswer = new ButtonGroup();
			multipleAnswer.add(answer1);
			multipleAnswer.add(answer2);
			multipleAnswer.add(answer3);
			multipleAnswer.add(answer4);
			multipleAnswer.add(answer5);
			multipleAnswer.add(dummyRadio);

			testPanel.add(answer1);
			testPanel.add(answer2);
			testPanel.add(answer3);
			testPanel.add(answer4);
			testPanel.add(answer5);
		}

		nextButton = new JButton(new ImageIcon("img_menu/check.png"));

		nextButton.setBorderPainted(false);
		nextButton.setFocusPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setSize(50, 50);
		nextButton.setLocation(275, 500);

		testPanel.add(nextButton);
		nextButton.addActionListener(this);

		/*
		 * testPanel.add(testNorthPanel,BorderLayout.NORTH);
		 * testPanel.add(testCenterPanel,BorderLayout.CENTER);
		 * testPanel.add(testSouthPanel,BorderLayout.SOUTH);
		 */
		add(testPanel, BorderLayout.CENTER);

		// button Panel
		// buttonPanel = new JPanel();
		// buttonPanel.setBackground(Color.BLACK);

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.addActionListener(this);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setSize(50, 50);
		back.setLocation(20, 20);
		testPanel.add(back);

		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.addActionListener(this);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setSize(50, 50);
		exit.setLocation(520, 20);
		testPanel.add(exit);

		// add(buttonPanel,BorderLayout.SOUTH);

		// Ω√«ËΩ√¿€
		test.submitQuiz();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean check = false;
		if (e.getSource() == back) {
			test.endTest();
			this.setVisible(false);
			
			// Main.getMenu().getFramePanel().setVisible(true);
		} else if (e.getSource() == nextButton) {

			test.checkAnswer();
			check = test.submitQuiz();
		}
		if (check)
			this.setVisible(false);
		else if (e.getSource() == exit) {

			System.exit(0);
		}
	}

	public JRadioButton getAnswer1() {
		return answer1;
	}

	public JRadioButton getAnswer2() {
		return answer2;
	}

	public JRadioButton getAnswer3() {
		return answer3;
	}

	public JRadioButton getAnswer4() {
		return answer4;
	}

	public JRadioButton getAnswer5() {
		return answer5;
	}

	public JRadioButton getDummyRadio() {
		return dummyRadio;
	}

	public JTextPane getQuizArea() {
		return quizArea;
	}

	public JTextField getAnswerField() {
		return answerField;
	}

}
