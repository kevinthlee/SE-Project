package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class HelpScreen extends JPanel implements ActionListener {
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

	public HelpScreen() {
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
		 * helpText.setText(
		 * "\n\n\n\n\n\nLTE Vocabulary¥¬ øµæÓ ¥‹æÓ æœ±‚ «¡∑Œ±◊∑•¿‘¥œ¥Ÿ. \n±‚∫ª¿˚¿∏∑Œ æÀæ∆æﬂ«“ øµæÓ¥‹æÓ 2000∞≥∏¶ 100∞≥æø \n¿œ¬˜∫∞∑Œ ¡¶∞¯«œ∞Ì ¿÷¿∏∏Á ≈◊Ω∫∆Æ ∂««— ∞°¥…«’¥œ¥Ÿ. \n√ ∫∏¿⁄µÈµµ Ω±∞‘ ªÁøÎ«“ ºˆ ¿÷∞Ì ªÁøÎ¿⁄ø° ∏¬∞‘ ∆Ì¡˝∞˙ ¡§∑ƒ¿Ã \n¥ŸæÁ«œ∞‘ ∞°¥…«œπ«∑Œ øµæÓ¥‹æÓ∏¶ ∞¯∫Œ«œ¥¬µ• ¿ØøÎ«— «¡∑Œ±◊∑•¿‘¥œ¥Ÿ. \n\n∞≥πﬂ¿⁄ : 4G(Ω…«◊º∑, π⁄¡÷»Ø, ¡§Ω¬±§, ±Ë¿Ø∏≤, ¿Ã«ˆπŒ, ±Ë«ˆΩ¬)"
		 * ); helpText.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,15));
		 * helpText.setBackground(Color.GRAY);
		 * helpText.setForeground(Color.WHITE); contentPanel.add(helpText);
		 * add(contentPanel,BorderLayout.CENTER);
		 * 
		 * //button panel buttonPanel = new JPanel();
		 * buttonPanel.setBackground(Color.BLACK); exit = new JButton("≥™∞°±‚");
		 * buttonPanel.add(exit); exit.addActionListener(this);
		 * add(buttonPanel,BorderLayout.SOUTH);
		 */

		icon = new ImageIcon("img_menu/help_back.png");
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
		exit.setSize(30, 30);
		exit.setLocation(550, 20);

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.setSize(30, 30);
		back.setLocation(20, 20);

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
