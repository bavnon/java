package com.benny.alg;

public class Point {
	int x,y;
	public final static int MINX = 0;
	public final static int MINY = 0;
	public final static int MAXX = 0;
	public final static int MAXY = 0;

	public static int getMinx() {
		return MINX;
	}

	public static int getMiny() {
		return MINY;
	}

	public static int getMaxx() {
		return MAXX;
	}

	public static int getMaxy() {
		return MAXY;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	
}
