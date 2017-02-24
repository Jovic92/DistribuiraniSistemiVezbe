package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import remote.Student;
import remote.StudentService;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService{

	private final int MAXPERGROUP = 5;
	private Integer groupID = 1;
	private HashMap<Integer, List<Student>> groups = new HashMap<Integer, List<Student>>();
	
	protected StudentServiceImpl() throws RemoteException {
		groups.put(1, new ArrayList<>());
	}

	@Override
	public String applyForGroup(Student s) throws RemoteException {
		// TODO Auto-generated method stub
		List<Student> students = groups.get(groupID);
		if(students.size() < MAXPERGROUP){
			students.add(s);
		}else{
			groupID++;
			groups.put(groupID, new ArrayList<>());
			groups.get(groupID).add(s);
		}
		
		return "Vi ste u grupi: " + groupID;
	}

	
}
