package NumberProgramas;

public class SumOfDigit {
	public static void main(String[] args) {
		int num=12345789;
		int num1=0;
		
		while(num>0)
		{
			int r = num%10;
			num1=num1+r;
			num=num/10;
			
			
		}
		System.out.println(num1);
		}

}
