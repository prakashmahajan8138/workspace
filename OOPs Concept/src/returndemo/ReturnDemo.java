package returndemo;

import java.util.Scanner;

public class ReturnDemo {
	
	
	public String m1(String s1,String s2)
	{
		return s1+s2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1=sc.nextLine();
		String s2 = sc.nextLine();
		ReturnDemo r1 = new ReturnDemo();
		System.out.println(r1.m1(s1, s2));
		sc.close();
	}
	

}
