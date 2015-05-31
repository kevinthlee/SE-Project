package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import leaf.WordBook;

public class FavoriteScreen extends JPanel implements ActionListener {
	ImageIcon icon;

	// title
	JPanel titlePanel;
	JLabel titleLabel;

	// content
	JPanel contentPanel;
	// ∏ÆΩ∫∆Æ,»Æ¿Œ,¡§∑ƒ...
	JPanel contentNorthPanel;
	// ∞Àªˆ√¢,∞Àªˆπˆ∆∞,√ﬂ∞°,ªË¡¶,≈¬±◊
	JPanel contentCenterPanel;
	// ¥‹æÓ∏Ò∑œ
	JPanel contentSouthPanel;
	JComboBox wordsBookList;
	JButton wordsBookOK;
	JLabel arrayLabel;
	JButton deleteButton;
	JButton tagViewButton;
	JScrollPane wordView;
	JTable wordViewTable;
	DefaultTableModel defaultTableModel;
	JButton back;

	// foot
	JPanel footPanel;
	JButton exit;
	WordBook wordBook;
	WordAddScreen wordAddScreen;

	public FavoriteScreen() throws IOException {

		icon = new ImageIcon("img_menu/bookmark_back.png");
		wordBook = new WordBook();
		setLayout(new BorderLayout());

		// content panel
		contentPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		contentPanel.setLayout(null);

		// title panel
		// titlePanel = new JPanel();
		// titlePanel.setBackground(Color.BLACK);

		titleLabel = new JLabel();

		// titleLabel.setFont(new Font("Bodoni Bd BT",Font.ITALIC,40));
		// titleLabel.setForeground(Color.WHITE);
		// contentPanel.add(titleLabel);
		// add(contentPanel,BorderLayout.NORTH);

		// content panel

		// contentNorthPanel = new JPanel();
		// wordsBookList = new JComboBox(WordBook.wordBookList());

		/*
		 * contentCenterPanel = new JPanel() { public void
		 * paintComponent(Graphics g) { g.drawImage(icon.getImage(), 0, 0,
		 * null); setOpaque(false); super.paintComponent(g); } };
		 */

		/*
		 * contentSouthPanel = new JPanel() { public void
		 * paintComponent(Graphics g) { g.drawImage(icon.getImage(), 0, 0,
		 * null); setOpaque(false); super.paintComponent(g); } };
		 */

		tagViewButton = new JButton(new ImageIcon("img_menu/refresh.png"));
		tagViewButton.addActionListener(this);
		tagViewButton.setSize(80, 80);
		tagViewButton.setLocation(450, 160);
		tagViewButton.setBorderPainted(false);
		tagViewButton.setFocusPainted(true);
		tagViewButton.setContentAreaFilled(false);

		deleteButton = new JButton(new ImageIcon("img_menu/delete.png"));
		deleteButton.addActionListener(this);
		deleteButton.setSize(80, 80);
		deleteButton.setLocation(450, 270);
		deleteButton.setBorderPainted(false);
		deleteButton.setFocusPainted(true);
		deleteButton.setContentAreaFilled(false);

		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.addActionListener(this);
		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false);
		back.setFocusPainted(true);
		back.setContentAreaFilled(false);

		contentPanel.add(back);
		contentPanel.add(tagViewButton);
		contentPanel.add(deleteButton);

		wordBook.loadWords("tag.txt");
		defaultTableModel = new DefaultTableModel(wordBook.getRowData(),
				wordBook.getColnames());
		wordViewTable = new JTable(defaultTableModel);
		wordViewTable.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(wordViewTable.getModel());
		wordViewTable.setRowSorter(sorter);
		wordView = new JScrollPane(wordViewTable);
		wordView.setSize(400, 450);
		wordView.setLocation(30, 110);

		contentPanel.add(wordView);

		// contentPanel.add(contentNorthPanel,BorderLayout.NORTH);
		// contentPanel.add(contentCenterPanel,BorderLayout.CENTER);
		// contentPanel.add(contentSouthPanel,BorderLayout.SOUTH);
		// add(contentPanel,BorderLayout.CENTER);

		// foot panel
		// footPanel = new JPanel();
		// footPanel.setBackground(Color.BLACK);

		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);

		exit.addActionListener(this);

		exit.setSize(50, 50);
		exit.setLocation(520, 20);
		contentPanel.add(exit);
		add(contentPanel, BorderLayout.CENTER);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {

			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
		}
		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == deleteButton) {
			if (1 <= wordViewTable.getSelectedColumnCount()) {
				wordBook.deleteTag(wordBook.getWordsList().get(
						wordViewTable.getSelectedRow()));
				JOptionPane.showMessageDialog(this, "≈¬±◊ø° ªË¡¶µ«æ˙Ω¿¥œ¥Ÿ.");
			}
		} else if (e.getSource() == tagViewButton) {
			try {
				wordBook.loadWords("tag.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(),
					wordBook.getColnames());
		}
	}

}
