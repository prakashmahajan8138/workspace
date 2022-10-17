package polymorphism;
import inheritance.Person;
import inheritance.Faculty;
public class Test1 {
	public static void main(String[] args) {
		//super cls ref,super cls obj,sub cls ref,sub class obj
		//sub cls ref-->sub class obj(direct refernceing);type of the ref n
		//type of the obj is SAME
		
		Student s1 = new Student("Rama", "Mahajan", 2020, "eDac", 8000, 78);
		Faculty f1=new Faculty("lk","narkhede", 2, "aa");
//		Person p1=new Student(fn, ln, gradYear, courseName, fees, marks)
		/*
		 * javac resolves the method binding by the type of the reference @ JVM resolves
		 * the method binding by the type of the object it's reference to*
		 */
		System.out.println(s1); //javac chks if tostring exists in student class : yes compile ok
		//JVM : late Binding -->toString -->will be called done student's object.
		Person p;
		p=s1;//up casting Student-->Person :done implicitly by javac
		
		System.out.println(p);//javac cks if toString exists in person class, in run time(JVM)
		//JVM will invoke toString :of student :i.e.will pick @run time :overriding form of the method
		
		p=new Faculty("lk","narkhede", 2, "aa"); //up casting p-->faculty object
		System.out.println(p);
	}

}
