import javax.swing.JFrame;

public class ClientTest {
	public static void main(String[] args) {
		Client silviasClient;
		silviasClient = new Client("127.0.0.1");
		silviasClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// When the Server app is running on a server, 
		// the IP above can be changed.
		// For now it stands for the Local Host
		// This can also be distributed to all Clients.
		silviasClient.startClientApp();
	}
}
