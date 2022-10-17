package constructor;

 class Constructor {
	
	private String s="prakash";
	String s1;
	int x;
	 int y;
	Constructor()
	{
		 System.out.println("hey i am here..!!!");
	}
	 Constructor(String s1)
	{
		this.s1=s1;
		System.out.println("surprise no..?");
	}
	Constructor(int x,int y)
	{
	   	this.x=x;
	   	this.y=y;
	   	System.out.println("main fire hai");
	}

}
public class Constructor1{
	public static void main(String[] args) {
		Constructor c = new Constructor();
		Constructor c1 = new Constructor("Prakash");
		Constructor c2=new Constructor(10,20);
		
		System.out.println(c1.s1);
		
		System.out.println(c2.x+""+c2.y);
		
	}
}
