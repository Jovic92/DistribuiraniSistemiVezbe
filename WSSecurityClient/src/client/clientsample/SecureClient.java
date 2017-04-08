package client.clientsample;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;

import client.*;

public class SecureClient {

	public static void main(String[] args) {

		try {
			runSecurityTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void runSecurityTest() {

		try {
			StudentService service = new StudentService();
			StudentPortTypes port = service.getStudentPortTypesImplPort();
			Client client = ClientProxy.getClient(port);
			Endpoint cxfEndpoint = client.getEndpoint();

			Map<String, Object> outProps = new HashMap<String, Object>();
			 outProps.put("action", "Encrypt");
//			outProps.put(ConfigurationConstants.ACTION, "Encrypt");

			 outProps.put("user", "client");
//			outProps.put(ConfigurationConstants.USER, "client");

			 outProps.put("passwordCallbackClass",
			 "handlers.ClientKeystorePasswordCallback");
//			outProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, "handlers.ClientKeystorePasswordCallback");
			 outProps.put("encryptionPropFile",
			 "resource/clientKeystore.properties");
//			outProps.put(ConfigurationConstants.ENC_PROP_FILE, "resource/clientKeystore.properties");
			 outProps.put("encryptionUser", "server");
//			outProps.put(ConfigurationConstants.ENCRYPTION_USER, "server");
			 outProps.put("encryptionKeyIdentifier", "DirectReference");
//			outProps.put(ConfigurationConstants.ENC_KEY_ID, "DirectReference");
			 outProps.put("encryptionParts",
			 "{Element}{http://new.webservice.namespace}naziv_fakulteta");
//			outProps.put(ConfigurationConstants.ENCRYPTION_PARTS,
//					"{Element}{http://new.webservice.namespace}naziv_fakulteta");
			// outProps.put("signaturePropFile",
			// "resource/clientKeystore.properties");
			// outProps.put("signatureParts",
			// "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");

			 WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
			// request
			 cxfEndpoint.getOutInterceptors().add(wssOut);

			// StudentService servis = new StudentService();
			// StudentPortTypes port = servis.getStudentPortTypesImplPort();
			// Client cli = ClientProxy.getClient(port);
			// Endpoint cxfEndpoint = cli.getEndpoint();
			//
			// Map<String, Object> outProps = new HashMap<String, Object>();
			// outProps.put(ConfigurationConstants.ACTION, "Encrypt");
			// outProps.put(ConfigurationConstants.USER, "client");
			// outProps.put(ConfigurationConstants.PW_CALLBACK_CLASS,
			// "handlers.ClientKeystorePasswordCallback");
			// outProps.put(ConfigurationConstants.ENC_PROP_FILE,
			// "resource/clientKeystore.properties");
			// outProps.put(ConfigurationConstants.ENCRYPTION_USER, "server");
			// outProps.put(ConfigurationConstants.ENC_KEY_ID,
			// "DirectReference");
			// outProps.put(ConfigurationConstants.ENCRYPTION_PARTS,
			// "{Element}{http://new.webservice.namespace}naziv_fakulteta");
			// outProps.put("signaturePropFile",
			// "resource/clientKeystore.properties");
			// outProps.put("signatureParts",
			// "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");

//			WSS4JInInterceptor wssOut = new WSS4JInInterceptor(outProps);
//			cxfEndpoint.getOutInterceptors().add(wssOut);

			Map<String, Object> inProps = new HashMap<String, Object>();
			inProps.put("action", "Encrypt");
//			inProps.put("signaturePropFile", "resource/clientKeystore.properties");
			inProps.put("passwordCallbackClass", "handlers.ClientKeystorePasswordCallback");
			inProps.put("decryptionPropFile", "resource/clientKeystore.properties");
			WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps); // response
			cxfEndpoint.getInInterceptors().add(wssIn);

			Studenti ss = port.pronadjiStudenta("pmf");

			JAXBContext ctx = JAXBContext.newInstance("client");
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(ss, System.out);

		} catch (SOAPFaultException f) {
			System.out.println("Doslo je do greske!");
			System.out.println(f.getFault().getFaultString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// StudentService servis = new StudentService();
		// StudentPortTypes port = servis.getStudentPortTypesImplPort();
		// Client cli = ClientProxy.getClient(port);
		// Endpoint cxfEndpoint = cli.getEndpoint();
		//
		// Map<String, Object> outProps = new HashMap<String, Object>();
		// outProps.put(ConfigurationConstants.ACTION, "Encrypt");
		// outProps.put(ConfigurationConstants.USER, "client");
		// outProps.put(ConfigurationConstants.PW_CALLBACK_CLASS,
		// "handlers.ClientKeystorePasswordCallback");
		// outProps.put(ConfigurationConstants.ENC_PROP_FILE,
		// "resource/clientKeystore.properties");
		// outProps.put(ConfigurationConstants.ENCRYPTION_USER, "server");
		// outProps.put(ConfigurationConstants.ENC_KEY_ID, "DirectReference");
		// outProps.put(ConfigurationConstants.ENCRYPTION_PARTS,
		// "{Element}{http://new.webservice.namespace}naziv_fakulteta");
		//
		// WSS4JInInterceptor wssOut = new WSS4JInInterceptor(outProps);
		// cxfEndpoint.getOutInterceptors().add(wssOut);

	}

}
