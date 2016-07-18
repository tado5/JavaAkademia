package sk.tsystems.gamestudio.game.StonePuzzle.stones.consoleui;

import java.util.Scanner;

import sk.tsystems.gamestudio.game.StonePuzzle.stones.core.Field;
import sk.tsystems.gamestudio.menu.Main;

public class ConsoleUI {
	private Field field;

	private Scanner scanner;

	private boolean exit = false;

	public ConsoleUI() {
		// field = Field.load();
		if (field == null) {
			newField();
		}
		scanner = new Scanner(System.in);
	}

	public void run() {
		do {
			show();
			processInput();
		} while (!field.isSolved() && exit == false);
		if (field.isSolved()) {
			System.out.println("You won the Game!");
		}
	}

	public void show() {
		System.out.printf("Time: %03d s\n", field.getPlayingSeconds());
		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				int value = field.getValueAt(row, column);
				if (value == Field.EMPTY_CELL) {
					System.out.printf("  ");
				} else {
					System.out.printf("%2d", value);
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	private void processInput() {
		System.out.print("Enter input: ");
		String line = scanner.nextLine().toLowerCase().trim();

		try {
			int value = Integer.parseInt(line);
			if (!field.move(value)) {
				field.move(value);
			}
			// } else {
			// System.out.println("Wrong input or day");
			// }
		} catch (NumberFormatException e) {
		}

		switch (line) {
		case "w":
		case "up":
			field.moveUp();
			break;
		case "a":
		case "left":
			field.moveLeft();
			break;
		case "s":
		case "down":
			field.moveDown();
			break;
		case "d":
		case "right":
			field.moveRight();
			break;
		case "x":
		case "exit":
			// field.save();
			// System.exit(0);
			// sk.tsystems.gamestudio.menu.ConsoleUI consoleUI = new
			// sk.tsystems.gamestudio.menu.ConsoleUI();
			// while (true) {
			// consoleUI.update();
			// consoleUI.processInput();
			// }
			exit = true;

		case "n":
		case "new":
			newField();
			break;
		// default:
		// System.out.println("What's wrong kidda?");
		// break;
		}
	}

	private void newField() {
		field = new Field(4, 4);
	}
}
