package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import application.Utilisateur;
import framework.rmi.Envoi;
import framework.zonesPartages.ZonePartage;

public class TestEnvoiFichier {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Utilisateur u = new Utilisateur("test", "123", "Toto", "tata",
		"26 route du test", "test@test.tt", "test, 05 2018");
	String nomZone = "TestFichier";
	ArrayList<Utilisateur> listU = new ArrayList<Utilisateur>();
	listU.add(u);
	ZonePartage zone = new ZonePartage(u, listU, nomZone);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
	    System.out.print("mettre le path du fichier image : ");
	    String input = br.readLine();
	    new Envoi<Utilisateur>(input, u, zone, "image");
	    System.out.print("mettre le path du document : ");
	    input = br.readLine();
	    new Envoi<Utilisateur>(input, u, zone, "document");
	    System.out.print("mettre le path du fichier audio : ");
	    input = br.readLine();
	    new Envoi<Utilisateur>(input, u, zone, "audio");
	    // input = br.readLine();
	    // new Envoi<Utilisateur>(input, u, zone, "video");
	    System.out.print("mettre du text : ");
	    input = br.readLine();
	    new Envoi<Utilisateur>(input, u, zone, "texte");

	    for (int index = 0; index < zone.size(); index++) {
		System.out.println("("
			+ zone.getTransferables().get(index).timeMessage()
			+ ") "
			+ ((Utilisateur) zone.getTransferables().get(index)
				.getProprietaire()).getNom() + " : "
			+ zone.afficherMessageIndex(index));
	    }

	    // C:\Users\florian\Downloads\MIAGE\Projet\9Share\src\tests\logo.png
	    // C:\Users\florian\Downloads\MIAGE\Projet\9Share\src\tests\Cahier_des_Charges_Grp9.pdf
	    // C:/Users/florian/Downloads/MIAGE/Projet/9Share/src/tests/OST.mp3
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
