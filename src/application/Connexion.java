package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {

	public Utilisateur login(String login, String motdepasse, Connection con) throws SQLException {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = con.prepareStatement(
				"select * from utilisateur where login = '" + login + "'" + " and motDePasse= '" + motdepasse + "'");
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			return new Utilisateur(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
					res.getString(5), res.getString(6), res.getString(7));
		} else

		{
			return null;

		}

	}

}
