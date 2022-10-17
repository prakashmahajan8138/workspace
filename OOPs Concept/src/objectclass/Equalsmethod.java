package objectclass;

public class Equalsmethod {
	public static boolean equals()
	{
		return true;
	}
	
	int a=20;
	public static void main(String[] args) {
		Equalsmethod e1 = new Equalsmethod();
		Equalsmethod e2=new Equalsmethod();
		if(e1.equals(e2))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}

}
