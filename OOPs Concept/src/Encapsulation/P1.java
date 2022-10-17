package Encapsulation;

 class EncapDemo {
	
	private int a=10;
	private String s1="Prakash";
	public void set(int a)
	{
		this.a=a;
	}
	private static int m1 ()
	{
		return 10;
	}
	public int get() 
	{
		return a;
	}
	public int getm1() 
	{
		return m1();
	}
	public String get1() 
	{
		return s1;
	}
}
public class P1{
	public static void main(String[] args) {
		EncapDemo d;
		d=new EncapDemo();
		int s = d.get();
		String l = d.get1();
		System.out.println(s);
		System.out.println(l);
		System.out.println(d.getm1());
	}
	
}
