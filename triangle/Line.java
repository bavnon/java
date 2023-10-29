package com.benny.alg;

import java.util.List;

import com.benny.alg.LineType;
// -- Made by Bennny Avnon
// 3/12/2020

public class Line {

	int x0, y0, x1, y1;
	double a, b; // y=ax+b
	LineType type;

	public Line(int x0, int y0, int x1, int y1) throws Exception {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;

		if (x0 == x1 && y0 == y1) {
			throw new Exception("You need to enter different points");
		}

		// line paralel to Y-axis
		else if (x0 == x1) {
			// x=-b/a
			b = x0;
			a = 0;
			type = LineType.Y_PARAL;
		} else if (y0 == y1) {
			// y = b;
			b = y0;
			a = 0;
			type = LineType.X_PARAL;
		} else // y=ax+b
		{
			type = LineType.REGULAR;
			double d1 = (double) (y1 - y0);
			double d2 = (double) (x1 - x0);
			a = d1 / d2;

			b = y0 - (a * x0);

		}
	}
	
	
	public boolean isContact(int x4,int y4)
	{
		if (!(Utils.between(x4, x0, x1) && Utils.between(y4, y0, y1)))
			return false;
			
		
		
		
		switch (type) {
			case REGULAR:
				return ( testRegular( x4, y4));				
						
			case X_PARAL:
				return (testXParalel( x4, y4));
				
			case Y_PARAL:
				return (testYParalel( x4, y4));
			
		}
		return false;
	}
	
	public boolean testXParalel(int x4,int y4)
	{
		
		if ((Utils.between(x4, x0, x1) ))
			return true;
	
		
		return false;
	}
	
	public boolean testYParalel(int x4,int y4)
	{
		
		if ((Utils.between(y4, y0, y1) ))
			return true;
	
		
		return false;
	}
	
	public boolean testRegular(int x4,int y4)
	{
		
		
		Point p = new Point(x4,y4);
		Beam beam = new Beam(x4, y4, Point.getMinx(), Point.getMaxx(), Point.getMiny(), Point.getMaxy());
		List<Point> leftLst = beam.getLeftBeam();		
		List<Point> righttLst = beam.getRightBeam();
		List<Point> upLst = beam.getUPBeam();
		List<Point> downLst = beam.getDownBeam();
		
		
		for (Point pt: leftLst) {
			if ( Utils.equalsInDelta(pt.getY(),(a*pt.getX() + b)))
			{
				return true;
			}
		}
		
		for (Point pt: righttLst) {
			if ( Utils.equalsInDelta(pt.getY(),(a*pt.getX() + b)))
			{
				return true;
			}
		}
		
		for (Point pt: upLst) {
			if ( Utils.equalsInDelta(pt.getY(),(a*pt.getX() + b)))
			{
				return true;
			}
		}
		
		for (Point pt: downLst) {
			if ( Utils.equalsInDelta(pt.getY(),(a*pt.getX() + b)))
			{
				return true;
			}
		}
		
		return false;
	}

}
