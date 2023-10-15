package jump;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//Made By Benny Avnon

enum Types {
	WHITE, BLUE, RED, BLACK;
}

public class Matrix extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static int blockSize = 100;
	private static final int PADDING = 30;
	int countHeroUp = 0;
	private static int END = 600;
	private Timer timer = null; // for game loop
	private final int delay = 300;
	private boolean gameOver = false;
	private final int boardWidth = 15, boardHeight = 2;
	private UFO ufo;
	private Hero hero;
	int x, y;
	static int width, height;

	public int getWidth() {
		return width;
	}

	public static int getBlockSize() {
		return blockSize;
	}

// -- All the data matrix (Document)
	private int[][] board = new int[boardHeight][boardWidth];
// images
// private BufferedImage blocks;
// private BufferedImage gun;
// private BufferedImage imgTomer;
// private BufferedImage imgNiv;// private BufferedImage imgRonit;
// private BufferedImage imgEyal;
	JLabel _lblInfo;
	boolean fireFlag = false;

	public Matrix(int _width, int _height, JLabel lblInfo)  {
		super();
		_lblInfo = lblInfo;
		width = _width;
		height = _height;
		ufo = new UFO(boardWidth, boardHeight);
		hero = new Hero();
// try {
// // blocks = ImageIO.read(Matrix.class.getResource("/smily.png"));
// //blocks = ImageIO.read(Matrix.class.getResource("/Benny.png"));
// //gun = ImageIO.read(Matrix.class.getResource("/GUNc.png"));
// //imgTomer = 
//		ImageIO.read(Matrix.class.getResource("/tomer.png"));
// //imgNiv = ImageIO.read(Matrix.class.getResource("/NIV.png"));
// //imgRonit = ImageIO.read(Matrix.class.getResource("/ronit.png"));
// //imgEyal = ImageIO.read(Matrix.class.getResource("/eyal.png"));
// } catch (IOException e) {
// e.printStackTrace();
// }
		timer = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start();
	}

	public void pause() {
		if (timer.isRunning())
			timer.stop();
		else
			timer.start();
	}

	protected void update() {
// currentShape.update();
// if (gameOver)
// timer.stop();
//-- clear board;
//board = new int[][] {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		resetBoard(0);
		board = ufo.update(board);
// Collision
		if (hero.getY() == 1 && board[1][0] != 0) {
//resetBoard();
			gameOver = true;
//pause();
//JOptionPane.showMessageDialog(null, "Game Over");
		} else {
			board = hero.update(board);
		}
		_lblInfo.setText("" + getHeight());
// System.out.println("y-"+getHeight());
// if(ufo.colissionY(ufo.getY()+30));
// timer.stop();
		printBoard();
	}

	public int getMaxY() {
		return getHeight();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
// currentShape.render(g);
		if (gameOver) {
			g.setColor(Color.red);
//g.clearRect(0, 0, width, height);
			Font font = g.getFont().deriveFont(20.0f);
			g.setFont(font);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.yellow);
			g.drawString("Game Over", 50, 50);
			pause();
			return;
		}
		g.clearRect(0, 0, width, height);
// reset board
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == Types.WHITE.ordinal()) {
					continue;
				}
//-- Kaktus
				else if (board[row][col] == Types.RED.ordinal()) {
//g.setColor(Color.red);
					drawKaktus(g, PADDING + (col) * blockSize, (row) * blockSize, 3 * blockSize / 4, 15);
				} else if (board[row][col] == Types.BLACK.ordinal()) {
//g.setColor(Color.red);
					drawOKaktus(g, PADDING + (col) * blockSize, (row) * blockSize, 3 * blockSize / 4, 15);
				}
//Hero
				else if (board[row][col] == Types.BLUE.ordinal()) {
					drawHero(g, PADDING + (col) * blockSize, (row) * blockSize, 3 * blockSize / 4);
				} // g.fillRect(col * blockSize, row * blockSize, blockSize,
// blockSize);
			}
// System.out.println("bbb:"+(ufo.getY()+ i * blockSize));
// System.out.println("cc:"+( 2 * blockSize));
		}
		g.setColor(Color.black);
		for (int i = 0; i <= boardHeight; i++) {
			g.drawLine(0, i * blockSize, boardWidth * blockSize, i * blockSize);
		}
		for (int j = 0; j <= boardWidth; j++) {
			g.drawLine(j * blockSize, 0, j * blockSize, boardHeight * blockSize);
		}
// -- Hero
//g.drawImage(gun, hero.getX(), END, null);
// -- Jump
		if (countHeroUp <= 0)
			hero.setY(1);
		else
			countHeroUp--;
	}

// g.drawString("Score:" + score, 0, 20);
// g.drawString("Use arrow keys, up to Rotate", 0, 100);}
// Timer timerHero = new Timer(300, new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// hero.setY(1);
// //update();
// }
// });
	public void moveHero(int direction) {
		hero.setY(0);
		countHeroUp = 3;
// timerHero.stop();
// timerHero.start();
	}

	public void reset() {
		gameOver = false;
		resetBoard(0);
		ufo = new UFO(boardWidth, boardHeight);
		board = ufo.update(board);
		hero = new Hero();
		timer.start();
	}

	public void resetBoard(int color) {
		board = new int[boardHeight][boardWidth];
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = Types.WHITE.ordinal();
			}
	}

	public void fire() {
		fireFlag = true;
	}

	public boolean between(int x1, int x2, int delta) {
		boolean result = false;
		if (Math.abs(x1 - x2) < delta)
			result = true;
		System.out.println("between(" + x1 + "," + x2 + "," + delta + ")=" + result);
		return result;
	}

	public void drawKaktus(Graphics g, int x1, int y1, int edge, int wid) {
		g.setColor(Color.green);
// -- center
		g.fillRect(x1 + edge / 2, y1, wid, edge);
// left
		g.fillRect(x1 + edge / 4, y1 + edge / 4, wid, edge / 3);
// rightg.fillRect(x1 + 3 * edge / 4, y1 + 5 * edge / 12, wid, edge / 3);
// l-cont
		g.fillRect(x1 + edge / 4, y1 + 7 * edge / 12, edge / 3, wid);
// r-cont
		g.fillRect(x1 + edge / 2, y1 + 4 * edge / 6, edge / 3, wid);
// g.fillRect(x1+blockSize/2 ,y1-4, blockSize/2, 1);
// g.fillRect(x1 +blockSize,y1-blockSize/2, 4, blockSize/2);
	}

	public void drawOKaktus(Graphics g, int x1, int y1, int edge, int wid) {
		g.setColor(Color.green);
// -- center
		g.fillRect(x1 + edge / 2, y1, wid, edge);
// left
		g.fillRect(x1 + 3 * edge / 4, y1 + edge / 4, wid, edge / 3);
// right
		g.fillRect(x1 + edge / 4, y1 + 5 * edge / 12, wid, edge / 3);
// l-cont
		g.fillRect(x1 + edge / 4, y1 + 7 * edge / 12, edge / 3, wid);
// r-cont
		g.fillRect(x1 + 2 * edge / 4, y1 + 7 * edge / 12, edge / 3, wid);
// g.fillRect(x1+blockSize/2 ,y1-4, blockSize/2, 1);
// g.fillRect(x1 +blockSize,y1-blockSize/2, 4, blockSize/2);
	}

	public void drawHero(Graphics g, int x1, int y1, int edge) {
		g.setColor(Color.BLUE);
// -- center
		g.fillOval(x1 + edge / 3 - 7, y1, 30, 30);
		g.fillRect(x1 + edge / 3 + 5, y1, 7, 60);
// hand
		g.fillRect(x1 + edge / 6, y1+40, 40, 7);
// legs
		g.fillRect(x1 + edge / 4, y1 + 55, 30, 7);
		g.fillRect(x1 + edge / 4, y1 + 55, 7, 30);
		g.fillRect(x1 + edge / 4 + 30, y1 + 55, 7, 30);
//g.fillRect(x1 + edge / 4, y1 + edge / 4, 5, edge );
	}

	public void printBoard() {
		System.out.println("board:" + Arrays.deepToString(board));
	}
}