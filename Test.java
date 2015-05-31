package leaf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import UI.Main;
import UI.TestScreen;


public class Test {

	public static final int TEST_TYPE_1 = 1;
	public static final int TEST_TYPE_2 = 2;
	public static final int MAX_QUIZ_NUM = 20;
	
	int testType;
	String selectedDay;
	WordBook wordBook;
	ArrayList<Word> mixWordsList;
	ArrayList<Word> answerList;
	TestScreen testScreen;
	int countNum=0;
	int score=0;
	long time;
	PrintWriter out;
	String timeString;
	
	public Test(int testType, String selectedDay, TestScreen screen) {
		this.testType = testType;
		this.selectedDay = selectedDay;
		testScreen = screen;
		wordBook = new WordBook();
		try {
			wordBook.loadWords("wordBooks/"+selectedDay);
		} catch (IOException e) {
			e.printStackTrace();
		}
		time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
		timeString = dayTime.format(new Date(time));
		mixWords();
	}
	
	//∑£¥˝¿∏∑Œ ¡ﬂ∫πæ¯¿Ã πÆ¡¶∏¶ ºØ¿Ω
	public void mixWords(){
		int i=0,j=0;
		Random rnd = new Random();
		mixWordsList = new ArrayList<Word>();
		Word tempWord;
		
		while(i<wordBook.getWordsList().size()){
			mixWordsList.add(wordBook.getWordsList().get(i));
			i++;
		}
		
		i=0;
		
		while(i<wordBook.getWordsList().size()){
			j=rnd.nextInt(mixWordsList.size()-i)+i;
			tempWord = new Word(mixWordsList.get(j).word,mixWordsList.get(j).mean,mixWordsList.get(j).level);
			mixWordsList.set(j, mixWordsList.get(i));
			mixWordsList.set(i, tempWord);
			i++;
		}
	}
	
	public void submitQuiz(){
		
		if(testType == TEST_TYPE_1){
			if(countNum<MAX_QUIZ_NUM){
				testScreen.getQuizArea().setText((countNum+1)+". "+mixWordsList.get(countNum).mean);
				testScreen.getQuizArea().updateUI();
			}else{
				endTest();
			}
		}else if(testType == TEST_TYPE_2){
			
			if(countNum<MAX_QUIZ_NUM){
				testScreen.getQuizArea().setText((countNum+1)+". "+mixWordsList.get(countNum).word);
				testScreen.getQuizArea().updateUI();
				
				//∞¥∞¸Ωƒ πÆ¡¶ ºØ¥¬∫Œ∫–
				int i=0,j=0;
				Random rnd = new Random();
				answerList = new ArrayList<Word>();
				Word tempWord;
				
				i=countNum+1;
				
				while(i<mixWordsList.size()){
					answerList.add(mixWordsList.get(i));
					i++;
				}
				
				i=0;
				
				while(i<answerList.size()){
					j=rnd.nextInt(answerList.size()-i)+i;
					tempWord = new Word(answerList.get(j).word,answerList.get(j).mean,answerList.get(j).level);
					answerList.set(j, answerList.get(i));
					answerList.set(i, tempWord);
					i++;
				}
				
				answerList.set(rnd.nextInt(5), mixWordsList.get(countNum));
				
				//∫∏±‚ ¡¶√‚
				testScreen.getAnswer1().setText(answerList.get(0).mean);
				testScreen.getAnswer1().updateUI();
				testScreen.getAnswer2().setText(answerList.get(1).mean);
				testScreen.getAnswer2().updateUI();
				testScreen.getAnswer3().setText(answerList.get(2).mean);
				testScreen.getAnswer3().updateUI();
				testScreen.getAnswer4().setText(answerList.get(3).mean);
				testScreen.getAnswer4().updateUI();
				testScreen.getAnswer5().setText(answerList.get(4).mean);
				testScreen.getAnswer5().updateUI();
			}else{
				endTest();
			}
		}

	}
	
	public void checkAnswer(){
		int ans=-1;
		if(testType == TEST_TYPE_1){
			if(testScreen.getAnswerField().getText().equals(mixWordsList.get(countNum).word)){
				score++;
			}else{
				recordWrongWord(mixWordsList.get(countNum));
			}
			testScreen.getAnswerField().setText("");
			countNum++;
		}else if(testType == TEST_TYPE_2){
			if(testScreen.getAnswer1().isSelected()){
				ans=0;
			}else if(testScreen.getAnswer2().isSelected()){
				ans=1;
			}else if(testScreen.getAnswer3().isSelected()){
				ans=2;
			}else if(testScreen.getAnswer4().isSelected()){
				ans=3;
			}else if(testScreen.getAnswer5().isSelected()){
				ans=4;
			}else{
				ans=-1;
			}
			
			if(ans==-1){
				
			}else if(answerList.get(ans).mean.equals(mixWordsList.get(countNum).mean)){
				score++;
			}else{
				recordWrongWord(mixWordsList.get(countNum));
			}
			countNum++;
			testScreen.getDummyRadio().setSelected(true);
		}
	}
	
	public void recordWrongWord(Word word){
		int i=0;
		ArrayList<String> stringList = new ArrayList<String>();
		Scanner read = null;
		try {
			read = new Scanner(new BufferedReader(new FileReader("tag.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(read.hasNext()){
			stringList.add(read.nextLine());			
		}
		read.close();
		
		try {
			out = new PrintWriter(new FileWriter("tag.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(i<stringList.size()){
			out.println(stringList.get(i));
			i++;
		}
		
		out.println(word.word+"	"+word.mean+"	"+word.level);
		
		out.close();
	}
	
	
	public void saveResult(){
		String typ;
		int i=0;
		ArrayList<String> stringList = new ArrayList<String>();
		Scanner read = null;
		try {
			read = new Scanner(new BufferedReader(new FileReader("result.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(read.hasNext()){
			stringList.add(read.nextLine());			
		}
		read.close();
		
		try {
			out = new PrintWriter(new FileWriter("result.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(i<stringList.size()){
			out.println(stringList.get(i));
			i++;
		}
		if(testType == Test.TEST_TYPE_1)
			typ = "¡÷∞¸Ωƒ";
		else
			typ = "∞¥∞¸Ωƒ";
		
		out.println(timeString+"\t"+score);
		
		out.close();
	}
	
	public void endTest(){
		JOptionPane.showMessageDialog(testScreen, "¡°ºˆ : "+score+"/20");
		saveResult();
		Main.getMenu().remove(testScreen);
		Main.getMenu().getFramePanel().setVisible(true);
	}
	
	public int getTestType(){
		return testType;
	}
	
	public String getSelectedDay(){
		return selectedDay;
	}
}
