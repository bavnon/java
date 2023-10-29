/**
 * 
 */
package com.benny.test;

import com.benny.alg.Line;

/**
 * @author User
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int x0=5, y0=40, x1=60,y1=19,x2=42,y2=105;
		
		int testX=23,testY=54;
		
		Line line1 = new Line(x0,y0,x1,y1);
		Line line2 = new Line(x0,y0,x2,y2);
		Line line3 = new Line(x2,y2,x1,y1);
		
		if (line1.isContact(testX, testY) &&
			line2.isContact(testX, testY) &&
			line3.isContact(testX, testY) 
			) {
			
			System.out.println("inside");	
		}else
			System.out.println("outside");
			
			
		
		

	}

}
