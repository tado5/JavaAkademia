package sk.tsystems.gamestudio.game.guessnumber;


public class GuessNumberRun implements Runnable {

	private	int score;
	

	@Override
	public void run() {
		GuessMyNumber guesMynumber = new GuessMyNumber(0, 2);
		score =  guesMynumber.GetScore();
		
	}

	

	public int getScore() {
		return score;
	}
	
	

}
