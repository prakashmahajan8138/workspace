package inheritance;



public class Faculty extends Person {
	//firstName,lastName,yrs of experience ,sme
	private int expInyears;
	private String sme;
	public Faculty(String firstName,String lastName,int expInYears,String sme)
	{
		super(firstName,lastName);
		System.out.println("in faculty constructor");
		this.expInyears=expInYears;
		this.sme=sme;
	}
	@Override
	public String toString()
	{
		return "Faculty"+super.toString()+"exp"+expInyears+"sme"+sme;
	}
   
}