package sk.tsystems.gamestudio.game.guessnumber;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

class GuessMyNumber {

    // Min and Max values of number generated
    private final int MIN;
    private final int MAX;

    //The number in which to guess
    private int guessnumber = 0;
    //Total guesses taken
    private int guessestaken = 0;
    private long startTime;
    private long endTime;
    private long finalTime;
    int score;

   
    public GuessMyNumber(int min, int max) {
        MIN = min;
        MAX = max;

        //Assign a new random number to guessnumber
        guessnumber = generateNewNumber();

        int guess;

        do {
            guessestaken++;

            // Get the user input whilst guess is wrong
            guess = getUserInput();

            //Check user input
        } while (!checkUserGuess(guess) );
    }

    // Gets an integer value from user
    private int getUserInput() {
        Scanner input = new Scanner(System.in);
        String userinput;
        do {
            System.out.print("Guess a number between 1 and 100 or press 0 for EXIT: ");
            // Make the user input a value while input is not an integer
            userinput = input.nextLine();
        } while (!isInteger(userinput));
        //Returns the input parsed as an integer
        return Integer.parseInt(userinput);
    }

    //Generate a new value between MIN and MAX
    private int generateNewNumber() {
        Random random = new Random();
        startTime = System.currentTimeMillis();
        return random.nextInt(MAX - MIN + 1) + MIN;
       
    }

    
    private boolean checkUserGuess(int guess) {
        if (guess == guessnumber) {
             endTime = System.currentTimeMillis();      //If the user guesses right return true
            System.out.println("Well done! " + guessnumber + " was my number! You guessed it in " + guessestaken + " guesses.");
        
            return true;
        }
        else if (guess == 0) {
//        	sk.tsystems.gamestudio.menu.ConsoleUI consoleUI = new sk.tsystems.gamestudio.menu.ConsoleUI();
//			while (true) {
//				consoleUI.update();
//				consoleUI.processInput();
//			}
        	return true;
        	
		}
                else   {
            // Return false with appropriate output to console
            if (guess > guessnumber) {
          
                System.out.println("My number is less than " + guess + ".");
            } else {
                System.out.println("My number is greater than " + guess + ".");
            }
        }
        return false;

    }

    //Returns true when input string is a valid integer
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    
    public long getTime(){
    	finalTime = ( endTime - startTime)/1000; 
    	return finalTime;
    }

    public int  GetScore() {
    	score = (int) ((1000 /( getTime()  * guessestaken)))*10;
    	return score;
		
	}
   
}