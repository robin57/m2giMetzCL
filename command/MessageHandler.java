package command;

import java.util.Vector;

import ocsf.server.ConnectionToClient;

public abstract class MessageHandler {

	protected Vector<String> commandIds;
	
	public MessageHandler() {
		commandIds = new Vector<String>();
	}
	
	public Vector<String> getCommandIds() {
		return commandIds;
	}
	
	public abstract void handle(String cmdId, String[] args, ConnectionToClient client);
}
