package objectclass;
class Demo{
	int a=10;
	String b="Prakash";
	public void fun()
	{
		System.out.println("from Demo");
	}
	@Override
	public String toString() 
	{
		return  b+""+a;
	}
	
}

public class ToStringDemo {
	public static void main(String[] args) {
		Demo d = new Demo();
		System.out.println(d.toString());
	}

}
