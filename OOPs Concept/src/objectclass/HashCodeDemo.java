package objectclass;
class Demon{
	int a=10;
	int b=20;
}

class HashCodeDemo{
	public static void main(String[] args){
		Demon d1 = new Demon();
		Demon d2 = new Demon();
		if(d1.equals(d2)){
			System.out.println("Equal variables:");
			System.out.println(d1.hashCode() + "\n" + d2.hashCode());
		}
		String a = "200";
		String b = "200";
		if(a.equals(b)){
			System.out.println("Equal variables:");
			System.out.println(a.hashCode() + "\n" + b.hashCode());
		}
		String c = "10";
		String d = "50";
		if(!c.equals(d)){
			System.out.println("\nUn-equal variables:");
			System.out.println(c.hashCode() + "\n" + d.hashCode());
			
		}
		String s1=new String("");
		String s2=new String("");
		if(s1.equals(s2)){
			System.out.println("Equal variables:");
			System.out.println(s1.hashCode() + "\n" + s2.hashCode());
		}
		else {System.out.println("none");}
		
		if(s1==s2)
		{
			System.out.println("yes");
		}
	}
}