package sk.tsystems.gamestudio.game.minesweeper;

import sk.tsystems.gamestudio.game.minesweeper.consoleui.ConsoleUI;
import sk.tsystems.gamestudio.game.minesweeper.core.Field;

/**
 * Main application class.
 */
public class MinesweeperRun implements Runnable{
	/** User interface. */
	private UserInterface userInterface;

	private static MinesweeperRun minesweeper;

	private Settings setting;

	private long startMillis;

	private static BestTimes bestTimes = new BestTimes();

	/**
	 * Constructor.
	 */
	private MinesweeperRun() {
		minesweeper = this;

		
	}

	public static MinesweeperRun getInstance() {
		new MinesweeperRun();
		return minesweeper;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments
	 */
	

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 1000);
	}

	public BestTimes getBestTimes() {
		return bestTimes;
	}

	public Settings getSetting() {
		return setting;
	}

	public void setSetting(Settings setting) {
		setting.save();
		this.setting = setting;
	}

	@Override
	public void run() {
	//	setting = Settings.load();
		userInterface = new ConsoleUI();

		startMillis = System.currentTimeMillis();
		Field field = new Field(9, 9, 10);
		userInterface.newGameStarted(field);
		
	}
}
