package analog;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
// Made By Benny Avnon
public class AnalogClock {
	private static final int WIDTH = 320;
	private static final int HEIGHT = 400;
	static JFrame window;
	public static JLabel lbl;

	public static void main(String[] args) {
		window = new JFrame("Benny's Clock ");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		lbl = new JLabel();
		window.setLayout(new BorderLayout());
		Matrix mat = new Matrix();
		window.add(mat, BorderLayout.CENTER);
		window.add(lbl, BorderLayout.NORTH);
		window.setVisible(true);
	}
}
