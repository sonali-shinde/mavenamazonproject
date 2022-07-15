package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void captureScreen(WebDriver driver,int testID) //testID will be int or string
	{
		//code
	}
	public static String getDataFromExcel(String sheet1,int row,int cell) throws EncryptedDocumentException, IOException
	{
		//code
		String path="D:\\selenium\\testing1.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(file);
		Sheet sheet=book.getSheet("Velocity");
		int lastRowNum=sheet.getLastRowNum();
		for(int i=0;i<=lastRowNum;i++)
		{
			String row1=sheet.getRow(i).getCell(0).getStringCellValue();
			String row2=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(row1 + "   " + row2);
		}
		String data = null;
		try 
		{
			//data=getStringCellValue();
		}
		catch(Exception e)
		{
			//double value=getNumericCellValue();
			//data=value to String;
			
		}
		return data;
	}
}
