package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ProgramScreen extends JPanel implements ActionListener {
	/*
	 * JPanel titlePanel; JPanel contentPanel; JPanel buttonPanel;
	 * 
	 * JLabel titleLabel; JTextPane helpText; JButton exit;
	 */
	ImageIcon icon;
	JButton back;
	JButton exit;

	JPanel framePanel;
	JPanel buttonPanel;

	public ProgramScreen() {
		/*
		 * setLayout(new BorderLayout());
		 * 
		 * //title panel titlePanel = new JPanel();
		 * titlePanel.setBackground(Color.BLACK); titleLabel = new
		 * JLabel("µµøÚ∏ª"); titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		 * titleLabel.setForeground(Color.WHITE); titlePanel.add(titleLabel);
		 * add(titlePanel,BorderLayout.NORTH);
		 * 
		 * //content panel contentPanel = new JPanel();
		 * contentPanel.setBackground(Color.GRAY); helpText = new JTextPane();
		 * helpText.setText("\n\n\n\n\n\n\n\n∞≥πﬂ¿⁄ : ≥ øÔ∞°¡ˆ"); helpText.setFont(new
		 * Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,15)); helpText.setBackground(Color.GRAY);
		 * helpText.setForeground(Color.WHITE); contentPanel.add(helpText);
		 * add(contentPanel,BorderLayout.CENTER);
		 * 
		 * //button panel buttonPanel = new JPanel();
		 * buttonPanel.setBackground(Color.BLACK); exit = new JButton("≥™∞°±‚");
		 * buttonPanel.add(exit); exit.addActionListener(this);
		 * add(buttonPanel,BorderLayout.SOUTH);
		 */

		icon = new ImageIcon("img_menu/information_back_1.png");
		setLayout(new BorderLayout());
		// setLayout(null);
		buttonPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(),
						this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		buttonPanel.setBackground(Color.CYAN);
		setBackground(Color.red);
		buttonPanel.setLayout(null);

		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.setSize(50, 50);
		exit.setLocation(520, 20);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
				

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);

		buttonPanel.add(back);
		buttonPanel.add(exit);
		
		// add(back);
		
		back.addActionListener(this);
		exit.addActionListener(this);

		add(buttonPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == back) {
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);

		}
	}

}
