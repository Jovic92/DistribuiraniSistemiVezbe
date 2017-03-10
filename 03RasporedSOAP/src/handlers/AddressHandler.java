package handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import service.GetRasporedFault_Exception;
import service.RasporedFaultType;

public class AddressHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		if (((Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue())
			return true;

		SOAPMessage msg = context.getMessage();
		SOAPHeader hdr;

		try {
			hdr = msg.getSOAPHeader();
			QName ADDRESS_HEADER = new QName("mynamespace", "address");
			Iterator<SOAPHeaderElement> i = hdr.examineAllHeaderElements();
			SOAPHeaderElement hdrblock = null;
			boolean ok = false;
			while (i.hasNext() && !ok) {
				hdrblock = i.next();
				if (hdrblock.getElementQName().equals(ADDRESS_HEADER))
					ok = true;
			}

			if (!ok)
				generateFault(msg, "nema header elementa");

			String ipa = hdrblock.getElementsByTagName("IP_address").item(0).getTextContent();

			if (ipa.startsWith("10."))
				generateFault(msg, "Zabranjen pristup klijentu sa IP adrese " + ipa);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	public void generateFault(SOAPMessage msg, String reason) throws GetRasporedFault_Exception {
		SOAPFault fault;
		try {
			fault = msg.getSOAPBody().addFault();
			fault.setFaultString(reason);
			throw new SOAPFaultException(fault);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		RasporedFaultType rft = new RasporedFaultType();
//		rft.setRasporedFault(reason);
//		throw new GetRasporedFault_Exception(reason, rft);
	}
}
