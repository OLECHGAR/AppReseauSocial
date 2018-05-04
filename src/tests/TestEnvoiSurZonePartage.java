package tests;
import framework.transferable.*;
import framework.zonesPartage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import framework.exception.*;
import framework.rmi.*;
import framework.utilisateur.Utilisateur;

public class TestEnvoiSurZonePartage {
	
	private static int nbRequetes = 0;
	public static void main(String[] args) throws NotNullException {
		// TODO Auto-generated method stub
		Utilisateur u = new Utilisateur("Bernard");
		Utilisateur u2 = new Utilisateur("Gerard");
		String nomZone = "Test";
		ZonePartage zone1 = new ZonePartage(u, nomZone);
		BufferedReader br = null;

	        try {

	            br = new BufferedReader(new InputStreamReader(System.in));

	            while (true) {

	                System.out.print("Message : ");
	                String input = br.readLine();

	                if ("q".equals(input)) {
	                    System.out.println("Exit!");
	                    for(int i=0;i<zone1.size();i++){
	            			System.out.println("("+ zone1.getTransferables().get(i).timeMessage() + ") "+zone1.getTransferables().get(i).getProprietaire().getNom()+" : "+zone1.afficherMessageIndex(i));
	            		}
	                    System.exit(0);
	                }
	                if(nbRequetes%2 == 0)
	                	new Envoi(input, u ,zone1, "texte");
	                else
	                	new Envoi(input, u2 ,zone1, "texte");
	                nbRequetes++;
	                System.out.println("("+ zone1.getTransferables().get(zone1.size()-1).timeMessage() + ") "+zone1.getTransferables().get(zone1.size()-1).getProprietaire().getNom()+" : "+zone1.afficherMessageIndex(zone1.size()-1));
	  
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Require e) {
				e.printStackTrace();
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
