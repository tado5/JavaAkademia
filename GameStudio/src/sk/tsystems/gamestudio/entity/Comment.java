package sk.tsystems.gamestudio.entity;

public class Comment {

	public int comentID;
	public int playerID;
	public int gameID;
	public String comment;

	public Comment(int comentid,int playerID, int gameID, String comment) {
		super();
		this.comentID= comentid;
		this.playerID = playerID;
		this.gameID = gameID;
		this.comment = comment;
		
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}