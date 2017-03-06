package asynccli.clientsample;

import java.io.File;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.ws.Response;

import asynccli.*;

public class ClientSample {

	public static void main(String[] args) {

		pooling();
		callback();

	}

	public static void callback() {
		Rasporedcasova service1 = new Rasporedcasova();
		RasporedPortType port1 = service1.getRasporedPortTypeImplPort();
		RasporedRequestType in = new RasporedRequestType();
		in.setSmer("IT");
		in.setGodina(2);
		Future<?> response = port1.getRasporedAsync(in);
		/*
		 * glavna nit nastavlja u nesto da radi a Future objekat ce kreirati
		 * deamon nit u kojoj cemo po dobijanju podataka ih snimiti u fajl/bazu
		 * podataka.
		 */

		int i = 0;
		while (i < 100) {
			System.out.println("glavna nit radi....");
			i++;
		}

		System.out.println("glavna nit je zavrsila sa svojim poslom!");

	}

	public static void pooling() {
		try {
			Rasporedcasova service1 = new Rasporedcasova();
			RasporedPortType port1 = service1.getRasporedPortTypeImplPort();

			RasporedRequestType in = new RasporedRequestType();
			in.setSmer("IT");
			in.setGodina(2);

			Response<RasporedResponseType> source = port1.getRasporedAsync(in);
			while (!source.isDone()) {

				System.out.println("nesto radim");
			}

			File f = new File("raspored1.xml");
			JAXBContext ctx = JAXBContext.newInstance("asynccli");
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			ObjectFactory objectFactory = new ObjectFactory();
			JAXBElement<RasporedResponseType> el = objectFactory.createRasporedResponse(source.get());
			m.marshal(el, f);
			System.out.println("rezultat je snimljen u fajl raspored1.xml");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
