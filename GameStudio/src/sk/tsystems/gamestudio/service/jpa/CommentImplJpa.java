package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import sk.ness.jpa.JpaHelper;
import sk.tsystems.gamestudio.entity.CommentJpa;
import sk.tsystems.gamestudio.service.CommentI;

public class CommentImplJpa  implements CommentI{

	@Override
	public void addComent(String comment, String player, String game) {
		
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(comment);
		JpaHelper.commitTransaction();
		
		
	}

	@Override
	public void selectAllComent() {
		// TODO Auto-generated method stub
		
	}

}
