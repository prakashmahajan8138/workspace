package NumberProgramas;

import java.util.Scanner;

public class PrimeNumber 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int a = sc.nextInt();
		boolean flag=true;
		int i=2;
		while(i<a)
		{
			if(a%i ==0)
			{
				flag=false;
				break;
			}
			i++;
		}
		if(flag==true)
		{
			System.out.println("num is prime number");
		}
		else
		{
			System.out.println("num is not prime number");
		}
		sc.close();
	}

}
