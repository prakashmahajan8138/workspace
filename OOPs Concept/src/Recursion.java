
public class Recursion {
	
	public static  void display(int a)
	{
		if(a%2==0)
		{
			System.out.println(a+" "+"even");
		}
		else if(a>10)
		{ 
			return;
		}
		a++;
		display(a);
	}
	public static void main(String[] args) {
		display(1);
	}

}
