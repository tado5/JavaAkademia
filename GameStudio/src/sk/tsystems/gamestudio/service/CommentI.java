package sk.tsystems.gamestudio.service;

import sk.tsystems.gamestudio.entity.Comment;


public interface CommentI {

	public void addComent(Comment coment);
	
	// public void addComent(CommentJpa coment);

	public String selectAllComent(String game);


}
