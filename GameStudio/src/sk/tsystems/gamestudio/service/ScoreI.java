package sk.tsystems.gamestudio.service;

import sk.tsystems.gamestudio.entity.Score;

public interface ScoreI {
	
	public void addScore(Score score );
	
	public String getTopTen(String game);

}
