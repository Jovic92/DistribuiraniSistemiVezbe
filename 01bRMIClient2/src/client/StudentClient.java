package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import remote.Student;
import remote.StudentService;

public class StudentClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StudentService obj = (StudentService) Naming.lookup("//127.0.0.1:4000/StudentService");
			Student s = new Student();
			s.setBrojIndeksa("555/333");
			s.setIme("Ides...");
			s.setPrezime("Bato");
			for(int i = 0; i < 20; i++){
				System.out.println(obj.applyForGroup(s));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
