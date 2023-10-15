package games.space;

//Made By Benny Avnon
public class Hero {
	int x = 0, y = 700;
	int width = 10;
	private int delta = 170;

	public Hero() {
		super();
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

	public void update() {
	}

	public void move(int direction) {
		int tempX = x + direction * (delta);
		if (tempX > -delta && tempX < width * delta)
			x = tempX;
	}
}
