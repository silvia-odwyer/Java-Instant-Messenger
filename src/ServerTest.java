import javax.swing.JFrame;

public class ServerTest {
	public static void main(String[] args) {
		Server silvia = new Server();
		silvia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		silvia.runApplication();
	}
}