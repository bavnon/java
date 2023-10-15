package games.space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
	private final static int blockSize = 80;// 170;
	private static final int PADDING = 30;
	private static int END = 300;
	private Timer timer = null; // for game loop
	private final int delay = 1000;
	///// private boolean gameOver = false;
	private final int boardWidth = 10, boardHeight = 4;
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
//images
	private BufferedImage blocks;
	private BufferedImage gun;
	private BufferedImage imgTomer;
	private BufferedImage imgNiv;
	private BufferedImage imgRonit;
	private BufferedImage imgEyal;
	JLabel _lblInfo;
	boolean fireFlag = false;

	public Matrix(int _width, int _height, JLabel lblInfo) {
		super();
		_lblInfo = lblInfo;
		width = _width;
		height = _height;
		ufo = new UFO(boardWidth, boardWidth);
		hero = new Hero();
		try {
//blocks = 
//ImageIO.read(Matrix.class.getResource("/smily.ng"));
			blocks = ImageIO.read(Matrix.class.getResource("/resources/Dis.JPG"));
			gun = ImageIO.read(Matrix.class.getResource("/resources/gun1.JPG"));
			imgTomer = ImageIO.read(Matrix.class.getResource("/resources/Dis.JPG"));
			imgNiv = ImageIO.read(Matrix.class.getResource("/resources/Dis.JPG"));
			imgRonit = ImageIO.read(Matrix.class.getResource("/resources/Dis.JPG"));
			imgEyal = ImageIO.read(Matrix.class.getResource("/resources/Dis.JPG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
//if (gameOver)
// timer.stop();
		ufo.update();
		if (END <= ufo.getY() + ufo.getHeight()) {
			pause();
			JOptionPane.showMessageDialog(null, "Game Over");
		}
		_lblInfo.setText("" + getHeight());
//System.out.println("y-"+getHeight());
// if(ufo.colissionY(ufo.getY()+30));
// timer.stop();
	}

	public int getMaxY() {
		return getHeight();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
// currentShape.render(g);
		g.setColor(Color.red);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == Types.WHITE.ordinal()) {
					continue;
				} else if (board[row][col] == Types.RED.ordinal()) {
					g.setColor(Color.red);
				} else if (board[row][col] == Types.BLUE.ordinal()) {
					g.setColor(Color.blue);
				} else {
					g.setColor(Color.yellow);
				}
				g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
// 
//g.drawImage(blocks.getSubimage((board[row][col]-1)*blockSize,
// 0, blockSize, blockSize),
// col*blockSize, 
////row*blockSize, null);
//g.drawImage(blocks, col * 
//blockSize, row * blockSize, null);
// col*blockSize, 
/////row*blockSize, null);
			}
		}
		for (int i = 0; i < ufo.rows; i++)
			for (int j = 0; j < ufo.cols; j++) {
				int typ = ufo.get(i, j);
				if (typ != 0) {
					switch (typ) {
					case 1:
						g.drawImage(imgTomer, PADDING + ufo.getX() + j * blockSize, ufo.getY() + i * blockSize, null);
						break;
					case 2:
						g.drawImage(imgNiv, PADDING + ufo.getX() + j * blockSize, ufo.getY() + i * blockSize, null);
						break;
					case 3:
						g.drawImage(imgRonit, PADDING + ufo.getX() + j * blockSize, ufo.getY() + i * blockSize, null);
						break;
					case 4:
						g.drawImage(imgEyal, PADDING + ufo.getX() + j * blockSize, ufo.getY() + i * blockSize, null);
						break;
					default:
						g.drawImage(blocks, PADDING + ufo.getX() + j * blockSize, ufo.getY() + i * blockSize, null);
					}
				}
//System.out.println("bbb:"+(ufo.getY()+ i 
//* blockSize));
//System.out.println("cc:"+( 2 * 
//blockSize));
			}
		g.setColor(Color.black);
		for (int i = 0; i <= boardHeight; i++) {
			g.drawLine(0, i * blockSize, boardWidth * blockSize, i * blockSize);
		}
		for (int j = 0; j <= boardWidth; j++) {
			g.drawLine(j * blockSize, 0, j * blockSize, boardHeight * blockSize);
		}
//-- Hero
		g.drawImage(gun, hero.getX(), END, null);
//-- Fire
		if (fireFlag == true) {
			fireFlag = false;
			int _x = hero.getX() + PADDING;
			g.setColor(Color.red);
			g.fillRect(_x, 0, PADDING, END - PADDING);
			try {
				up: for (int ii = ufo.rows - 1; ii >= 0; ii--)
					for (int jj = 0; jj < ufo.cols; jj++) {
						if (ufo.get(ii, jj) != 0) {
//g.drawImage(blocks,PADDING+ufo.getX()+ j 
//* blockSize,ufo.getY()+ i * blockSize, null);
							int img_x = ufo.getX() + jj * blockSize;
							System.out.println(" get(" + ii + "," + jj + ")");
							if (between(_x, img_x, blockSize)) {
								ufo.kill(ii, jj);
								break up;
							}
						}
					}
			} catch (Exception e) {
			}
		}
// g.drawString("Score:" + score, 
//0, 20);
// g.drawString("Use arrow keys, 
//up to Rotate", 0, 100);
	}

	public void moveHero(int direction) {
		hero.move(direction);
	}

	public void reset() {
		ufo = new UFO(boardWidth, boardWidth);
		hero = new Hero();
		timer.start();
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
}
