package a;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloIntf extends Remote {

	public String sayHello() throws RemoteException;
}
