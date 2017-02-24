package remote;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {
	
	public String applyForGroup(Student s) throws RemoteException ;

}
