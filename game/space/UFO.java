package games.space;

//Made By Benny Avnon

public class UFO {
	final int rows = 2;
	final int cols = 4;
	int[][] gang;
	int x, y, _maxX, _maxY;
	int direction = -1;
	private int delta = Matrix.getBlockSize() / 7;

	void update() {
		int tempX = x + (direction * delta);
		double tempY = y + delta / 2.0;
		if (colission(tempX, (int) tempY)) {
			// direction = -1 * direction;

			rest();
			// y = (int) tempY;
		}
		x = tempX;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void kill(int x, int y) {
//System.out.println(" kill("+x+","+y+")");
		gang[x][y] = 0;
	}

	public void rest() {
		x = delta;
		y = delta;
		int[][] gang1 = { { 1, 2, 3, 4 }, { 3, 4, 2, 1 } };
		gang = gang1;
	}

	public UFO(int maxX, int maxY) {
		super();
		_maxX = maxX;
		_maxY = maxY;
		rest();
	}

	public boolean colission(int _x, int _y) {
		int wid = getWidth();
		int block = Matrix.getBlockSize();
		if (_x < wid || _x / block >= (_maxX - wid))
			return true;
// if ( y > _maxY)
// return true;
//System.out.println("ufo hi"+getHeight());
//System.out.println("ufo1"+y);
//System.out.println("ufo2");return false;
		return false;
	}

	public boolean colissionY(int _y) {
		int hi = getHeight();
		int block = Matrix.getBlockSize();
		if (_y / block >= (_maxY - hi + 1))
			return true;
// if ( y > _maxY)
// return true;
		return false;
	}

	public int get(int i, int j) {

		return gang[i][j];
	}

	public int getWidth() {
		int max = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (gang[i][j] != 0) {
					if (max < j) {
						max = j;
					}
				}
			}
		return max + 1;
	}

	public int getHeight() {
		int max = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (gang[i][j] != 0) {
					if (max < i * Matrix.getBlockSize()) {
						max = i * Matrix.getBlockSize();
					}
				}
			}
		return max;
	}
}