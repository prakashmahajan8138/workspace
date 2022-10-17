package inheritance;

public class Student extends Person {
  //Student --firstName.lastName,grad year,course,fees,marks
	private int gradYear;
	private String courseName;
	private double fees;
	private int marks;
	
	public Student(String fn,String ln,int gradYear,String courseName,double fees,int marks)
	{
		super(fn,ln);//prog must call explicitly the Matching super class constructor
		System.out.println("in student's constructor...");
		//sub class specific init
		this.gradYear=gradYear;
		this.courseName=courseName;
		this.fees=fees;
		this.marks=marks;
	}
	
	public String toString()
	{
		return"Student"+super.toString()+"yr of passing"+gradYear+"course"+ courseName+"fees"+fees+
      "marks"+marks;				
	}
}
