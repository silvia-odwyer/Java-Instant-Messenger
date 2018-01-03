import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class ChatHandler extends Thread {
	protected ObjectInputStream inputStream;
	protected ObjectOutputStream outputStream;
	protected Socket newClient;
	private String message = "";
	protected static Vector allHandlers = new Vector();
	
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
			allHandlers.addElement (this);
			while (true) {
				try {
					message = (String) inputStream.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				broadcast(message);
			}} catch(IOException ioException) {
				ioException.printStackTrace();
			} finally {
				allHandlers.removeElement(this);
				
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
	
	public void broadcast(String message) {
		synchronized (allHandlers) {
			Enumeration<E> newEnumeration = allHandlers.elements();
			
			while (newEnumeration.hasMoreElements()) {
				ChatHandler c = (ChatHandler) newEnumeration.nextElement();
				try {
					synchronized(c.outputStream) {
						c.outputStream.writeObject(message);
					}
					c.outputStream.flush();
				} catch (IOException ioException) {
					c.stop();
				}
			}
		}
		
	}
		
	}
		
