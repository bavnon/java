package jump;

//Made By Benny Avnon
public class Hero {
	int x = 0, y = 0;
	int width = 10;
	private int delta = 170;

	public Hero() {
		super();
		x = 0;
		y = 1;
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

	public int[][] update(int[][] board) {
		board[y][x] = Types.BLUE.ordinal();
		return board;
	}
// public void move(int direction){
// int tempX = x + direction *( delta );
// if (tempX > -delta && tempX < width*delta)
// x = tempX;
// }
}