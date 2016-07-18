package sk.tsystems.gamestudio.entity;

public class Score {

	public int playerID;
	public int gameID;
	public int score;

	public Score(int playerID, int gameID, int score) {
		super();
		this.playerID = playerID;
		this.gameID = gameID;
		this.score = score;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}