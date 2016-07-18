package sk.tsystems.gamestudio.service.serviceImplm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.ScoreI;



public class ScoreImplm implements ScoreI {
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (score_seq.nextval, ?, ?, ?)";

	public static final String SELECT_SCORE = "SELECT  * FROM ( select GAME.GAMENAME,PLAYER.PLAYERNAME,score.score FROM score JOIN GAME on GAME.GAMEID = score.GAMEID JOIN PLAYER on PLAYER.PLAYERID = score.PLAYERID ORDER BY score.SCORE DESC) WHERE ROWNUM <= 10";

	public static final String SELECT_PLAYER = "SELECT playerid from PLAYER WHERE PLAYERNAME like ? ";
	
	public static final String INSERT_PLAYER = "INSERT INTO PLAYER (PLAYERID,PLAYERNAME) VALUES (PLAYER_SEQ.NEXTVAL,?)";
	
	@Override
	public void addScore(Score score) {
		
		
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_SCORE);
			stmt.setInt(1, score.getPlayerID());
			stmt.setInt(2, score.getGameID());
			stmt.setInt(3, score.getScore());
			stmt.executeUpdate();
			System.out.println("ta sos kere mange");
		} catch (Exception e) {
			e.printStackTrace();
			throw  new ScoreException("somarina" );
		}
		
	}

	@Override
	public String getTopTen(String game) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_SCORE);
			StringBuilder strb = new StringBuilder();
			while (res.next()) {

				if (res.getString(1).equals(game)) {
					strb.append("GAME: " + res.getString(1) + " ||  PLAYER: "
							+ res.getString(2) + " ||  SCORE: "
							+ res.getString(3) + "\n\n");

				}

			}

			return strb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}
		
	}
	
	
	public int check(String name){
		int playerID=0;
		
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_PLAYER);
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();

			while (res.next()) {	
				playerID = res.getInt(1);
			
			}
			if(playerID ==0 ){
				PreparedStatement stmt1 = con.prepareStatement(INSERT_PLAYER);
				stmt1.setString(1, name	);
				stmt1.executeUpdate();
				check(name);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}
		System.out.println("ID HRACA" +playerID);
		return playerID;
	} 






	

}