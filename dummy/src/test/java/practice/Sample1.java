package practice;

import org.testng.annotations.Test;

public class Sample1 {
    
    @Test(priority = 1)
	public void createCustomer()
	{
		System.out.println("customer created");
		int []arr= {1,2,3};
		System.out.println(arr[5]);
	}
    @Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
    @Test(dependsOnMethods = "createCustomer")
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}
    @Test(invocationCount = 3)
	public void deleteCustomer1()
	{
		System.out.println("customer deleted");
	}
}
