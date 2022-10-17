package stringprogrammes;

public class Palindrome {
	
	public static void main(String[] args) {
		String s="Pralkash";
		String s1="";
		String s2="";
		
		s1=s.toLowerCase();
		for(int i=0;i<s1.length();i++)
		{
			char ch=s1.charAt(i);
			s2=ch+s2;
			
		}
		if(s1.equals(s2))
		{
			System.out.println("String palindrome");
		}
		else
		{
			System.out.println("not a palindrome");
		}
		
	}

}
