package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.StringTokenizer;

import leaf.WordBook;

//import TOP.WordBook;

public class LearnScreen_e extends JPanel implements ActionListener {

	// JTextArea t;
	// TextArea w;

	JLabel titleLabel;
	
	JPanel mPanel;
	JPanel titlePanel;
	JPanel lPanel;
	JPanel rPanel;
	JPanel footPanel;

	JButton tagButton;
	JButton testButton;
	JButton addButton;
	JButton exitButton;
	JButton back;
	JButton exit;
	JButton deletButton;

	WordBook wordBook;

	WordAddScreen wordAddScreen;

	TestChoiceScreen testChoice;
	TestScreen testScreen;

	JScrollPane wordView;
	JTable wordViewTable;
	DefaultTableModel defaultTableModel;
	JComboBox wordsBookList;
	JButton wordsBookOK;

	ImageIcon icon;
	ImageIcon icon_left;
	ImageIcon icon_right;
	ImageIcon star;

	public LearnScreen_e() throws IOException {
		icon = new ImageIcon("k.png");
		wordBook = new WordBook();
		setLayout(new BorderLayout());

		
		titlePanel = new JPanel();
		/*titlePanel.setBackground();
		titleLabel = new JLabel(new ImageIcon(""));
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		
		add(titlePanel, BorderLayout.NORTH);*/

		// mPanel.add(titlePanel,BorderLayout.NORTH);

		lPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				icon_left = new ImageIcon("img_menu/word_study_back_left.png");
				g.drawImage(icon_left.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		lPanel.setLayout(null);
		lPanel.setBackground(Color.blue);

		rPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				icon_right = new ImageIcon("img_menu/word_study_back_right.png");
				g.drawImage(icon_right.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		rPanel.setBackground(Color.orange);
		rPanel.setLayout(null);
		rPanel.setPreferredSize(new Dimension(190, 50));

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		
		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.setBorderPainted(false);
		exit.setFocusPainted(true);
		exit.setContentAreaFilled(false);
		
				
		lPanel.add(back);
		rPanel.add(exit);

		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false);
		back.setFocusPainted(true);
		back.setContentAreaFilled(false);

		
		
		
		exit.setSize(50, 50);
		exit.setLocation(130, 20);

		// t = new JTextArea("");
		// w = new TextArea("");
		// JScrollPane scroll = new JScrollPane(t);
		// scroll.setLocation(20, 180);
		// w.setSize(300,300);
		// w.setLocation(50, 50);
		// lPanel.add(w);

		wordsBookList = new JComboBox(WordBook.wordBookList());
		wordsBookList.setSize(100, 50);
		wordsBookList.setLocation(0, 150);

		wordsBookOK = new JButton(new ImageIcon("img_menu/check.png"));
		wordsBookOK.setBorderPainted(false);
		wordsBookOK.setFocusPainted(true);
		wordsBookOK.setContentAreaFilled(false);
		wordsBookOK.setSize(60, 40);
		wordsBookOK.setLocation(110, 150);

		rPanel.add(wordsBookOK);
		rPanel.add(wordsBookList);
		// footPanel.add(wordsBookOK);
		wordsBookOK.addActionListener(this);

		wordBook.loadWords("wordBooks/"
				+ wordsBookList.getSelectedItem().toString());
		defaultTableModel = new DefaultTableModel(wordBook.getRowData(),
				wordBook.getColnames());
		wordViewTable = new JTable(defaultTableModel);
		wordViewTable.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(wordViewTable.getModel());
		wordViewTable.setRowSorter(sorter);
		wordView = new JScrollPane(wordViewTable);
		wordView.setSize(350, 480);
		wordView.setLocation(25, 100);
		lPanel.add(wordView);

		add(lPanel, BorderLayout.CENTER);

		// mPanel.add(lPanel,BorderLayout.CENTER);

		tagButton = new JButton(new ImageIcon("img_menu/star_1.png"));
		tagButton.setBorderPainted(false);
		tagButton.setFocusPainted(true);
		tagButton.setContentAreaFilled(false);
		tagButton.setSize(100, 100);
		tagButton.setLocation(15, 220);
		/*
		 * addButton = new JButton("√ﬂ∞°"); addButton.setSize(130,60);
		 * addButton.setLocation(20, 300); testButton = new JButton("TEST");
		 * testButton.setSize(130,60); testButton.setLocation(20,160);
		 * deletButton = new JButton("ªË¡¶"); deletButton.setSize(130,60);
		 * deletButton.setLocation(20,230); exitButton = new JButton("≥™∞°±‚");
		 * exitButton.setSize(130,60); exitButton.setLocation(20,320);
		 */

		rPanel.add(tagButton);
		/*
		 * rPanel.add(addButton); rPanel.add(testButton);
		 * rPanel.add(deletButton);
		 */
		// rPanel.add(exitButton);

		tagButton.addActionListener(this);
		/*
		 * addButton.addActionListener(this);
		 * testButton.addActionListener(this);
		 * deletButton.addActionListener(this);
		 */
		// exitButton.addActionListener(this);

		add(rPanel, BorderLayout.EAST);

		// mPanel.add(rPanel,BorderLayout.EAST);

		footPanel = new JPanel();
		footPanel.setBackground(Color.red);

		back.addActionListener(this);
		exit.addActionListener(this);

		// add(footPanel,BorderLayout.SOUTH);

		// mPanel.add(footPanel,BorderLayout.SOUTH);
		// add(mPanel,BorderLayout.CENTER);

	}

	/*public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}*/

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tagButton) {
			if (1 <= wordViewTable.getSelectedColumnCount()) {
				wordBook.addTag(wordBook.getWordsList().get(
						wordViewTable.getSelectedRow()));
				JOptionPane.showMessageDialog(this, "≈¬±◊ø° √ﬂ∞°µ«æ˙Ω¿¥œ¥Ÿ.");
			}
		} else if (e.getSource() == wordsBookOK) {
			try {
				wordBook.loadWords("wordBooks/"
						+ wordsBookList.getSelectedItem().toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(),
					wordBook.getColnames());

		}/*
		 * else if(e.getSource() == addButton){ wordAddScreen = new
		 * WordAddScreen_e(wordBook,this);
		 * 
		 * 
		 * }else if(e.getSource() == testButton){ testChoice = new
		 * TestChoiceScreen_e();
		 * 
		 * if(testChoice.getTestStartBool() == true){
		 * testChoice.setTestStartBool(false); this.setVisible(false);
		 * 
		 * testScreen = new TestScreen_e(); Main.getMenu().add(testScreen); }
		 * 
		 * }else if(e.getSource() == deletButton){ if(1 <=
		 * wordViewTable.getSelectedColumnCount()){ String str =
		 * wordBook.getWordsList
		 * ().get(wordViewTable.getSelectedRow()).word.toString();
		 * if(str.charAt(0)=='*'){
		 * wordBook.deleteWord(this.wordsBookList.getSelectedItem
		 * ().toString(),wordBook
		 * .getWordsList().get(wordViewTable.getSelectedRow()));
		 * JOptionPane.showMessageDialog(this,"±‚∫ª¥‹æÓ¿Âø°º≠ ªË¡¶µ«æ˙Ω¿¥œ¥Ÿ."); }else
		 * JOptionPane.showMessageDialog(this,"±‚∫ª¥‹æÓ¥¬ ªË¡¶ ∫“∞°¥…¿‘¥œ¥Ÿ!!"); } }
		 */else if (e.getSource() == back) {
			this.setVisible(false);
			Main.getMenu().getChoiceScreen().setVisible(true);

		} else if (e.getSource() == exit) {
			System.exit(0);
		}
	}

	public TestChoiceScreen getTestChoiceScreen_e() {
		return testChoice;
	}
}
