package analog;


class A{
	String Name;
	
}
public class Ref {

	public static void main(String[] args) {
		A a = new A();
		a.Name = "4";
		dosomething(a);
		System.out.println(a.Name);

	}
	
	static void dosomething( A a)
	{
		a.Name += 2;
	}

}
