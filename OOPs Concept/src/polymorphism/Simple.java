package polymorphism;
class A{
	private String s="prakash";
	public String m1()
	{
		return s;
	}
}

public class Simple {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.m1());
	}

}
