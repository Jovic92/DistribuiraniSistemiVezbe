package handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class PersistMessageHandler implements SOAPHandler<SOAPMessageContext>{

	public static final File peristenceDir = new File("..//03RasporedSOAPClient/src/handlers");
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		if(!((Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue())
			return true;
		
		SOAPMessage msg = context.getMessage();
		Iterator itr;
		try {
			itr = msg.getSOAPHeader().examineAllHeaderElements();
			String msgId = null;
			while(itr.hasNext() && msgId == null){
				SOAPHeaderElement headerElm = (SOAPHeaderElement) itr.next();
				QName headerQName = headerElm.getElementQName();
				if(headerQName.equals(AddMessageIdHandler.MSGID_HEADER))
					msgId = headerElm.getAttribute("id");
			}
			if(msgId == null){
				System.out.println("No message ID header.");
				return false;
			}
			System.out.println(msgId);
			File msgFile = new File(peristenceDir, "msg"+msgId+".xml");
			msgFile.createNewFile();
			msg.writeTo(new FileOutputStream(msgFile));
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

}
