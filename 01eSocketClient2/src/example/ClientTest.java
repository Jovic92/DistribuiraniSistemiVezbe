package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Message;
import model.Message.RequestMsg;
import model.Message.RequestMsg.Student;
import model.Message.ResponseMsg.DetaljiIspita;
import model.ObjectFactory;

public class ClientTest {
	public static void main(String[] args) throws IOException {

		String serverHostname = new String("127.0.0.1");

		Socket srvSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			srvSocket = new Socket(serverHostname, 10007);
			out = new PrintWriter(srvSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(srvSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
		}

		ObjectFactory of = new ObjectFactory();
		Message msg = of.createMessage();
		RequestMsg req = new RequestMsg();
		msg.setRequestMsg(req);
		req.setPredmet("Informacioni sistemi");
		Student s = new Student();
		s.setBrIndeksa("1");
		s.setIme("Ana");
		s.setPrezime("Peric");
		req.setStudent(s);
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance("model");
			Marshaller m = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			m.marshal(msg, sw);
			out.println(sw.toString());

			StringReader strd = new StringReader(in.readLine());
			Unmarshaller um = jc.createUnmarshaller();
			Message msgres = (Message) um.unmarshal(strd);
			DetaljiIspita ispit = msgres.getResponseMsg().getDetaljiIspita();
			if (ispit != null) {
				System.out.println("imate " + ispit.getBrojPoena() + " poena i dobili ste ocenu " + ispit.getOcena());
			} else {
				System.out.println(msgres.getResponseMsg().getErrorMsg());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.close();
		in.close();

		srvSocket.close();
	}

}
