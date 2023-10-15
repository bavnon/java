package analog;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Matrix extends JPanel {

	public final double TWO_PI = 6.278;
	private static final long serialVersionUID = 1L;
	private Timer timer = null;
	static int width = 390, height = 390;
	int xCenter = 160, yCenter = 200;
	double hLength = 40.0;
	double mLength = 100.0;

	public Matrix() {
		super();
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start();
	}

	int xHour, yHour; // of the end
	int xMinute, yMinute; // of the end
	int xSecond, ySecond; // of the end
	int directionX = 1, directionY = 1;
	double alphaH, alphaS, alphaM;

	void update() {
		// Hour end point
		int sec = BaseTime.getSecond();
		alphaS = (double) ((sec + 45) / 60.0) * TWO_PI; // radians
		int min = BaseTime.getMinute();
		alphaM = (double) ((min + 45) / 60.0) * TWO_PI;
		int hour = BaseTime.getHour();
		alphaH = (double) ((hour + 45) / 12.0) * TWO_PI + TWO_PI / 2.0 / 6.0 * (min / 60.0);
		// System.out.println("alpha="+alphaH);
		xHour = (int) (xCenter + hLength * Math.cos(alphaH));
		yHour = (int) (yCenter + hLength * Math.sin(alphaH));
		xMinute = (int) (xCenter + mLength * Math.cos(alphaM));
		yMinute = (int) (yCenter + mLength * Math.sin(alphaM));
		xSecond = (int) (xCenter + mLength * Math.cos(alphaS));
		ySecond = (int) (yCenter + mLength * Math.sin(alphaS));
		String tmp = " " + BaseTime.getHour() + ":" + BaseTime.getMinute() + ":" + BaseTime.getSecond();
		AnalogClock.lbl.setText(tmp);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (alphaS == 0)
			return;
		g.setColor(Color.black);
		for (int i = 1; i < 13; i++) {
			double alpha = (double) ((i * 5 + 45) / 60.0) * TWO_PI;
			int x = (int) (xCenter + mLength * Math.cos(alpha));
			int y = (int) (yCenter + mLength * Math.sin(alpha));
			g.drawString("" + i, x, y);
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g.setColor(Color.red);
		// Draw hour
		if (xHour > 0)
			g.drawLine(xCenter, yCenter, xHour, yHour);
		// System.err.println(xCenter+";"+ yCenter+";"+ xHour+";"+ yHour);
		g.setColor(Color.blue);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);
		g.setColor(Color.green);
		g.drawLine(xCenter, yCenter, xSecond, ySecond);
		g.setColor(Color.black);
		g.fillOval(xCenter - 5, yCenter - 5, 12, 12);
	}
}
///////////////