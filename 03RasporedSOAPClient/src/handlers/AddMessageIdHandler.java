package handlers;

import java.util.Random;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AddMessageIdHandler implements SOAPHandler<SOAPMessageContext> {

	public static final QName MSGID_HEADER = new QName("mynamespace", "msgid");

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		int num = new Random().nextInt();
		String msgId = String.valueOf(num);

		if (!((Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue())
			return true;

		SOAPMessage msg = context.getMessage();
		SOAPHeader hdr;

		try {
			hdr = msg.getSOAPHeader();
			if (hdr == null)
				hdr = msg.getSOAPPart().getEnvelope().addHeader();
			SOAPHeaderElement msgIdElement = hdr.addHeaderElement(MSGID_HEADER);
			msgIdElement.setAttribute("id", msgId);
		} catch (SOAPException e) {
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

}
