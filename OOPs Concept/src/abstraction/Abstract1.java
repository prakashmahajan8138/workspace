package abstraction;

abstract class A 
{
	static int b;
	int c=45;

	public void m3() 
	{
		
	};
	public  void m1() 
	{
		int a=10;
		System.out.println(a);

	}

	public static void m2()
	{
		System.out.println(b);
	}
	abstract void m4() ;

}

class Abstract1 extends A

{

	public Abstract1(int i, int j) {
		System.out.println("from abstract1");
	}
	public Abstract1() {
		// TODO Auto-generated constructor stub
	}
	public void m3()
	{
		System.out.println("override");	
	}
	public static void main(String[] args) 
	{

		A b = new Abstract1();
		A b2 = new Abstract1(10,20);
		b.m1();
		A.m2();
		b.m3();
		b.m4();
		System.out.println(b.c);


	}
	@Override
	void m4() {
		// TODO Auto-generated method stub

	}
}
