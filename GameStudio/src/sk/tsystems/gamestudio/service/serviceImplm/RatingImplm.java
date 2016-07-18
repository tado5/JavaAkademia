package sk.tsystems.gamestudio.service.serviceImplm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.service.RatingI;

public class RatingImplm implements RatingI {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT into RATING(PLAYERID,GAMEID,rating) VALUES (?,?,?)";

	public static final String SELECT_AVG = "SELECT GAME.GAMENAME, AVG(RATING),COUNT(*) FROM RATING JOIN GAME on RATING.GAMEID = GAME.GAMEID GROUP BY GAME.GAMENAME";

	@Override
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub

		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_SCORE);
			stmt.setInt(1, rating.getPlayerID());
			stmt.setInt(2, rating.getGameID());
			stmt.setInt(3, rating.getRating());
			stmt.executeUpdate();
			System.out.println("ta sos kere mange");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}

	}

	@Override
	public String getAvgRating(String game) {
		// TODO Auto-generated method stub

		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_AVG);
			StringBuilder strb = new StringBuilder();
			while (res.next()) {

				if (res.getString(1).equals(game)) {
					strb.append("GAME: " + res.getString(1) + "   AVG RATING: "
							+ res.getString(2) + "   COUNT: "
							+ res.getString(3) + "\n\n");

				}

			}

			return strb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}
	}

	@Override
	public void ratingCount() {
		// TODO Auto-generated method stub

	}

}
