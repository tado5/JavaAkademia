package sk.tsystems.gamestudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CommentJpa {

	@Id
	@GeneratedValue
	public int commentID;
	 
	public String autor;
	public String game;
	public String comment;

	public CommentJpa(String autor, String game, String comment) {
		super();
		this.autor = autor;
		this.game = game;
		this.comment = comment;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}

}
