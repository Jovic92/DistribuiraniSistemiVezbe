package b;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import a.HelloIntf;

public class HelloImpl extends UnicastRemoteObject implements HelloIntf {

	protected HelloImpl() throws RemoteException {

	}

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello world on rmi way";
	}

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(4000);
			HelloImpl obj = new HelloImpl();
			Naming.rebind("//127.0.0.1:4000/HelloServer", obj);
			System.out.println("waiting for client....");

		} catch (Exception e) {
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
