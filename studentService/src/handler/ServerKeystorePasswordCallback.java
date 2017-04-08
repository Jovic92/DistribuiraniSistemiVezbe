package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ServerKeystorePasswordCallback implements CallbackHandler {

	private Map<String, String> passwords = new HashMap<String, String>();

	public ServerKeystorePasswordCallback() {
		passwords.put("client", "client");
		passwords.put("server", "server");
		pswds.put("client", "client");
		pswds.put("server", "server");
	}

//	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
//		for (int i = 0; i < callbacks.length; i++) {
//			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
//
//			String pass = passwords.get(pc.getIdentifier());
//			if (pass != null) {
//				pc.setPassword(pass);
//				return;
//			}
//		}
//	}

	private Map<String, String> pswds = new HashMap<String, String>();

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		System.out.println("hand");
		for (int i = 0; i < callbacks.length; i++){
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
			String pass = pswds.get(pc.getIdentifier());
			if(pass!=null){
				pc.setPassword(pass);
				return;
			}
		}
	}
}
