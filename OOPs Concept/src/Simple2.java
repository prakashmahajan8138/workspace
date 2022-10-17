class Laptop{
	int a=10;
 String s="prakash";
 public void m1()
 {
	 System.out.println("from Laptop");
 }
}
class Dell extends Laptop{
	public void m1()
	 {
		 System.out.println("from Dell");
	 }
}
public class Simple2 {
	public static void main(String[] args) {
		Dell d1 = new Dell();
		Laptop lp=d1;
		d1.m1();
		
		//Laptop d=new Dell();
		//d.m1();
	}

}
