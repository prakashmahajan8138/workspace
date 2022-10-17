package abstraction;

interface Interface2 {
	int a=45;
	String b="prakash";
	static int c=45;
	public void m1();
	public default int m3()
	{
		return a;
	}

	private String m4()
	{
		return b;
	}
	public default String m5()
	{
		return m4();
	}
	public static void m2() 
	{
		System.out.println("from static method");
	}
}
public class Interface1 implements Interface2
{
	public void m1() 
	{
		System.out.println("overridden");
	}	
	public static void main(String[] args) {
		Interface1 c;
		c=new Interface1();
		c.m1();
		Interface2.m2();
		System.out.println(c.m3());
		System.out.println(c.m5());



	}

}

