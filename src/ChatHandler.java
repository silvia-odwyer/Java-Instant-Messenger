import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public class ChatHandler extends Thread {
	protected DataInputStream inputStream;
	protected DataOutputStream outputStream;
	protected Socket newClient;
	protected static Vector handlers = new Vector();
	
	public ChatHandler(Socket newClient) throws IOException {
		this.newClient = newClient;
		setUpStreams();
		run();
		
	}
	public void setUpStreams() throws IOException {
		inputStream = new DataInputStream(new BufferedInputStream (newClient.getInputStream()));
		outputStream = new DataOutputStream(new BufferedOutputStream (newClient.getOutputStream()));
	}
	

	public void run() {
		try {
			handlers.addElement (this);
			whileChatting();
			
		}
		
	}

}
