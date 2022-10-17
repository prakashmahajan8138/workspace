class Apple{
	int a=10;
	static int b=20;
	
	public static void m1()
	{
		int c=b+10;
		System.out.println(c);
		
	}
	public void m2()
	{
		int c=a+b;
		System.out.println(c);
	}
	
	
}
public class StaticAndNonStatic {
	public static void main(String[] args) {
		Apple a = new Apple();
		a.m2();
		a.m1();
		Apple.m1();
		
	}
	

}
