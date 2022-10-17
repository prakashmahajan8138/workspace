package objectclass;
//hashcode method of object class userd to convert the address or reference into int format
public class HashCodeDemo1 {
	
	int hc=10;
	public int hashCode()
	{
		return hc;
	}
	public static void main(String[] args) {
		HashCodeDemo1 h1 = new HashCodeDemo1();
		
		
		System.out.println(h1.hashCode());
	}

}
