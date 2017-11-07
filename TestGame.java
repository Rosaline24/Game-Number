import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestGame extends JFrame {
	public static void main(String[] args) {

		// new object to invoke
		Game g = new Game();
		g.setTitle("Guess Number");
		g.setSize(600,600);
		g.setLocationRelativeTo(null); // Center the frame
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setVisible(true);
	}
}


