package stringprogrammes;

public class Consonents 
{
	public static void main(String[] args)
	{
		String s="Shravanbala1225698marrajhe";
		char ch;
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(!('0' <=ch ) ||  !(ch<='9'))
				if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
				{
					
					count+=1;
					
				}
				else
				{
					System.out.print(ch+",");
				}
			
			
		}
		System.out.println(" ");
		System.out.println(26-count);
		
		
	}

}
