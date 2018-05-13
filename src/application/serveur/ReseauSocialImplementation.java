package application.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import application.SalonDiscussion;
import application.Utilisateur;

public class ReseauSocialImplementation extends UnicastRemoteObject implements ReseauSocial {

	private static final long serialVersionUID = 1L;

	private final String PATH_BASE_DE_DONNEES;

	private Connection connection;

	// Liste des utilisateurs du rÃ©seau social
	private ArrayList<Utilisateur> listeUtilisateurs;

	protected ReseauSocialImplementation(String args) throws RemoteException {
		this.PATH_BASE_DE_DONNEES = "jdbc:sqlite:" + args;
		this.listeUtilisateurs = new ArrayList<Utilisateur>();

		try {
			this.connection = DriverManager.getConnection(this.PATH_BASE_DE_DONNEES);
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql4 = "SELECT * FROM utilisateur";
			PreparedStatement statement4 = this.connection.prepareStatement(sql4);
			ResultSet res4 = statement4.executeQuery();

			while (res4.next()) {
				this.listeUtilisateurs.add(new Utilisateur(res4.getString(1), res4.getString(2), res4.getString(3),
						res4.getString(4), res4.getString(5), res4.getString(6), res4.getString(7), this.connection));
			}
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<Utilisateur> it = this.listeUtilisateurs.iterator();
		while (it.hasNext()) {
			Utilisateur u = it.next();
			System.out.println("Login : " + u.getLogin() + " ; " + " Nom : " + u.getNom() + " ; " + " Prenom : "
					+ u.getPrenom() + " ; " + " Adresse : " + u.getAdresse() + " ; " + " DateNaissance : "
					+ u.getDateNaissance() + " ; " + " Mail : " + u.getMail());
		}
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean ajoutUtilisateur(String login, String mdp, String nom, String prenom, String adresse, String mail,
			String dateNaissance) throws SQLException {
		// TODO change date String to Date

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement1 = this.connection.prepareStatement("select * from utilisateur where login= ?");
		statement1.setString(1, login);
		ResultSet result = statement1.executeQuery();
		if (result.next()) {
			/* TODO ajouter un message box : compte deja pri */
			return false;
		} else {
			String sql = "INSERT INTO utilisateur (login,motDePasse,nom,prenom,adresse,mail,dateNaissance)"
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, mdp);
			statement.setString(3, nom);
			statement.setString(4, prenom);
			statement.setString(5, adresse);
			statement.setString(6, mail);
			statement.setString(7, dateNaissance.toString());
			statement.executeUpdate();

			/* TODO ajouter un message box : inscription ok */
			return true;
		}
	}

	@Override
	public Utilisateur login(String login, String motdepasse) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement = this.connection.prepareStatement(
				"select * from utilisateur where login = '" + login + "'" + " and motDePasse= '" + motdepasse + "'");
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			return new Utilisateur(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
					res.getString(5), res.getString(6), res.getString(7));
		} else {
			return null;
		}
	}

	public Utilisateur getUser(String login) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement statement = this.connection
				.prepareStatement("select * from utilisateur where login = '" + login + "'");
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			return new Utilisateur(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
					res.getString(5), res.getString(6), res.getString(7));
		} else {
			return null;
		}
	}

	public boolean ajoutSalonDiscussion(String nom, boolean privacy, ArrayList<Utilisateur> utilisateurs,
			Utilisateur proprietaire) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                String sqlState1 = "SELECT * FROM SalonDiscussion WHERE proprietaire=? AND nom=?";
		PreparedStatement statement1 = this.connection
				.prepareStatement(sqlState1);
		statement1.setString(1, proprietaire.getLogin());
		statement1.setString(2, nom);
		ResultSet result = statement1.executeQuery();
		SalonDiscussion salon;

		if (result.next()) {
			/* TODO ajouter un message box : compte deja pris */
			System.out.println(result.toString());
			return false;
		} else {
			String sql = "INSERT INTO SalonDiscussion (nom,estPrivee,proprietaire)" + "VALUES (?, ?, ?)";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, nom);
			statement.setBoolean(2, privacy);
			statement.setString(3, proprietaire.getLogin());
			statement.executeUpdate();

			String sql1 = "SELECT COUNT(*) FROM SalonDiscussion;";
			PreparedStatement statementCount = this.connection.prepareStatement(sql1);
			statement.setString(3, proprietaire.getLogin());
			ResultSet count = statementCount.executeQuery();
			int ref = Integer.parseInt(count.getString(1));
			if (!privacy) {

				salon = new SalonDiscussion(proprietaire, utilisateurs, nom, ref);
				proprietaire.creerZone(salon);
				Iterator<Utilisateur> it = utilisateurs.iterator();

				while (it.hasNext()) {
					String log = it.next().getLogin();
					String sql2 = "INSERT INTO abonnement (utilisateur_abo,salon)" + "VALUES (?, ?)";
					PreparedStatement statement2 = this.connection.prepareStatement(sql2);
					statement2.setString(1, log);
					statement2.setInt(2, salon.getReferences());
					statement2.executeUpdate();
				}
			} else {
				// TODO abonner toutes les relations de l'utilisateur à la nouvelle salle
				salon = new SalonDiscussion(proprietaire, nom, ref);
				proprietaire.creerZone(salon);
			}

			System.out.println("creation de zone effectu�e");
			return true;
		}
	}

	/*
	 * Charger toutes les zones --------------------------------------------------
	 */
        @Override
	public void getAllUserSalonDiscussion(Utilisateur utilisateur) throws SQLException {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // String sql = "SELECT * FROM SalonDiscussion INNER JOIN abonnement ON
            // salon=reference WHERE utilisateur_abo=?";
            String sqlStat = "SELECT * "
                    + "FROM SalonDiscussion"
                    + " INNER JOIN abonnement ON salon=reference"
                    + " WHERE utilisateur_abo=? OR proprietaire=?";
            PreparedStatement statement = this.connection.prepareStatement(sqlStat);
            statement.setString(1, utilisateur.getLogin());
            statement.setString(2, utilisateur.getLogin());
            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                // Si l'utilisateur est le proprietaire de la zone
                if (result.getString(3).equals(utilisateur.getLogin())) {
                    // Si la zone est privée
                    if (result.getBoolean(2)) {
                        //Récupération de tous les utilisateurs de la salle sauf le proprio
                        String sqlStat1 =  "SELECT * "
                            + "FROM utilisateur "
                            + "INNER JOIN abonnement ON utilisateur_abo=login "
                            + "WHERE salon=? AND utilisateur_abo!=?";
                        PreparedStatement statement1 = this.connection.prepareStatement(sqlStat1);
                        statement.setString(1, Integer.toString(result.getInt(4)));
                        statement.setString(2, utilisateur.getLogin());
                        ResultSet result1 = statement1.executeQuery();

                        ArrayList<Utilisateur> autorises = new ArrayList<Utilisateur>();
                                        
                        while (result1.next()) {
                            autorises.add(new Utilisateur(result1.getString(1), result1.getString(2), result1.getString(3),
                                result1.getString(4), result1.getString(5), result1.getString(6),
                                result1.getString(7)));
                        }
                        utilisateur.creerZone(new SalonDiscussion(utilisateur, autorises, result.getString(1), result.getInt(4)));
                    }
                    // Si la zone est publique
                    else {
                        utilisateur.creerZone(new SalonDiscussion(utilisateur, result.getString(1), result.getInt(4)));
                    }
                }
                // SI l'utilisateur n'est pas le propriétaire de la salle
                else {
                    // Récupération du propriétaire de la salle
                    String sqlProp = "SELECT * "
                        + "FROM utilisateur "
                        + "WHERE login=(SELECT proprietaire FROM SalonDiscussion WHERE reference =?";
                    PreparedStatement getProprietaire = this.connection.prepareStatement(sqlProp);
                    getProprietaire.setString(1, Integer.toString(result.getInt(4)));
                    ResultSet resultProprietaire = getProprietaire.executeQuery();
                    Utilisateur proprietaire = new Utilisateur(resultProprietaire.getString(1),
                        resultProprietaire.getString(2), resultProprietaire.getString(3),
                        resultProprietaire.getString(4), resultProprietaire.getString(5),
                        resultProprietaire.getString(6), resultProprietaire.getString(7));
                            
                    // Si la zone est privée
                    if (result.getBoolean(2)) {
                        //Récupération de tous les utilisateurs de la salle sauf le proprio
                        String sqlStat2 = "SELECT * "
                            + "FROM utilisateur "
                            + "INNER JOIN abonnement "
                            + "ON utilisateur_abo=login "
                            + "WHERE salon=? AND login!=?";
                        PreparedStatement statement2 = this.connection.prepareStatement(sqlStat2);

                        statement2.setString(1, Integer.toString(result.getInt(4)));
                        statement2.setString(2, proprietaire.getLogin());
                        ResultSet result1 = statement2.executeQuery();
                        ArrayList<Utilisateur> autorises = new ArrayList<Utilisateur>();

                        while (result1.next()) {
                            autorises.add(new Utilisateur(result1.getString(1), result1.getString(2), result1.getString(3),
                                result1.getString(4), result1.getString(5), result1.getString(6),
                                result1.getString(7)));
                        }
                        utilisateur.rejoindreZone(new SalonDiscussion(proprietaire, autorises, result.getString(1), result.getInt(4)));
                    }
                    // Si la zone est publique
                    else {
                        utilisateur.rejoindreZone(new SalonDiscussion(utilisateur, result.getString(1), result.getInt(4)));
                    }
                }
            }
	}

	@Override
	public void closeConnection() throws SQLException {
		this.connection.close();
	}

	@Override
	public void openConnection() throws SQLException {
		this.connection = DriverManager.getConnection(this.PATH_BASE_DE_DONNEES);

	}

}