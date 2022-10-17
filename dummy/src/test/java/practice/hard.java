package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class hard {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path="./Book1.xlsx";

		FileInputStream fis=new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);

		String KEY = book.getSheet("Sheet1").getRow(3).getCell(0).getStringCellValue();
		String VALUE = book.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		String URL = book.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
		String USERNAME = book.getSheet("Sheet1").getRow(3).getCell(3).getStringCellValue();
		String PASSWORD = book.getSheet("Sheet1").getRow(3).getCell(4).getStringCellValue();
		String data = book.getSheet("Sheet1").getRow(3).getCell(5).getStringCellValue();

		System.setProperty(KEY, VALUE);
		WebDriver driver=new ChromeDriver();
		//implicitlyWait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login in vtiger
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//added mouse houwering
		WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();

		//creating campain
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("data");
		//adding product
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		//transforming control
		Set<String> windowids = driver.getWindowHandles();
		Iterator <String> stovered=windowids.iterator();
		String parentwindow=stovered.next();
		String childwindow=stovered.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.linkText("ccdddd1")).click();
		driver.switchTo().window(parentwindow);

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		//for the log out
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
