package sk.tsystems.gamestudio.entity;

public class Rating {

	public int playerID;
	public int gameID;
	public int rating;
	
	
	
	public Rating(int playerID, int gameID, int rating) {
		super();
		this.playerID = playerID;
		this.gameID = gameID;
		this.rating = rating;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
	
	

}
