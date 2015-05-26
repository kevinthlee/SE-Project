package leaf;

public class Word {
	public String word;
	public String mean;
	public String level;
	
	public Word(String w, String m, String l){
		word = w;
		mean = m;
		level = l;
	}
	
	public void setWord(String w){
		word = w;
	}
	
	public void setMean(String m){
		mean = m;
	}
	
	public void setLevel(String l){
		level = l;
	}
}
