package Collection;

import java.util.ArrayList;

public class Arraylist1 {
	
	public static void main(String[] args) {
		ArrayList<Object> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add("String");
		arr1.add(true);
		
		
		Object[] arr = arr1.toArray();
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
