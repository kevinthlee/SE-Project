package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import leaf.Test;
import leaf.WordBook;

public class TestChoiceScreen extends JDialog implements ActionListener{

	//JPanel headPanel;
	JPanel bodyPanel;
	//JPanel footPanel;
	
	JLabel choiceTitle;
	
	JComboBox wordBooks;
	JRadioButton testType1, testType2;
	ButtonGroup testTypeGroup;
	
	JButton choiceOK;
	ImageIcon icon;

	
	int testType;
	boolean testStartBool=false;
	String selectDay;
	TestChoiceScreen testChoice;
	
	public TestChoiceScreen() {
		
		setSize(300,315);
		setTitle("Ω√«Ë º±≈√«œ±‚");
		setLayout(new BorderLayout());
		
		//head
		/*headPanel = new JPanel();
		choiceTitle = new JLabel("Ω√«Ë ¿œ¬˜ π◊ ¿Ø«¸ º±≈√");
		headPanel.add(choiceTitle);
		add(headPanel,BorderLayout.NORTH);*/
		
		//body
		icon = new ImageIcon("img_menu/testchoice_back.png");
		bodyPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		bodyPanel.setLayout(null);
		
		choiceTitle = new JLabel("Ω√«Ë ¿œ¬˜ π◊ ¿Ø«¸ º±≈√");
		choiceTitle.setFont(new Font("HY«ÏµÂ∂Û¿ŒM",Font.BOLD,18));
		choiceTitle.setForeground(Color.WHITE);
		choiceTitle.setSize(200, 17);
		choiceTitle.setLocation(50, 35);
		
		wordBooks = new JComboBox(WordBook.wordBookList());
		wordBooks.setSize(100, 30);
		wordBooks.setLocation(100, 100);
		
		
		
		testType1 = new JRadioButton("¡÷∞¸Ωƒ");
		testType1.setSize(70, 30);
		testType1.setLocation(50, 150);
		testType1.setBorderPainted(false);
		testType1.setFocusPainted(true);
		testType1.setContentAreaFilled(false);
				
		testType2 = new JRadioButton("∞¥∞¸Ωƒ");
		testType2.setSize(70, 30);
		testType2.setLocation(180, 150);
		testType2.setBorderPainted(false);
		testType2.setFocusPainted(true);
		testType2.setContentAreaFilled(false);
		
		
		testTypeGroup = new ButtonGroup();		
		testTypeGroup.add(testType1);
		testTypeGroup.add(testType2);
				
		choiceOK = new JButton(new ImageIcon("img_menu/check.png"));
		choiceOK.setSize(50, 50);
		choiceOK.setLocation(125, 200);
		choiceOK.setBorderPainted(false);
		choiceOK.setFocusPainted(true);
		choiceOK.setContentAreaFilled(false);
		
		
		
		
		bodyPanel.add(choiceOK);
		bodyPanel.add(choiceTitle);
		bodyPanel.add(wordBooks);
		bodyPanel.add(testType1);
		bodyPanel.add(testType2);
		add(bodyPanel,BorderLayout.CENTER);
		
		//foot
		/*footPanel = new JPanel();
		choiceOK = new JButton("»Æ¿Œ");
		footPanel.add(choiceOK);
		add(footPanel,BorderLayout.SOUTH);*/

        choiceOK.addActionListener(this);
		
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		
		if(e.getSource() == choiceOK){
			if(testType1.isSelected()){
				testType = Test.TEST_TYPE_1;
				JOptionPane.showMessageDialog(this, wordBooks.getSelectedItem()+", ¡÷∞¸Ωƒ¿‘¥œ¥Ÿ. Ω√«Ë¿ª Ω√¿€«œ∞⁄Ω¿¥œ¥Ÿ(√— "+Test.MAX_QUIZ_NUM+"πÆ¡¶)");
				testStartBool = true;
				selectDay = wordBooks.getSelectedItem().toString();
				dispose();
			}else if(testType2.isSelected()){
				testType = Test.TEST_TYPE_2;
				JOptionPane.showMessageDialog(this, wordBooks.getSelectedItem()+", ∞¥∞¸Ωƒ¿‘¥œ¥Ÿ. Ω√«Ë¿ª Ω√¿€«œ∞⁄Ω¿¥œ¥Ÿ(√— "+Test.MAX_QUIZ_NUM+"πÆ¡¶)");
				testStartBool = true;
				selectDay = wordBooks.getSelectedItem().toString();
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "Ω√«Ë¿Ø«¸¿ª º±≈√«ÿ ¡÷ººø‰.");
			}
		}	
		
	}
	
	public boolean getTestStartBool(){
		return testStartBool;
	}
	
	public void setTestStartBool(boolean b){
		testStartBool = b;
	}
	
	public int getTestType(){
		return testType;
	}

	public String getSelectDay(){
		return selectDay;
	}
	public TestChoiceScreen getTestChoiceScreen() {
		return testChoice;
	}
}
