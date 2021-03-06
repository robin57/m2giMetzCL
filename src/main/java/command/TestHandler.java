package command;

import ocsf.server.ConnectionToClient;

import java.util.Arrays;

public class TestHandler extends MessageHandler {
	
	public TestHandler() {
		super();
		commandIds.add("test");
	}

	public void handle(String cmdId, String[] args, ConnectionToClient client) {
		switch (cmdId) {
			case "test":
				handleTestMessage(args, client);
				break;
		}
	}
	
	private void handleTestMessage(String[] args, ConnectionToClient client) {
		if (args != null)
			System.out.println(Arrays.toString(args));
	}

}
