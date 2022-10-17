package callby;

public class Callby 
{

	public static void main(String... args) 
	{
		int data = 100;
		System.out.println( data + " " );
		processData(data);
		System.out.println( data);
		Callby m = new Callby();
		System.out.println(m.m1(50));
	}

	private static  void processData(int data) 
	{
		data=data * 2;
	}
	public int m1(int data)
	{
		data=data*2;
		return data ;
	}
}