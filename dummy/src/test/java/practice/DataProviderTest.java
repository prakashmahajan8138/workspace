package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
    @Test(dataProvider="dataProvider_Test")
	public  void bookTicket(String src,String dest) {
		System.out.println("Book tickets from"+src+"to"+dest+"");

	}
	@DataProvider
	public Object[][] dataProvider_Test()
	{
		Object [][] objArr=new Object[5][2];
		
		objArr[0][0]="Pune";
		objArr[0][1]="Shahada";
		
		objArr[1][0]="Shahada";
		objArr[1][1]="Pune";
		
		objArr[2][0]="Pune";
		objArr[2][1]="Bangalore";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="Pune";
		
		objArr[4][0]="Pune";
		objArr[4][1]="Shahada";
		
		return objArr;
		}

}
