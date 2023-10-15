package roman;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Converter {

	static String RomanArr[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	static int RomanVals[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	static int[] revs = reverse(RomanVals);
	static TreeMap<String,Integer> Romap = new TreeMap<>();
	static TreeMap<Integer,String> Digmap = new TreeMap<>();
	
	public static int[] reverse (int []arr)
	{
		int[] result = new int[arr.length];
		
		for (int i= 0; i < arr.length ; i++)
		{
			result[arr.length - 1 -i] = arr[i];
		}
		return result;
	}
	public static void main(String[] args) {

			Romap.put("I",1);
			Romap.put("IV",4);
			Romap.put("V",5);
			Romap.put("IX",9);
			Romap.put("X",10);
			Romap.put("XL",40);
			Romap.put("L",50);
			Romap.put("XC",90);
			Romap.put("C",100);
			Romap.put("CD",400);
			Romap.put("D",500);
			Romap.put("CM",900);
			Romap.put("M",1000);
			
			Digmap.put(1,"I");
			Digmap.put(4,"IV");
			Digmap.put(5,"V");
			Digmap.put(9,"IX");
			Digmap.put(10,"X");
			Digmap.put(40,"XL");
			Digmap.put(50,"L");
			Digmap.put(90,"XC");
			Digmap.put(100,"C");
			Digmap.put(400,"CD");
			Digmap.put(500,"D");
			Digmap.put(900,"CM");
			Digmap.put(1000,"M");
			
			
			
			
			;
			//System.out.println(Arrays.toString(revs));
			
			int value = 2347;
			String result = "";
			
			while ( value > 0)
			{
				int numberToRemove = getMax(value);
				String romy= Digmap.get(numberToRemove);
				result += romy;
				value-= numberToRemove;
				
				//result += 
			}
			
			
			System.out.println("result="+result);
			
			
			
			
			
		if(true)
			return;
		
		
		
		
		
		String source = "MCXXIV";

		int val= 0;
		while (true) {

			String tmp2 = source.substring(0, 2);
			String tmp1 = source.substring(0, 1);
			Integer val2 = Romap.get(tmp2);
			Integer val1 = Romap.get(tmp1);
				if (val2 != null) {
					source= source.substring(2);
					val += val2;
				}else if(val1 != null) {
					source= source.substring(1);
					val += val1;
				}else
					break;
				
				
				System.out.println("source ="+ source);
				System.out.println("val ="+ val);

			
				if (source.length() == 0)
					break;
		}

	}

	private static int getMax(int value) {
				
		int last = 0;
		for(int i = RomanVals.length - 1 ; i >= 0 ; i-- )
			
		{
			int romy = RomanVals[i];
			if (value > romy)
				return romy;
		}
		return 1;
	}

	static int in( String chk) {
		Integer val = Romap.get(chk);
		if(val != null) 
			return val;
		return -1;
		
	}

}
