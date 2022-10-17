package com.crm.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	
	/**
	 * this method is used to fetch data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Prakash
	 */
	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
//		DataFormatter format=new DataFormatter();
//		return format.formatRawCellValue(book.getSheet(sheetName).getRow(RowNum).getCell(cellNum))
		FileInputStream fis = new FileInputStream("./data/creds.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(RowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
		
		
	}
	public String getDataFromExcel1(String sheetName,int RowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream("./data/creds.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
     	return format.formatCellValue(book.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
		
		
		
	}
}
