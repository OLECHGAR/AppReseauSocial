package tests;

import framework.zonesPartage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

import framework.exception.*;
import framework.rmi.*;
import application.Utilisateur;

public class TestEnvoiSurZonePartage {

	private static int nbRequetes = 0;

	public static void main(String[] args) throws NotNullException {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		try {
			Utilisateur u;
			Utilisateur u2;
			
			u = new Utilisateur("", "Bernard", "", "Bernard", "", "", "", new Date());
			u2 = new Utilisateur("", "Gerard", "", "Gerard", "", "", "", new Date());
			Utilisateur u3 = new Utilisateur("","","","","","","",new Date());
			String nomZone = "Test";
			ArrayList<Utilisateur> listU = new ArrayList<Utilisateur>();
			listU.add(u2);
			ZonePartage zone1 = new ZonePartage(u, listU, nomZone);

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Message : ");
				String input = br.readLine();

				if ("q".equals(input)) {
					System.out.println("Exit!");
					for (int i = 0; i < zone1.size(); i++) {
						System.out.println("(" + zone1.getTransferables().get(i).timeMessage() + ") "
								+ ((Utilisateur) zone1.getTransferables().get(i).getProprietaire()).getNom() + " : "
								+ zone1.afficherMessageIndex(i));
					}
					System.exit(0);
				}
				if (nbRequetes == 2) {
					zone1.setPublique();
				}
				if (nbRequetes == 4) {
					zone1.setPrivee(listU);
				}
				if (nbRequetes % 2 == 0) {
					new Envoi<Utilisateur>(input, u, zone1, "texte");
				} else {
					if (zone1.getPrivacy()) {
						Iterator<ZonePartageSimple> it = u2.getZonesInteractions().iterator();
						while (it.hasNext()) {
							if (it.next().equals(zone1)) {
								new Envoi<Utilisateur>(input, u2, zone1, "texte");
							}
						}
					} else {
						new Envoi<Utilisateur>(input, u2, zone1, "texte");
					}
				}
				nbRequetes++;
				System.out
						.println(
								"(" + zone1.getTransferables().get(zone1.size() - 1).timeMessage() + ") "
										+ ((Utilisateur) zone1.getTransferables().get(zone1.size() - 1)
												.getProprietaire()).getNom()
										+ " : " + zone1.afficherMessageIndex(zone1.size() - 1));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Require e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
