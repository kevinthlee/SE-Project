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
	JButton deleteButton;
	JButton tagViewButton;
	JScrollPane wordView;
	JTable wordViewTable;
	DefaultTableModel defaultTableModel;
	
	//foot
	JPanel footPanel;
	JButton exit;	
	WordBook wordBook;	
	WordAddScreen wordAddScreen;

	public FavoriteScreen() throws IOException {
	
		icon = new ImageIcon("6.png");
		wordBook = new WordBook();
		setLayout(new BorderLayout());
		// title panel
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titleLabel = new JLabel("¡ﬂø‰¥‹æÓ¿Â");
		titleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,25));
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);
		
		// content panel
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		contentNorthPanel = new JPanel();
		wordsBookList = new JComboBox(WordBook.wordBookList());
	
		
		tagViewButton = new JButton("ªı∑Œ∞Ìƒß");		
		tagViewButton.addActionListener(this);
		contentCenterPanel = new JPanel()
		{
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); 
                super.paintComponent(g);
            }
        };
	
		deleteButton = new JButton("ªË¡¶");
		deleteButton.addActionListener(this);
		contentCenterPanel.add(tagViewButton);
		contentCenterPanel.add(deleteButton);		
		wordBook.loadWords("tag.txt");
		contentSouthPanel = new JPanel()
{
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); 
                super.paintComponent(g);
            }
        };
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
	
		exit = new JButton("≥™∞°±‚");
		exit.addActionListener(this);
	
		footPanel.add(exit);
		add(footPanel,BorderLayout.SOUTH);
		
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(),
				this);
		setOpaque(false);
		super.paintComponent(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.setVisible(false);
			Main.getMenu().getFramePanel().setVisible(true);
		}else if(e.getSource() == deleteButton){
				if(1 <= wordViewTable.getSelectedColumnCount()){
					wordBook.deleteTag(wordBook.getWordsList().get(wordViewTable.getSelectedRow()));
					JOptionPane.showMessageDialog(this,"≈¬±◊ø° ªË¡¶µ«æ˙Ω¿¥œ¥Ÿ.");
					}	
		}else if(e.getSource() == tagViewButton){
				try {
					wordBook.loadWords("tag.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
		}
	}

}
