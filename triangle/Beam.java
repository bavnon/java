/**
 * 
 */
package com.benny.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benny Date : 06/11/2020
 *
 */
public class Beam {

	int tempX, tempY;
	int x, y;
	int minX, maxX, minY, maxY; // the borders

	public Beam(int x, int y, int minX, int maxX, int minY, int maxY) {
		super();
		this.x = x;
		this.y = y;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public List<Point> getLeftBeam() {

		tempX = x;
		tempY = y;
		ArrayList<Point> lst = new ArrayList<>();
		while (tempX > minX) {
			lst.add(new Point(tempX--, tempY));
		}
		return lst;

	}

	public List<Point> getRightBeam() {

		tempX = x;
		tempY = y;
		ArrayList<Point> lst = new ArrayList<>();
		while (tempX < maxX) {
			lst.add(new Point(tempX++, tempY));
		}
		return lst;

	}

	public List<Point> getUPBeam() {

		tempX = x;
		tempY = y;
		ArrayList<Point> lst = new ArrayList<>();
		while (tempY > minY) {
			lst.add(new Point(tempX, tempY--));
		}
		return lst;

	}
	
	public List<Point> getDownBeam() {

		tempX = x;
		tempY = y;
		ArrayList<Point> lst = new ArrayList<>();
		while (tempY > maxY) {
			lst.add(new Point(tempX, tempY++));
		}
		return lst;

	}

}
