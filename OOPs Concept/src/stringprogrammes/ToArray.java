package stringprogrammes;

public class ToArray {
	public static void main(String[] args) {
		String s="Prakash";
		char [] s1=new char[] {};
		for(int i=0;i<s.length();i++)
		{
			s1=s.toCharArray();
		}
		for (char c : s1) {
			System.out.print(c+" ");
		}
	}

}
