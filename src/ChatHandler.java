import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ChatHandler extends Thread {
	protected ObjectInputStream inputStream;
	protected ObjectOutputStream outputStream;
	protected Socket newClient;
	protected static Vector handlers = new Vector();
	
	public ChatHandler(Socket newClient) throws IOException {
		this.newClient = newClient;
		setUpStreams();
		run();
		
	}
	public void setUpStreams() throws IOException {
		inputStream = new ObjectInputStream(newClient.getInputStream());
		outputStream = new ObjectOutputStream(new BufferedOutputStream (newClient.getOutputStream()));
		outputStream.flush();
	}
	

	public void run() {
		try {
			handlers.addElement (this);
			while (true) {
				String message = inputStream.readUTF();
				broadcast(message);
			} catch(IOException ioException) {
				ioException.printStackTrace();
			} finally {
				handlers.removeElement(this);
				
				try {
					newClient.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
			
		}
		
	public void whileChatting() {
			
	}
	
	public void close() throws IOException {
		inputStream.close();
		outputStream.close();
		newClient.close();
	}
	
	public void broadcast() {
		
	}
		
}
