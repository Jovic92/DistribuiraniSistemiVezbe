package handlers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class RasporedHandlerResolver implements HandlerResolver{

	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		// TODO Auto-generated method stub
		List<Handler> handlerChain = new ArrayList<Handler>();
		
		handlerChain.add(new AddressHandler());
		handlerChain.add(new AddMessageIdHandler());
		handlerChain.add(new PersistMessageHandler());
		
		return handlerChain;
	}

}
