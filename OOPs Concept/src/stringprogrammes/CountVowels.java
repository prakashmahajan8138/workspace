package stringprogrammes;

public class CountVowels {
	public static void main(String[] args) {
		String s="meranaaamjoker";
		char c='a';
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char d=s.charAt(i);
			if(c==d)
			{
				count+=1;
			}
			
			
		}
		System.out.println(count);
	}

}
