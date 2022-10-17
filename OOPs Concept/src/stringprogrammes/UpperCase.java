package stringprogrammes;

public class UpperCase {
	public static void main(String[] args) {
		String s="Prakash";
//		String s1="";
//		s1=s.toUpperCase();
//		System.out.println(s1);
//		
		
		for(int i=0;i<s.length();i++)
		{
		char ch=s.charAt(i);
		if('a'<=ch && ch<='z')
		{
			char ch1=(char) (ch-32);
			System.out.print(ch1);
		}
		else
		{
			System.out.print(ch);
		}
		
		
		}
	}

}
