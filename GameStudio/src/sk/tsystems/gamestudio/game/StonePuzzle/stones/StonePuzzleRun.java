package sk.tsystems.gamestudio.game.StonePuzzle.stones;

import sk.tsystems.gamestudio.game.StonePuzzle.stones.consoleui.ConsoleUI;

public class StonePuzzleRun implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		new ConsoleUI().run();
		
	}
}
