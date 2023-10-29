package com.benny.alg;

public class Utils {
	
	private final static double DELTA = 1.0;

	// -- instead of equality A==B+- DELTA;
	public static boolean equalsInDelta(double first, double second) {
		
		if (Math.abs( Math.abs(first) - Math.abs(second) ) < DELTA)
			return true;
		else return false;
	}
	
	
	public static boolean between(int test ,int first, int second) {
		
		int max = Math.max(first, second);
		int min = Math.min(first, second);
		
		if (test >= min && test <= max)
			return true;
		else return false;
	}
	
	public static boolean isNullOrEmpty(String s) 
	{
		if ( s==null || s.trim().length() == 0)
			return true;
		else
			return false;
	}
}
