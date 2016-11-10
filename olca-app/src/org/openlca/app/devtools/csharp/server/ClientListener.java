package org.openlca.app.devtools.csharp.server;


/**
 * ClientListener class is purposed to listen for client messages and
 * to forward them to ServerDispatcher.
 */

import java.io.*;
import java.net.*;
/*import java.time.LocalTime;
import javax.swing.JOptionPane;*/

import org.openlca.app.devtools.csharp.CSharp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientListener extends Thread {
	private ServerDispatcher mServerDispatcher;
	private ClientInfo mClientInfo;
	private BufferedReader mIn;
	private String message;
	private String response = null;
	private String decoded = null;
	private static Logger log = LoggerFactory.getLogger(ClientListener.class);

	public ClientListener(ClientInfo aClientInfo, ServerDispatcher aServerDispatcher) throws IOException {
		mClientInfo = aClientInfo;
		mServerDispatcher = aServerDispatcher;
		Socket socket = aClientInfo.mSocket;
		mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	/**
     * Until interrupted, reads messages from the client socket, forwards them
     * to the server dispatcher and notifies the server dispatcher.
     */
    public void run() {
        message = "";
        while (!isInterrupted()) {
            try {
                message = mIn.readLine();
                if (message == null)
                    break;
                try {
                    decoded = URLDecoder.decode(message, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                log.info("received incoming message and starting evaluation");
                CSharp.eval(decoded);
                response = "evaluation complete";
                log.info(response);
                mServerDispatcher.sendMessage(mClientInfo, response);
            } 

            catch (IOException e) {
                break;
            }

        }

	// Communication is broken. Interrupt both listener and sender threads
	mClientInfo.mClientSender.interrupt();
	mServerDispatcher.deleteClient(mClientInfo);
}

}