package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Message;
import model.Message.ResponseMsg.DetaljiIspita;
import model.ObjectFactory;
import model.Message.RequestMsg;
import model.Message.ResponseMsg;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10007);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10007.");
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("Waiting for connection.....");

		try {
			clientSocket = serverSocket.accept();
			System.out.println("Client from " + clientSocket.getInetAddress().getHostAddress() + " connected");
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		System.out.println("Connection successful");
		System.out.println("Waiting for input.....");

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		StringReader strd = new StringReader(in.readLine());
		try {
			JAXBContext jc = JAXBContext.newInstance("model");
			Unmarshaller um = jc.createUnmarshaller();
			Message msg = (Message) um.unmarshal(strd);
			RequestMsg req = msg.getRequestMsg();

			ObjectFactory of = new ObjectFactory();
			Message msg1 = of.createMessage();
			ResponseMsg res = new ResponseMsg();
			if (req.getPredmet().compareToIgnoreCase("distribuirani sistemi") == 0) {
				res.setErrorMsg(req.getStudent().getIme() + " nikada ti ovaj predmet neces poloziti!!!");

			} else {
				DetaljiIspita ispit = new DetaljiIspita();
				ispit.setOcena(9);
				ispit.setBrojPoena(85);
				res.setDetaljiIspita(ispit);
			}
			msg1.setResponseMsg(res);
			Marshaller m = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			m.marshal(msg1, sw);
			out.println(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}

}
