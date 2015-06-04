package leaf;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Result {
	ArrayList<String> stringList;

	Object[][] rowData;
	Scanner loadWords;
	ArrayList<Word> wordsList;
	String tempLine;
	StringTokenizer tokenizer;
	PrintWriter out;

	FileReader fr = null;
	FileWriter fw = null;

	BufferedReader br = null;
	BufferedWriter bw = null;

	int score = 0;
	String date;
	String[] str = new String[2];
	ImageIcon icon;
	JPanel GraphPanel;

	LinkedList<String> StringList;
	LinkedList<Integer> IntList;

	public void ReadResult() {
		try {
			StringList = new LinkedList<String>();
			IntList = new LinkedList<Integer>();
			fr = new FileReader("result.txt");
			br = new BufferedReader(fr);

			fw = new FileWriter("result.txt");
			bw = new BufferedWriter(fw);

			String s = null;

			while ((s = br.readLine()) != null) {
				bw.write(s);
				bw.newLine();

				str = s.split("\t");
				date = str[0];
				StringList.add(date);
				score = Integer.parseInt(str[1]);
				IntList.add(score);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void drawRect(int x, int y, int width, int height) {

	}

	public LinkedList<String> getDataString() {
		return StringList;
	}

	public LinkedList<Integer> getDataInt() {

		return IntList;
	}

}
