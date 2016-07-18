package sk.tsystems.gamestudio.service.serviceImplm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.service.CommentI;

public class CommentImplm implements CommentI {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_COMENT = "INSERT INTO COMENT (COMENTID,PLAYERID,gameid,coment ) VALUES (coment_seq.nextval, ?, ?, ?)";

	public static final String SELECT_COMENT = "SELECT DISTINCT GAME.GAMENAME,PLAYER.PLAYERNAME,COMENT.COMENT FROM COMENT JOIN GAME on GAME.GAMEID = COMENT.GAMEID JOIN PLAYER on PLAYER.PLAYERID = COMENT.PLAYERID";

	public static final String SELECT_PLAYER = "SELECT playerid from PLAYER WHERE PLAYERNAME like ? ";

	public static final String INSERT_PLAYER = "INSERT INTO PLAYER (PLAYERID,PLAYERNAME) VALUES (PLAYER_SEQ.NEXTVAL,?)";

	@Override
	public void addComent(Comment coment) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_COMENT);
			stmt.setInt(1, coment.getPlayerID());
			stmt.setInt(2, coment.getGameID());
			stmt.setString(3, coment.getComment());
			stmt.executeUpdate();
			System.out.println("ta sos kere mange");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}

	}

	@Override
	public String selectAllComent(String game) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_COMENT);
			StringBuilder strb = new StringBuilder();
			while (res.next()) {

				if (res.getString(1).equals(game)) {
					strb.append("GAME: " + res.getString(1) + "   PLAYER: "
							+ res.getString(2) + "   COM: " + res.getString(3)
							+ "\n\n");

				}

			}

			return strb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}
	}

	public int check(String name) {
		int playerID = 0;

		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_PLAYER);
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();

			while (res.next()) {
				playerID = res.getInt(1);

			}
			if (playerID == 0) {
				PreparedStatement stmt1 = con.prepareStatement(INSERT_PLAYER);
				stmt1.setString(1, name);
				stmt1.executeUpdate();
				check(name);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("somarina");
		}
		System.err.println(playerID);
		return playerID;
	}

}