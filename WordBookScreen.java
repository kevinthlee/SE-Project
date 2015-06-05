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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import leaf.WordBook;

public class WordBookScreen extends JPanel implements ActionListener {
	
	ImageIcon icon;
	
	//title
	JPanel titlePanel;
	JLabel titleLabel;
	
	//content
	JPanel contentPanel;
	  //∏ÆΩ∫∆Æ,»Æ¿Œ,¡§∑ƒ...
	JPanel contentNorthPanel;
	  //∞Àªˆ√¢,∞Àªˆπˆ∆∞,√ﬂ∞°,ªË¡¶,≈¬±◊
	JPanel contentCenterPanel;
	  //¥‹æÓ∏Ò∑œ
	JPanel contentSouthPanel;
	
	JComboBox wordsBookList;
	JButton wordsBookOK;
	JLabel arrayLabel;
	
	JTextField searchTextField;
	JButton searchButton;
	JButton addButton;
	JButton deleteButton;
	JButton tagButton;
	JButton tagViewButton;
	JButton wrongWordButton;
	
	JScrollPane wordView;
	JTable wordViewTable;
	DefaultTableModel defaultTableModel;
	
	//foot
	JPanel footPanel;
	JButton exit;
	JButton save;
	JButton back;
	
	WordBook wordBook;
	
	WordAddScreen wordAddScreen;
	
	public WordBookScreen() throws IOException {
		icon = new ImageIcon("img_menu/word_list_back.png");
		wordBook = new WordBook();
		setLayout(new BorderLayout());
		
		// title panel
		/*titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("¥‹æÓ¿Â");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);*/
		
		// content panel
		
		contentPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
			
		
		contentPanel.setLayout(null);
		
		
		
		
		
		//contentNorthPanel = new JPanel();
		
		wordsBookList = new JComboBox(WordBook.wordBookList());
		wordsBookList.setSize(100, 30);
		wordsBookList.setLocation(50, 130);

		
		wordsBookOK = new JButton(new ImageIcon("img_menu/refresh.png"));
		wordsBookOK.addActionListener(this);
		wordsBookOK.setSize(50, 50);
		wordsBookOK.setLocation(160, 120);
		wordsBookOK.setBorderPainted(false);
		wordsBookOK.setFocusPainted(true);
		wordsBookOK.setContentAreaFilled(false);
		
		
		
		tagViewButton = new JButton(new ImageIcon("img_menu/bookmark.png"));
		tagViewButton.addActionListener(this);
		tagViewButton.setSize(60, 50);
		tagViewButton.setLocation(470, 180);
		tagViewButton.setBorderPainted(false);
		tagViewButton.setFocusPainted(true);
		tagViewButton.setContentAreaFilled(false);
		
		
		
		wrongWordButton = new JButton(new ImageIcon("img_menu/incorrect_.png"));
		wrongWordButton.addActionListener(this);
		wrongWordButton.setSize(50, 69);
		wrongWordButton.setLocation(475, 260);
		wrongWordButton.setBorderPainted(false);
		wrongWordButton.setFocusPainted(true);
		wrongWordButton.setContentAreaFilled(false);
		
		
		//contentPanel.add(wordsBookList);
		//contentPanel.add(wordsBookOK);
		//contentPanel.add(tagViewButton);
		//contentPanel.add(wrongWordButton);
		
		//contentCenterPanel = new JPanel();
		//JLabel blank = new JLabel("  ");
		
		searchTextField = new JTextField(10);
		
		addButton = new JButton(new ImageIcon("img_menu/add.png"));
		addButton.addActionListener(this);
		addButton.setSize(50, 60);
		addButton.setLocation(340, 120);
		addButton.setBorderPainted(false);
		addButton.setFocusPainted(true);
		addButton.setContentAreaFilled(false);
		
		
		tagButton = new JButton(new ImageIcon("img_menu/star_2.png"));
		tagButton.addActionListener(this);
		tagButton.setSize(50, 50);
		tagButton.setLocation(400, 120);
		tagButton.setBorderPainted(false);
		tagButton.setFocusPainted(true);
		tagButton.setContentAreaFilled(false);
		
		

		deleteButton = new JButton(new ImageIcon("img_menu/delete.png"));
		deleteButton.addActionListener(this);
		deleteButton.setSize(80, 80);
		deleteButton.setLocation(480, 250);
		deleteButton.setBorderPainted(false);
		deleteButton.setFocusPainted(true);
		deleteButton.setContentAreaFilled(false);

		
		
		contentPanel.add(searchTextField);
		contentPanel.add(addButton);
		contentPanel.add(tagButton);
		
		wordBook.loadWords("wordBooks/00. ¥‹æÓ¿Â.txt");
		
		
		
		defaultTableModel = new DefaultTableModel(wordBook.getRowData(), wordBook.getColnames());
		wordViewTable = new JTable(defaultTableModel);
		wordViewTable.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(wordViewTable.getModel());
		wordViewTable.setRowSorter(sorter);
		wordView = new JScrollPane(wordViewTable);
		wordView.setSize(410, 400);
		wordView.setLocation(50, 180);
		
		
		contentPanel.add(wordView);
		
		save = new JButton(new ImageIcon("img_menu/save.png"));
		save.addActionListener(this);
		save.setSize(70, 30);
		save.setLocation(220, 130);
		
		
		exit = new JButton(new ImageIcon("img_menu/exit.png"));
		exit.addActionListener(this);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setSize(50, 50);
		exit.setLocation(520, 20);
		
		back = new JButton(new ImageIcon("img_menu/backbutton.png"));
		back.addActionListener(this);
		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false);
		back.setFocusPainted(true);
		back.setContentAreaFilled(false);
		
		
		//contentPanel.add(save);
		contentPanel.add(exit);
		contentPanel.add(back);
		contentPanel.add(deleteButton);
		
		add(contentPanel,BorderLayout.CENTER);
		
		// foot panel
		/*footPanel = new JPanel();
		footPanel.setBackground(Color.BLACK);
		save = new JButton("¿˙¿Â");
		save.addActionListener(this);
		exit = new JButton("≥™∞°±‚");
		exit.addActionListener(this);
		footPanel.add(save);
		footPanel.add(exit);
		add(footPanel,BorderLayout.SOUTH);*/
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
		}
		
		
		if(e.getSource() == exit){
			System.exit(0);
			
		}else if(e.getSource() == wordsBookOK){
			try {
				wordBook.loadWords("wordBooks/"+wordsBookList.getSelectedItem().toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		}else if(e.getSource() == addButton){
			wordAddScreen = new WordAddScreen(wordBook,this);
			wordBook.save(wordsBookList.getSelectedItem().toString());
		}else if(e.getSource() == tagButton){
			if(1 <= wordViewTable.getSelectedColumnCount()){
				wordBook.addTag(wordBook.getWordsList().get(wordViewTable.getSelectedRow()));
				JOptionPane.showMessageDialog(this,"¡Ò∞‹√£±‚ø° √ﬂ∞°µ«æ˙Ω¿¥œ¥Ÿ.");
			}
		}else if(e.getSource() == tagViewButton){
				try {
					wordBook.loadWords("tag.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		}else if(e.getSource() == save){
			wordBook.save(wordsBookList.getSelectedItem().toString());
		}else if(e.getSource() == wrongWordButton){
			try {
				wordBook.loadWords("wrongword.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		} else if (e.getSource() == deleteButton) {
			if (1 <= wordViewTable.getSelectedColumnCount()) {
				wordBook.delete(wordBook.getWordsList().get(
						wordViewTable.getSelectedRow()));
				try {
					wordBook.loadWords("wordBooks/"+wordsBookList.getSelectedItem().toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
				JOptionPane.showMessageDialog(this, "¥‹æÓ¿Âø°º≠ ªË¡¶µ«æ˙Ω¿¥œ¥Ÿ.");
			}
		}
	}	 
}
