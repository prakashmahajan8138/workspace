package method;
class MethodDemo
{
	public void m1()
	{
		System.out.println("Bhai sun ..!!");
	}
	public void m1(int a)
	{
		System.out.println(a);
	}
	public void m1(int a,int b)
	{
		System.out.println(a+b);
	}
	
}

public class Method1
{
	public static void main(String[] args) 
	{
		MethodDemo ob1 = new MethodDemo();
		ob1.m1();
		ob1.m1(10);
		ob1.m1(25,30);
	}

}
