package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import remote.StudentService;

public class RMIApplicationManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			LocateRegistry.createRegistry(4000);
			StudentService obj = new StudentServiceImpl();
			Naming.rebind("//127.0.0.1:4000/StudentService", obj);
			System.out.println("waiting for the client");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
