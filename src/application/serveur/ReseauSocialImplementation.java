package application.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Utilisateur;
import framework.utilisateur.$Utilisateur;

public class ReseauSocialImplementation extends UnicastRemoteObject implements ReseauSocial {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Utilisateur> listeUtilisateurs; // Liste des
																	// utilisateurs
																	// du réseau
																	// social

	protected ReseauSocialImplementation() throws RemoteException, SQLException {
		super();
		this.listeUtilisateurs = new ArrayList<Utilisateur>();

		Connection con3 = DriverManager.getConnection("jdbc:sqlite:lib/nineshare.db");

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql4 = "SELECT * FROM utilisateur";
		PreparedStatement statement4 = con3.prepareStatement(sql4);
		ResultSet res4 = statement4.executeQuery();

		while (res4.next())
		{
			this.listeUtilisateurs.add(new Utilisateur(res4.getString(1), res4.getString(2), res4.getString(3),
			res4.getString(4), res4.getString(5), res4.getString(6), res4.getString(7), res4.getDate(8)));
		}
	}

}