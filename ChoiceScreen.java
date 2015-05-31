package UI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ChoiceScreen extends JPanel implements ActionListener {
	ImageIcon icon;
	JButton word_study;
	JButton favorite;
	JButton test;
	JButton back;
	JButton exit;

	JPanel framePanel;
	JPanel buttonPanel;

	LearnScreen_e learnScreen_e;
	FavoriteScreen favoriteScreen;
	TestChoiceScreen testChoice;
	TestScreen testScreen;

	public ChoiceScreen() throws IOException {
		icon = new ImageIcon("img_menu/learning_back.png");
		setLayout(new BorderLayout());
		// setLayout(null);
		buttonPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		//buttonPanel.setBackground(Color.CYAN);
		//setBackground(Color.red);
		buttonPanel.setLayout(null);

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
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

		word_study = new JButton(new ImageIcon("img_menu/word_study.png"));
		word_study.setSize(210, 60);
		word_study.setLocation(200, 270);
		buttonPanel.add(word_study);
		// add(easy);

		favorite = new JButton(new ImageIcon("img_menu/favorite.png"));
		favorite.setSize(210, 60);
		favorite.setLocation(200, 340);
		buttonPanel.add(favorite);

		test = new JButton(new ImageIcon("img_menu/test.png"));
		test.setSize(210, 60);
		test.setLocation(200, 410);
		buttonPanel.add(test);
		/*
		 * middle = new JButton("¡ﬂ±ﬁ"); middle.setSize(200,100);
		 * middle.setLocation(200, 170); buttonPanel.add(middle); //add(middle);
		 */

		/*
		 * high = new JButton("∞Ì±ﬁ"); high.setSize(200,100);
		 * high.setLocation(200, 290); buttonPanel.add(high); //add(high);
		 */

		buttonPanel.add(back);
		buttonPanel.add(exit);
		// add(back);
		back.addActionListener(this);
		exit.addActionListener(this);
		word_study.addActionListener(this);
		favorite.addActionListener(this);
		test.addActionListener(this);

		add(buttonPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {

			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
		} else if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == word_study) {

			this.setVisible(false);
			if (learnScreen_e == null) {
				try {
					learnScreen_e = new LearnScreen_e();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				Main.getMenu().add(learnScreen_e);

			} else {
				learnScreen_e.setVisible(true);

			}

		} else if (e.getSource() == favorite) {

			this.setVisible(false);
			if (favoriteScreen == null) {
				try {
					favoriteScreen = new FavoriteScreen();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				Main.getMenu().add(favoriteScreen);

			} else {
				favoriteScreen.setVisible(true);

			}

		} else if (e.getSource() == test) {
			testChoice = new TestChoiceScreen();

			if (testChoice.getTestStartBool() == true) {
				testChoice.setTestStartBool(false);
				buttonPanel.setVisible(false);
				testScreen = new TestScreen();
				this.add(testScreen);
				testScreen.updateUI();
			}

		}
		/*
		 * else if(e.getSource() == middle){
		 * 
		 * this.setVisible(false); if(learnScreen_i==null){ try { learnScreen_i
		 * = new LearnScreen_i(); } catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); } Main.getMenu().add(learnScreen_i);
		 * 
		 * 
		 * 
		 * }else { learnScreen_i.setVisible(true);
		 * 
		 * }
		 * 
		 * }
		 */
		/*
		 * else if(e.getSource() == high){ this.setVisible(false);
		 * if(learnScreen_h==null){ try { learnScreen_h = new LearnScreen_h(); }
		 * catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); } Main.getMenu().add(learnScreen_h);
		 * 
		 * 
		 * 
		 * }else { learnScreen_h.setVisible(true);
		 * 
		 * } }
		 */
	}

	public LearnScreen_e getLearnScreen_e() {
		return learnScreen_e;
	}

	public FavoriteScreen getTagScreen_e() {
		return favoriteScreen;
	}

	public JPanel getFramePanel() {
		return framePanel;
	}

	public TestChoiceScreen getTestChoiceScreen() {
		return testChoice;
	}
}
