package polymorphism;
import inheritance.Student;
import inheritance.Person;
import inheritance.Faculty;;


public class Test3 {
	public static void main(String[] args) {
	 Person[] people= {new Student("Rama", "Singh", 2020, "eDac", 12345, 78),new Faculty("Amit", "Kulkarni", 10, "java.netRest")}; //same as new People{};
	 //three objects are created
	 //1. array of refs,2.Student obj created outside and its ref added in the 0th index of the array
	 //faculty obj created outside & its ref added in the 1st index of array
	 //people[0] : person -->student obbj,people[1]-->faculty
	 
	 for(Person p:people)//p=people[0],p=people[1]
		 System.out.println(p);
	}
}
