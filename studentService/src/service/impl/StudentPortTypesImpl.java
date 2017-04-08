package service.impl;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import service.*;
import service.Student.Fakultet;
import javax.jws.WebService;

@WebService(serviceName = "StudentService", endpointInterface = "service.StudentPortTypes", targetNamespace = "http://new.webservice.namespace")
@InInterceptors(interceptors = {"handler.WsInIntercepter"})
@OutInterceptors(interceptors = {"handler.WsOutIntercepter"})
public class StudentPortTypesImpl implements StudentPortTypes {
	public Studenti pronadjiStudenta(java.lang.String fakultet) throws PronadjiStudentaFault {
		Student s = new Student();
		s.setIme("Mika");
		s.setBrojIndeksa("125/04");
		Fakultet f = new Fakultet();
		f.setNaziv("PMF");
		f.setSmer("IT");
		s.setFakultet(f);
		Studenti stud = new Studenti();
		stud.getStudent().add(s);
		System.out.println("1111111");
		return stud;
	}
}