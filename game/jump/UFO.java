package jump;

//Made By Benny Avnon
public class UFO {
	final int rows = 2;
	final int cols = 4;
	int[][] gang;
	int x, y, _maxX, _maxY;
	int direction = -1;
	private int delta = 1;

	int[][] update(int[][] board) {
		int tempX = x + (direction * delta);
		if (tempX < -0.5 * _maxX) {
			rest();
			return update(board);
		}
		for (int i = 0; i < cols; i++) {
// for (int j = 0; j < cols; j++) {
			if (tempX + i >= _maxX || tempX + i < 0)
				continue;
			if (gang[1][i] == 1 && (tempX + i) < _maxX) {
				board[1][tempX + i] = Types.RED.ordinal();
			} else if (gang[1][i] == 2 && (tempX + i) < _maxX) {
				board[1][tempX + i] = Types.BLACK.ordinal();
			} else {
				board[1][tempX + i] = Types.WHITE.ordinal();
			}
		}
		x = tempX;
		return board;
	}

	public boolean colission(int tempX, int tempY) {
//for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++) {
			if (gang[1][j] != 0) {
				if (tempX == j && tempY == 1) {
					return true;
				}
			}
		}
		return false;
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
// System.out.println(" kill("+x+","+y+")");
		gang[x][y] = 0;
	}

	public void rest() {
		x = _maxX;
		y = delta;
		int[][] gang1 = { { 0, 0, 0, 0 }, { 1, 2, 1, 2 } };
		gang = gang1;
	}

	public UFO(int maxX, int maxY) {
		super();
		_maxX = maxX;
		_maxY = maxY;
		rest();
	}

	public int get(int i, int j) {
// System.out.println(" get("+x+","+y+")");
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
}
