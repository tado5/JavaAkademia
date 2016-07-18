package sk.tsystems.gamestudio.service;

import sk.tsystems.gamestudio.entity.Rating;

public interface RatingI {

	public void addRating(Rating rating);

	public String getAvgRating(String game);
	
	public void ratingCount();
	
	
}
