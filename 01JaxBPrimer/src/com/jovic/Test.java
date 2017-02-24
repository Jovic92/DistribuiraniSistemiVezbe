package com.jovic;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jovic.IspitnaPrijava.PopunjavaStudent.Student;

/*
 * Na osnovu seme su izgenerisane klase IspitnaPrijava i ObjectFactory
 */
public class Test {

	public static void main(String[] args) throws JAXBException {
		
		//Kreiramo JAXB kontekst
		JAXBContext jaxbc = JAXBContext.newInstance(ObjectFactory.class);
		
		//Uz pomoc konteksta kreiramo unmarshallera(on nam pomaze da "otpakujemo" ucitani fajl)
		Unmarshaller unm = jaxbc.createUnmarshaller();
		IspitnaPrijava ip = (IspitnaPrijava) unm.unmarshal(new File("IspitnaPrijavaJankoJankovic.xml"));
		
		System.out.println(ip.getPopunjavaStudent().getStudent().getImeStudenta() + "   " + ip.getPopunjavaProfesor().getRezultat().getOcena());

		//Kreiranje objekta koji cemo marshallovati, tj. updatea postojeceg objekta
		Student stud = ip.getPopunjavaStudent().getStudent();
		stud.setImeStudenta("Milan");
		stud.setPrezimeStudenta("Jovic");
		ip.getPopunjavaStudent().setStudent(stud);
		
		//upis, tj marshalovanje u novi fajl....sada vise nije Janko Jankovic nego Milan Jovic
		Marshaller msl = jaxbc.createMarshaller();
		msl.marshal(ip, new File("jovke.xml"));
	}

}
