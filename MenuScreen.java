package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuScreen extends JFrame implements ActionListener {
	ImageIcon icon;

	JButton learning;
	JButton wordbook;
	JButton result;
	JButton program;
	JButton help;
	JButton exit;

	// JButton startTest;
	// JButton showScore;

	JPanel framePanel;
	JPanel menuPanel;
	JPanel buttonPanel;
	
	// JPanel titlePanel;
	// JPanel northPanel;
	// JPanel buttonPanel;

	// ImageIcon title;
	// JLabel titleLabel;

	ChoiceScreen choiceScreen;
	WordBookScreen wordBookScreen;
	ResultScreen resultScreen;
	ProgramScreen programScreen;
	HelpScreen helpScreen;

	TestChoiceScreen testChoice;
	TestScreen testScreen;

	public MenuScreen() {	
		
		// frame
		setSize(600, 630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("¿ŸªÁ±Õ Main");
		setLayout(new BorderLayout());
		
		
		// frame panel
        framePanel = new JPanel() {
	    public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	       }
        };
        framePanel.setLayout(new BorderLayout());

		icon = new ImageIcon("Img_menu/main_menu.png");
		
		

		menuPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.pink);

		learning = new JButton(new ImageIcon("img_menu/learning.png"));
		learning.setSize(210, 60);
		learning.setLocation(200, 200);

		wordbook = new JButton(new ImageIcon("img_menu/list.png"));
		wordbook.setSize(210, 60);
		wordbook.setLocation(200, 270);

		// Graph ¥‹√ﬂ ¿⁄∏Æ
		result = new JButton(new ImageIcon("img_menu/result.png"));
		result.setSize(210, 60);
		result.setLocation(200, 340);

		// Program ¥‹√ﬂ ¿⁄∏Æ
		program = new JButton(new ImageIcon("img_menu/information.png"));
		program.setSize(210, 60);
		program.setLocation(200, 410);

		help = new JButton(new ImageIcon("img_menu/help.png"));
		help.setSize(210, 60);
		help.setLocation(200, 480);
		
		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setSize(50, 50);
		exit.setLocation(520, 20);

		// wrongWordButton = new JButton("ø¿¥‰≥Î∆Æ");
		// wrongWordButton.setSize(200,100);
		// wrongWordButton.setLocation(200, 290);

		// ResultButton = new JButton("TEST ∞·∞˙");
		// ResultButton.setSize(200,100);
		// ResultButton.setLocation(200,410);

		// menuPanel.add(wrongWordButton);
		menuPanel.add(learning);
		menuPanel.add(wordbook);
		menuPanel.add(result);
		menuPanel.add(program);
		menuPanel.add(help);
		menuPanel.add(exit);

		learning.addActionListener(this);
		wordbook.addActionListener(this);
		result.addActionListener(this);
		program.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
		
		framePanel.add(menuPanel, BorderLayout.CENTER);

		this.add(framePanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		}else if (e.getSource() == learning) {
			framePanel.setVisible(false);
			if (choiceScreen == null) {
				try {
					choiceScreen = new ChoiceScreen();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.add(choiceScreen);
			} else {
				this.add(choiceScreen);
				// choiceScreen.updateUI();
				choiceScreen.setVisible(true);
			}

		} else if (e.getSource() == wordbook) {
			framePanel.setVisible(false);
			if (wordBookScreen == null) {
				try {
					wordBookScreen = new WordBookScreen();
					this.add(wordBookScreen);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				wordBookScreen.setVisible(true);
			}
		} else if (e.getSource() == result) {

			framePanel.setVisible(false);

			if (resultScreen == null) {
				resultScreen = new ResultScreen();
				this.add(resultScreen);
				resultScreen.updateUI();
			} else {
				resultScreen.setVisible(true);
			}

		} else if (e.getSource() == program) {

			framePanel.setVisible(false);

			if (programScreen == null) {
				programScreen = new ProgramScreen();
				this.add(programScreen);
				programScreen.updateUI();
			} else {
				programScreen.setVisible(true);
			}

		} else if (e.getSource() == help) {

			framePanel.setVisible(false);

			if (helpScreen == null) {
				helpScreen = new HelpScreen();
				this.add(helpScreen);
				helpScreen.updateUI();
			} else {
				helpScreen.setVisible(true);
			}

		}
	}

	public JPanel getFramePanel() {
		return framePanel;
	}

	public TestChoiceScreen getTestChoiceScreen() {
		return testChoice;
	}

	public ChoiceScreen getChoiceScreen() {
		return choiceScreen;
	}

}
