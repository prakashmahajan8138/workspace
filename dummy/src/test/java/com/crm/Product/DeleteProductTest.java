package com.crm.Product;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.PlusProductPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;


public class DeleteProductTest extends BaseClass{
    
	@Test
	public void deleteProductTest() throws Throwable, Throwable {
		
       
        
        
        //clicking on product link
        
        HomePage hp = new HomePage(driver);
        hp.clickProduct();
        
      //clicking on plus sign
        PlusProductPage ppp = new PlusProductPage(driver);
        ppp.createProductLink();
        
        Java_Utility jlib = new Java_Utility();
        int ran = jlib.getRanDomNum();
        
      //fetching product name from excel
        Excel_Utility elib = new Excel_Utility();
        String productName = elib.getDataFromExcel("product", 0, 0)+ran;
        
        //creating product
        CreateProductPage cpp = new CreateProductPage(driver);
        cpp.createProduct(productName);
        
        
        
        //validation
        ProductInfoPage pip = new ProductInfoPage(driver);
        String actData = pip.ValidationText();
		System.out.println(actData);
		if(actData.contains(productName))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
		
		pip.deleteProduct();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchToAlertAndAccpect(driver);
		
		
		
	}

}
