package jump;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.KeyStroke;

//Made By Benny Avnon

public class Window {
	public static final int WIDTH = 800, HEIGHT = 272;
	public static final int CWIDTH = 10;
	private JFrame window;
	private JLabel lblInfo = new JLabel("");
	final Matrix pnl = new Matrix(WIDTH, HEIGHT, lblInfo);

	public Window() {
		window = new JFrame("Benny's Calypso Leumi");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout());
		JPanel bts = new JPanel();
		JButton btnP = new JButton("''");
		btnP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnl.pause();
			}
		});
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnl.reset();
			}
		});
//btnLeft.setVisible(false);
//btnRight.setVisible(false);bts.add(btnP);
		bts.add(btnReset);
		lblInfo.setVisible(true);
		bts.add(lblInfo);
//bts.add(btnRight);
//bts.add(btn);
		bts.add(new JLabel("use keyboard up^ for fire"));
		Action pressedLeft = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				pnl.moveHero(-1);
				pnl.update();
			}
		};
		JButton btnFire = new JButton("^");
		btnFire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnl.moveHero(1);
			}
		});
		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//pnl.moveHero(-1);
//pnl.update();
			}
		});
		JButton btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//pnl.moveHero(1);
//pnl.update();
			}
		});
///-
		KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false);
		btnLeft.getInputMap().put(ks, "pressedLeft");
		btnLeft.getActionMap().put("pressedLeft", pressedLeft);
		btnLeft.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ks, "pressedLeft");
		Action pressedRight = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				pnl.moveHero(1);
				pnl.update();
			}
		};
		KeyStroke ksR = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);
		btnRight.getInputMap().put(ksR, "pressedRight");
		btnRight.getActionMap().put("pressedRight", pressedRight);
		btnRight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ksR, "pressedRight");
		Action pressedFire = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// pnl.fire();
				pnl.moveHero(1);
				// pnl.update();
			}
		};
		KeyStroke ksFR = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false);
		btnFire.getInputMap().put(ksFR, "presseFire");
		btnFire.getActionMap().put("pressedFire", pressedFire);
		btnFire.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ksFR, "pressedFire");
		bts.add(btnLeft);
		bts.add(btnRight);
		bts.add(btnFire);
		window.add(bts, BorderLayout.NORTH);
		window.add(pnl, BorderLayout.CENTER);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new Window();
	}
}