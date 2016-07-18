 package sk.tsystems.gamestudio.menu;

import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.serviceImplm.ScoreImplm;

public class Main {

	public static void main(String[] args) {
		
		
		ConsoleUI consoleUI = new ConsoleUI();
	
		while (true){
			consoleUI.update();
			consoleUI.processInput();
		}
	

		

	}

}
