package handler;

import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WsOutIntercepter extends org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor{
	  public WsOutIntercepter() {
	        super();
	        System.out.println("99999");
	        getProperties().put(WSHandlerConstants.ACTION, "Encrypt");
	        getProperties().put(WSHandlerConstants.ENC_PROP_FILE, "resource/serverKeystore.properties");
	        getProperties().put(WSHandlerConstants.PW_CALLBACK_CLASS, "handler.ServerKeystorePasswordCallback");
	        getProperties().put(WSHandlerConstants.ENCRYPTION_USER, "client");
	   
//	        getProperties().put(WSHandlerConstants., value)
	  /**@TODO podesiti interceptore tako da samo potpisuju poruku, ali da ne kriptuju ili i da potpisuju i da kriptuju 
	   probati i ostale propertije http://cxf.apache.org/docs/ws-security.html http://ws.apache.org/wss4j/config.html!
	   *
	   */
	   
	  }
}
