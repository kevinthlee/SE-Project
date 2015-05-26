package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	
	WordBook wordBook;
	
	WordAddScreen wordAddScreen;
	
	public WordBookScreen() throws IOException {
		
		wordBook = new WordBook();
		setLayout(new BorderLayout());
		// title panel
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("¥‹æÓ¿Â");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);
		
		// content panel
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		contentNorthPanel = new JPanel();
		wordsBookList = new JComboBox(WordBook.wordBookList());
		wordsBookOK = new JButton("º±≈√");
		wordsBookOK.addActionListener(this);
		tagViewButton = new JButton("≈¬±◊∫∏±‚");
		tagViewButton.setBackground(Color.BLUE);
		tagViewButton.addActionListener(this);
		wrongWordButton = new JButton("ø¿¥‰≥Î∆Æ");
		wrongWordButton.addActionListener(this);
		wrongWordButton.setBackground(Color.RED);
		contentNorthPanel.add(wordsBookList);
		contentNorthPanel.add(wordsBookOK);
		contentNorthPanel.add(tagViewButton);
		contentNorthPanel.add(wrongWordButton);
		
		contentCenterPanel = new JPanel();
		searchTextField = new JTextField(10);
		searchButton = new JButton("∞Àªˆ");
		JLabel blank = new JLabel("  ");
		addButton = new JButton("√ﬂ∞°");
		addButton.addActionListener(this);
		deleteButton = new JButton("ªË¡¶");
		tagButton = new JButton("≈¬±◊");
		tagButton.addActionListener(this);
		//contentCenterPanel.add(searchTextField);
		//contentCenterPanel.add(searchButton);
		//contentCenterPanel.add(blank);
		contentCenterPanel.add(addButton);
		//contentCenterPanel.add(deleteButton);
		contentCenterPanel.add(tagButton);
		
		wordBook.loadWords("wordBooks/"+wordsBookList.getSelectedItem().toString());
		contentSouthPanel = new JPanel();
		contentSouthPanel.setBackground(Color.BLACK);
		defaultTableModel = new DefaultTableModel(wordBook.getRowData(), wordBook.getColnames());
		wordViewTable = new JTable(defaultTableModel);
		wordViewTable.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(wordViewTable.getModel());
		wordViewTable.setRowSorter(sorter);
		wordView = new JScrollPane(wordViewTable);
		contentSouthPanel.add(wordView);
		
		contentPanel.add(contentNorthPanel,BorderLayout.NORTH);
		contentPanel.add(contentCenterPanel,BorderLayout.CENTER);
		contentPanel.add(contentSouthPanel,BorderLayout.SOUTH);
		add(contentPanel,BorderLayout.CENTER);
		
		// foot panel
		footPanel = new JPanel();
		footPanel.setBackground(Color.BLACK);
		save = new JButton("¿˙¿Â");
		save.addActionListener(this);
		exit = new JButton("≥™∞°±‚");
		exit.addActionListener(this);
		footPanel.add(save);
		footPanel.add(exit);
		add(footPanel,BorderLayout.SOUTH);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
		}else if(e.getSource() == wordsBookOK){
			try {
				wordBook.loadWords("wordBooks/"+wordsBookList.getSelectedItem().toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		}else if(e.getSource() == addButton){
			wordAddScreen = new WordAddScreen(wordBook,this);
		}else if(e.getSource() == tagButton){
			if(1 <= wordViewTable.getSelectedColumnCount()){
				wordBook.addTag(wordBook.getWordsList().get(wordViewTable.getSelectedRow()));
				JOptionPane.showMessageDialog(this,"≈¬±◊ø° √ﬂ∞°µ«æ˙Ω¿¥œ¥Ÿ.");
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
				wordBook.loadWords("wrong.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		}
	}

}
