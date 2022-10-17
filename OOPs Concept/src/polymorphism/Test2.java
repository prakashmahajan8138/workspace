package polymorphism;
import inheritance.Faculty;;


public class Test2 {
	public static void main(String[] args) {
		Object ref=new Student("Rama", "Singh", 2020, "eDac", 12345, 78);
		//indirect ref :upcasting
		System.out.println(ref);//JVM will invoke toString :Student : Dynamic method dispatch
		
		
		//java compiler goes by type ref.
		//jvm goes by object type
		
		ref=new Faculty("Amit", "Kulkarni", 10, "java.netRest");
	}

}
