package leaf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordBook {
	
	String[] colNames={"¥‹æÓ", "∂Ê", "≥≠¿Ãµµ"};
	Object[][] rowData;
	Scanner loadWords;
	ArrayList<Word> wordsList; 
	String tempLine;
	StringTokenizer tokenizer;
	PrintWriter out;
	
	public static String[] wordBookList(){
		String wordBookList[] = null;
		String filePath = "wordBooks";
		
		File path = new File(filePath);
		wordBookList = path.list();
		
		return wordBookList;
	}
	
	//¥‹æÓ¿Â∏∏µÈ±‚øÎ
	public void wordmake(){
		int i=0,j=0;
		tempLine = new String();
		Random rnd = new Random();
		PrintWriter out = null;
		try {
			loadWords = new Scanner(new BufferedReader(new FileReader("voca.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(i<20){
			try {
				out = new PrintWriter(new FileWriter("wordBooks/"+(i+1)+"¿œ¬˜.txt"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
			while(j<100 && loadWords.hasNext()){
			
				tempLine = loadWords.nextLine();
				out.println(tempLine+"	"+(rnd.nextInt(5)+1));
				j++;
			}
			out.close();
			i++;
			j=0;
		}
		loadWords.close();
	}
	
	

	public void loadWords(String list) throws IOException{
			int i=0;
			wordsList = new ArrayList<Word>();
			tempLine = new String();
			loadWords = new Scanner(new BufferedReader(new FileReader(list)));
			
			while(loadWords.hasNext()){
				
				tempLine = loadWords.nextLine();
				tokenizer = new StringTokenizer(tempLine,"	");

				while(tokenizer.hasMoreTokens()){
					wordsList.add(new Word(tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken()));	
				}
				
				
				i++;
			}
			loadWords.close();
			
			i=0;
			rowData = new Object[wordsList.size()][3];
			while(i<wordsList.size()){
				rowData[i][0] = wordsList.get(i).word;
				rowData[i][1] = wordsList.get(i).mean;
				rowData[i][2] = wordsList.get(i).level;
				i++;
			}
	}
	
	public void refreshData(){
		int i=0;
		i=0;
		rowData = new Object[wordsList.size()][3];
		while(i<wordsList.size()){
			rowData[i][0] = wordsList.get(i).word;
			rowData[i][1] = wordsList.get(i).mean;
			rowData[i][2] = wordsList.get(i).level;
			i++;
		}
	}
	
	public void save(String list){
		int i=0;
		try {
			out = new PrintWriter(new FileWriter("wordBooks/"+list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(i<wordsList.size()){
			out.println(wordsList.get(i).word+"	"+wordsList.get(i).mean+"	"+wordsList.get(i).level);
			i++;
		}
			
		out.close();
	}

	public void addTag(Word word){
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
	public void deleteTag(Word word){
		int i=0;
		ArrayList<String> stringList = new ArrayList<String>();
		Scanner read = null;
		try {
			read = new Scanner(new BufferedReader(new FileReader("tag.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(read.hasNext()){
		String str = read.nextLine();
		tokenizer = new StringTokenizer(str,"	");
		if(word.word.equals(tokenizer.nextToken()))
		;
		else
			stringList.add(str);
			
		}
		
		read.close();
		
		try {
			out = new PrintWriter(new FileWriter("tag.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(i<stringList.size()){
			out.println(stringList.get(i++));
		}
		out.close();
	}

	public Object[][] getRowData(){
		return rowData;
	}
	
	public String[] getColnames(){
		return colNames;
	}
	
	public ArrayList<Word> getWordsList(){
		return wordsList;
	}
}
