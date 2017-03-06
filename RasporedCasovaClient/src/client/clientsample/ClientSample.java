package client.clientsample;

import java.util.List;

import client.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        Rasporedcasova service1 = new Rasporedcasova();
	        System.out.println("Create Web Service...");
	        RasporedPortType port1 = service1.getRasporedPortTypeImplPort();
	        System.out.println("Call Web Service Operation...");
	        
	        RasporedRequestType in = new RasporedRequestType();
	        in.setGodina(4);
	        in.setSmer("IT");
	        List<CasoviType> casovi = port1.getRaspored(in).getCas();
	        for(CasoviType cas : casovi){
	        	System.out.println("-----------------------------------------");
	        	System.out.println(cas.getDan() + " " + cas.getPredmet());
	        	System.out.println("-----------------------------------------");
	        }
	        
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
