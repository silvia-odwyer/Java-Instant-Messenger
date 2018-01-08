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
	protected Socket newClientSocket;
	private String message = "";
	protected static Vector allHandlers = new Vector();
	
	public ChatHandler(Socket newClientSocket) throws IOException {
		this.newClientSocket = newClientSocket;
		System.out.println("CLIENT: Created a new client socket connection");
		setUpStreams();
		run();
		
	}
	public void setUpStreams() throws IOException {
		System.out.println("CLIENT: Attempting to set up streams...");
		inputStream = new ObjectInputStream(newClientSocket.getInputStream());
		outputStream = new ObjectOutputStream(new BufferedOutputStream (newClientSocket.getOutputStream()));
		outputStream.flush();
		System.out.println("CLIENT: Set up streams successfully! :D");
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
					close();
				} catch (IOException e) {
					System.out.println("CLIENT: Could not close successfully...");
					e.printStackTrace();
				}
				
				try {
					newClientSocket.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
			
		}
		
	public void whileChatting() {
			
	}
	
	public void close() throws IOException {
		System.out.println("Closing the app down...");
		inputStream.close();
		outputStream.close();
		newClientSocket.close();
	}
	
	public void broadcast(String message) throws IOException {
		synchronized (allHandlers) {
			Enumeration newEnumeration = allHandlers.elements();
			
			while (newEnumeration.hasMoreElements()) {
				ChatHandler c = (ChatHandler) newEnumeration.nextElement();
				try {
					synchronized(c.outputStream) {
						System.out.println("CLIENT: Writing message to output stream");
						c.outputStream.writeObject(message);
					}
					c.outputStream.flush();
				} catch (IOException ioException) {
					c.close();
				}
			}
		}
		
	}
		
	}
		
