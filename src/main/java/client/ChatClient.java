// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import common.ChatIF;
import crypto.Packet;
import crypto.PacketFactory;
import ocsf.client.ObservableClient;

import java.io.IOException;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends ObservableClient
{
	//Instance variables **********************************************

	/**
	 * The interface type variable.  It allows the implementation of 
	 * the display method in the client.
	 */
	ChatIF clientUI; 


	//Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host The server to connect to.
	 * @param port The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI) 
			throws IOException 
	{
		super(host, port); //Call the superclass constructor
		this.clientUI = clientUI;
		openConnection();
	}
	
	/**
	 * Return the UI linked to the client.
	 */

	public ChatIF getClientUI()
	{
		return this.clientUI;
	}
	


	//Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) 
	{
		PacketFactory pf = new PacketFactory();
		Packet p = pf.creatPacket((byte[]) msg);
		clientUI.display(p.onReceive());
	}

	/**
	 * This method handles all data coming from the UI            
	 *
	 * @param message The message from the UI.
	 */
	public void handleMessageFromClientUI(String message)
	{
		//@TODO : DECOMMENTER CES LIGNES
		//en attente du commit des fichiers correspondants
		if (message.charAt(0) == '#'){
			try {
				//CORSingleton.getInstance().invoke(message.substring(1)).execute(this);
			} catch (Exception e) {
				//clientUI.displayErr("Error : " + e.getMessage());
			}
		}else{
		    try{
		    	sendToServer(message);
		    }
		    catch(IOException e){
		    	clientUI.display("Could not send message to server.  Disconnecting client.");
		    	disconnect();
		    }
		}
	}

    /**
     * This method handles all data coming from the UI
     *
     * @param p The packet from the UI.
     */
    public void handleMessageFromClientUI(Packet p) {
        try {
            sendToServer(p.onSend());
        } catch (IOException e) {
            clientUI.display
                    ("Could not send message to server.  Terminating client.");
            quit();
        }
    }

	/**
	 * This method terminates the client.
	 */
	public void quit()
	{
		try
		{
			closeConnection();
		}
		catch(IOException e) {}
		System.exit(0);
	}
	
	/**
	 * This method disconnect the client.
	 */
	public void disconnect()
	{
		try
		{
			closeConnection();
		}
		catch(IOException e) {}
	}

	/**
	 * Hook method called after the connection has been closed. The default
	 * implementation does nothing. The method may be overriden by subclasses to
	 * perform special processing such as cleaning up and terminating, or
	 * attempting to reconnect.
	 */
	protected void connectionClosed() {

		//affichage sur l'interface client : info connexion terminee
		clientUI.display("Connexion terminee avec le serveur");
	}

	/**
	 * Hook method called after an exception
	 * is raised by the client listening thread.
	 *
	 * @param exception the exception raised.
	 */
	protected void connectionException(Exception exception)
	{
		//exception declenchee -> pas de communication avec le serveur
		clientUI.display
		("Erreur de communication avec le serveur.");

		//arret du client
		quit();
	}

}
//End of ChatClient class
