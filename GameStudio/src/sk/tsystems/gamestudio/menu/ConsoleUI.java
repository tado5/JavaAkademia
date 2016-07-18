package sk.tsystems.gamestudio.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PRIVATE_MEMBER;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.game.StonePuzzle.stones.StonePuzzleRun;
import sk.tsystems.gamestudio.game.guessnumber.GuessNumberRun;
import sk.tsystems.gamestudio.game.minesweeper.MinesweeperRun;
import sk.tsystems.gamestudio.service.serviceImplm.CommentImplm;
import sk.tsystems.gamestudio.service.serviceImplm.ScoreImplm;

public class ConsoleUI {

	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	private void handleInput(String input) throws WrongFormatException {

		Scanner scener = new Scanner(System.in);
		int id;
		String name;
		Integer score = 0;
		StringBuilder stb = new StringBuilder();

		Pattern pattern = Pattern.compile("[1-5]");

		Matcher matcher = pattern.matcher(input);

		if (matcher.matches()) {

			switch (input) {
			case "1":
				GuessNumberRun number = new GuessNumberRun();
				number.run();
				score = number.getScore();
				System.out.println("Enter your NAME: ");
				name = scener.next();
				
				stb.append(name + " your score is " + score);
				System.out.println(stb);
				id = new ScoreImplm().check(name);
				new ScoreImplm().addScore(new Score(id, 3, score));
				
				System.out.println("Write someting about this game: ");
				String coment = scener.nextLine();
				id = new CommentImplm().check(name);
				new CommentImplm().addComent(new Comment(10, id, 3, coment));
				
				break;
			case "2":
				new StonePuzzleRun().run();
				break;
			case "3":
				MinesweeperRun.getInstance().run();
				break;

			// case "5" :
			// System.exit(0);
			// break;
			}
		}

	}

	public void update() {

		String menu = "**********************************************************\n"
				+ "****************** GAME **** STUDIO **********************\n"
				+ "**********************************************************"
				+ "\n\n"
				+ "            ------- SELECT ------ GAME -------\n\n"
				+ "               ***  1. GUESS NUMBER   ***\n\n"
				+ "               ***  2. STONES PUZZLE  ***\n\n"
				+ "               ***  3. MINESWEEEPER   ***\n\n"
				+ "               ***  4. EXIT           ***";

		System.out.println(menu);
	}

	public void processInput() {

		try {
			handleInput(readLine());
		} catch (WrongFormatException e) {
			e.printStackTrace();
		}

	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
