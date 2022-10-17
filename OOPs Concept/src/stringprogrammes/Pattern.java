package stringprogrammes;

public class Pattern {
	public static void main(String[] args) {
		int a=5;
		
		for(int i=0;i<=a;i++)
		{
			for(int j=0;j<=a;i++)
			{
                if(i==j)
                {
                	System.out.println("*"+" ");
                }
                else
                {
                	System.out.println(" ");
                }
			}
			System.out.println("");
		}
	}

}
