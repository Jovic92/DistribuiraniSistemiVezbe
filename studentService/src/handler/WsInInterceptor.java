package handler;


import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WsInInterceptor extends WSS4JInInterceptor{

	public WsInInterceptor() {
		super();
		getProperties().put(WSHandlerConstants.ACTION, "Encrypt");
		getProperties().put(WSHandlerConstants.DEC_PROP_FILE, "resource/serverKeystore.properties");
		getProperties().put(WSHandlerConstants.PW_CALLBACK_CLASS, "handler.ServerKeystorePasswordCallback");
	}


}
