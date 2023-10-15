package roman;

public class CalcUtils {
	
	public static  int add(int a, int b)
	{
		return a+b;
	}
	
	public static int sub(int a, int b)
	{
		return a-b;
	}
	
	public static int mul(int a, int b)
	{
		return a*b;
	}
	
	public static int dev(int a, int b)
	{
		if (b != 0)
			return a/b;
		else return 0;
	}
	
	
}
