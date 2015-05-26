package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import leaf.Word;
import leaf.WordBook;

public class WordAddScreen extends JDialog implements ActionListener{

	JPanel framePanel;
	JPanel contentPanel;
	JPanel buttonPanel;
	
	JLabel wordLabel;
	JLabel meanLabel;
	JLabel levelLabel;
	
	JTextField wordField;
	JTextField meanField;
	JTextField levelField;
	
	JButton addButton;
	
	Word addWord;
	WordBook wordBook;
	WordBookScreen wordBookScreen;
	
	public WordAddScreen(WordBook wordBook, WordBookScreen wordBookScreen) {
		
		this.wordBook = wordBook;
		this.wordBookScreen = wordBookScreen;
		
		setSize(500,100);
		setTitle("¥‹æÓ √ﬂ∞°«œ±‚");
		
		framePanel = new JPanel();
		framePanel.setLayout(new BorderLayout());
		
		//content panel
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.BLACK);
		wordLabel = new JLabel("¥‹æÓ:");
		wordLabel.setForeground(Color.WHITE);
		meanLabel = new JLabel("  ∂Ê:");
		meanLabel.setForeground(Color.WHITE);
		levelLabel = new JLabel("  ≥≠¿Ãµµ:");
		levelLabel.setForeground(Color.WHITE);
		wordField = new JTextField(10);
		meanField = new JTextField(10);
		levelField = new JTextField(5);
		contentPanel.add(wordLabel);
		contentPanel.add(wordField);
		contentPanel.add(meanLabel);
		contentPanel.add(meanField);
		contentPanel.add(levelLabel);
		contentPanel.add(levelField);
		framePanel.add(contentPanel,BorderLayout.CENTER);
		
		//button panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		addButton = new JButton("√ﬂ∞°");
		addButton.addActionListener(this);
		buttonPanel.add(addButton);
		framePanel.add(buttonPanel,BorderLayout.SOUTH);
		
		
		this.add(framePanel);
		setResizable(false);
		setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
	}
	
	public Word getAddWord(){
		return addWord;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton){
			addWord = new Word(wordField.getText(), meanField.getText(), levelField.getText());
			wordBook.getWordsList().add(addWord);
			wordBook.refreshData();
			wordBookScreen.defaultTableModel.setDataVector(wordBook.getRowData(), wordBook.getColnames());
			dispose();
		}
		
	}

}
