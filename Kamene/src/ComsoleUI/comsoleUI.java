package ComsoleUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Field.Kocka;
import Field.WrongFormatException;
import Field.Kocka.State;
import Field.Pole;

public class comsoleUI {

	public Pole pole;
	Long startTime = System.currentTimeMillis();

	private long getTime() {
		long time = (System.currentTimeMillis() - startTime) / 1000;
		return time;

	}

	public void newGameStarted(Pole pole) {
		this.pole = pole;
		pole.generateGame();

		do {

			pole.printGame();
			procesInput();

			// if (field.getState() == GameState.SOLVED) {
			//
			// System.out.println("You win!!");
			// System.exit(0);
			System.out.println(" Cas hry " + getTime() + " sec.");
		} while (true);

	}

	/** Input reader. */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Reads line of text from the reader.
	 * 
	 * @return line as a string
	 */
	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private void procesInput() {

		System.out.println("W : UP || A : LEFT || S : DOWN || D : RIGHT");
		// System.out.println("TIME" + );
		String input = readLine();
		handleInput(input);
	}

	private void handleInput(String input) {
		Pattern pattern = Pattern.compile("([s]|[d]|[w]|[a]|exit|new){1}");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {

			switch (matcher.group(0).toLowerCase()) {
			case "exit":
				System.exit(0);
				break;
			case "w":
				pole.moveUp();
				break;
			case "a":
				pole.moveLeft();
				break;
			case "d":
				pole.moveRight();
				break;
			case "s":
				pole.moveDown();
				break;
			case "new":
				System.out.println("NewGame");
				break;
			default:
				break;
			}

		}
	}

}
