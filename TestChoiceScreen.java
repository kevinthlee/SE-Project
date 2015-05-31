package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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

	JPanel headPanel;
	JPanel bodyPanel;
	JPanel footPanel;
	
	JLabel choiceTitle;
	
	JComboBox wordBooks;
	JRadioButton testType1, testType2;
	ButtonGroup testTypeGroup;
	
	JButton choiceOK;

	
	int testType;
	boolean testStartBool=false;
	String selectDay;
	TestChoiceScreen testChoice;
	public TestChoiceScreen() {
		
		setSize(200,150);
		setTitle("Ω√«Ë º±≈√«œ±‚");
		setLayout(new BorderLayout());
		
		//head
		headPanel = new JPanel();
		choiceTitle = new JLabel("Ω√«Ë ¿œ¬˜ π◊ ¿Ø«¸ º±≈√");
		headPanel.add(choiceTitle);
		add(headPanel,BorderLayout.NORTH);
		
		//body
		bodyPanel = new JPanel();
		bodyPanel.setLayout(new BorderLayout());
		wordBooks = new JComboBox(WordBook.wordBookList());
		testType1 = new JRadioButton("¡÷∞¸Ωƒ");
		testType2 = new JRadioButton("∞¥∞¸Ωƒ");
		testTypeGroup = new ButtonGroup();		
		testTypeGroup.add(testType1);
		testTypeGroup.add(testType2);
		bodyPanel.add(wordBooks,BorderLayout.NORTH);
		bodyPanel.add(testType1,BorderLayout.WEST);
		bodyPanel.add(testType2,BorderLayout.CENTER);
		add(bodyPanel,BorderLayout.CENTER);
		
		//foot
		footPanel = new JPanel();
		choiceOK = new JButton("»Æ¿Œ");
		footPanel.add(choiceOK);
		add(footPanel,BorderLayout.SOUTH);

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
