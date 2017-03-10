package service.impl;


import javax.xml.bind.annotation.XmlSeeAlso;
import service.*;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@HandlerChain(file="handler-chain.xml")
@WebService(serviceName = "rasporedcasova", endpointInterface = "service.RasporedPortType", targetNamespace = "http://www.example.org/rasporedcasova/")
public class RasporedPortTypeImpl implements RasporedPortType {
	public RasporedResponseType getRaspored(RasporedRequestType in) throws GetRasporedFault_Exception {
		String smer = in.getSmer();
		int godina = in.getGodina();
		System.out.println("Vas smer je: " + smer + ", a godina je " + godina);
		
		RasporedResponseType out = new RasporedResponseType();
		CasoviType cas = new CasoviType();
		cas.setDan("petak");
		cas.setPredmet("PRIS");
		
		CasoviType cas2 = new CasoviType();
		cas2.setDan("cetvrtak");
		cas2.setPredmet("Distribuirani");
		
		out.getCas().add(cas);
		out.getCas().add(cas2);
		
		return out;
	}
}