package client.clientsample;

import java.util.List;

import client.*;
import handlers.RasporedHandlerResolver;

public class ClientSample {

	public static void main(String[] args) {

		RasporedRequestType in = new RasporedRequestType();
		in.setGodina(4);
		in.setSmer("IT");
		
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		Rasporedcasova service1 = new Rasporedcasova();
		service1.setHandlerResolver(new RasporedHandlerResolver());
		System.out.println("Create Web Service...");
		RasporedPortType port1 = service1.getRasporedPortTypeImplPort();
		System.out.println("Call Web Service Operation...");
		try {
			List<CasoviType> casovi = port1.getRaspored(in).getCas();
			for(CasoviType cas : casovi){
				System.out.println("-----------------------------------------");
	        	System.out.println(cas.getDan() + " " + cas.getPredmet());
	        	System.out.println("-----------------------------------------");
			}
		} catch (GetRasporedFaultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("***********************");
		System.out.println("Call Over!");
	}
	
}
