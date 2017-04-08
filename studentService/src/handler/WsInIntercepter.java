package handler;

import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WsInIntercepter extends org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor {
	    public WsInIntercepter() {
	        super();
			System.out.println("66666");
	        getProperties().put(WSHandlerConstants.ACTION, "Encrypt");
	        getProperties().put(WSHandlerConstants.DEC_PROP_FILE, "resource/serverKeystore.properties");
	        getProperties().put(WSHandlerConstants.PW_CALLBACK_CLASS, "handler.ServerKeystorePasswordCallback");
	    }

}
