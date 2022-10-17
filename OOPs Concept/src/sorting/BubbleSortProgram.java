package sorting;

import java.util.Arrays;
class BubbleSortProgram 
{
	public static void main(String[] args) 
	{
		int [] a1={12,7,15,56,0,5};
		System.out.println("before sorting");
		System.out.println(Arrays.toString(a1));
		for(int i=0;i<a1.length;i++)
		{
			for(int j=i+1;j<a1.length;j++)
			{
				if(a1[i]>a1[j])
				{
					int temp=a1[i];
					a1[i]=a1[j];
					a1[j]=temp;
				}
			}
		}
		System.out.println("after sorting");
		System.out.println(Arrays.toString(a1));
	}
}
