package sk.ness.jpa;

import javax.persistence.EntityManager;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.jpa.CommentImplJpa;
import sk.tsystems.gamestudio.service.serviceImplm.CommentImplm;
import sk.tsystems.gamestudio.service.serviceImplm.RatingImplm;
import sk.tsystems.gamestudio.service.serviceImplm.ScoreImplm;

public class Main {

	public static void main(String[] args) throws Exception {

//		Student student = new Student();
//		student.setMeno("tomasko");
//		student.setPriezvisko("bortnak");
//		student.setVek(7);
//		
//		student.setMeno("Lukas ");
//		student.setPriezvisko("Suster");
//		student.setVek(15);
		
		
//		JpaHelper.beginTransaction();
//		EntityManager em = JpaHelper.getEntityManager();
//		em.persist(student);
//		JpaHelper.commitTransaction();
//		
//		
//	//	System.out.println(em.createQuery("SELECT s FROM Student s").getResultList());
//		
//	//	System.out.println(em.createQuery("SELECT s FROM Student s where s.meno ='janko' ").getResultList());
//	
////		System.out.println(em.find(Student.class, 7));
////		
////		System.out.println(em.createQuery("SELECT s FROM Student s where s.meno ='janko' ").getResultList());
////		
//		
//		JpaHelper.beginTransaction();
//		student = em.find(Student.class, 7);
//		student.setVek(20);
//		JpaHelper.commitTransaction();
//		System.out.println(student);
//		
//		JpaHelper.closeAll();
//		
	
//		CommentImplJpa cij = new CommentImplJpa();
//		cij.addComent("ahohjahoj", "janko", "mini");
		
//		Comment com = new  Comment(1,1, "ahoj ");
//		
	//	CommentImplm comm = new CommentImplm();
//		
//		System.out.println(comm.selectAllComent("GUESS NUMBER"));
		
//		Rating ra = new Rating(1,3, 4);
//		

		RatingImplm rat =  new RatingImplm();
		System.out.println(rat.getAvgRating("GUESS NUMBER"));
		//		rat.addRating(ra);
		
		ScoreImplm sco = new ScoreImplm();
		System.out.println(sco.getTopTen("minesweeper"));
		
		
	}

}
