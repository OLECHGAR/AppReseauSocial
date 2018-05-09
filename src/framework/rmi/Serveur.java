package framework.rmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Serveur {

	public static void main(String[] args) throws RemoteException, MalformedURLException, SQLException {

		System.setProperty("java.rmi.server.hostname", "129.88.153.41");
		Registry rmi = LocateRegistry.createRegistry(1099);
		ReseauSocialImplementation reseau = new ReseauSocialImplementation();
		rmi.rebind("reseau", reseau); //ON REND DISPONIBLE L'OBJET A DISTANCE
	}
}