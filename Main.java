package UI;

public class Main {

	static MenuScreen menu;
	
	public static void main(String[] args) {
		
		menu = new MenuScreen();
		
	}
	
	public static MenuScreen getMenu(){
		return menu;
	}

}
