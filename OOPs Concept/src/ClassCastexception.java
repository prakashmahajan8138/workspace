
class A
{
	A a;
	Number n;
	
	public  A  m1() 
	{
		System.out.println("from m1");
		return a; 
	}
	public Number m3()//overridden
	{
		return n;
	}
	

	
}
class B extends A
{
	B b;
	public void m2() 
	{
		System.out.println("from m2");
	}
	public B m1()
    {
    	System.out.println("from B");
    	return b;
    }
	@Override
	public Double m3() //overridding 
	{
		return 10.0;
	}

    	
}
public class ClassCastexception
{
	public static void main(String[] args)
	{
		 A a=new B(); //upcasting
		 //a.m2();  //ClassCastexception
		 a.m1();
		 System.out.println(a.m3());
		 B c=(B)a; //Downcasting
		 c.m2();
		
		 
	}	

}

