package command;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ocsf.server.ConnectionToClient;

public class MessageHandlerManager {
	private Map<String, MessageHandler> handlers;
	
	public MessageHandlerManager(){
		handlers = new HashMap<String, MessageHandler>();
	}
	
	public void registerHandler(MessageHandler handler) {
		for (String cmdId : handler.getCommandIds())
			handlers.put(cmdId, handler);
	}
	
	public void handle(String str, ConnectionToClient client){
		Pattern pattern = Pattern.compile("^#([a-zA-Z0-9_]+)(\\[(.+)\\])?");
		Matcher matcher = pattern.matcher(str);
		
		if (matcher.matches()) {	
			String cmdId = matcher.group(1);
			String[] args = (matcher.group(3) != null) ? matcher.group(3).split(";") : null;
			
			System.out.println("Command ID: " + cmdId);
			if (handlers.containsKey(cmdId)){
				handlers.get(cmdId).handle(cmdId, args, client);
			}
			else {
				System.out.println("Command unknow.");
			}
		}
	}
}
