package excelDataDriven;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataManagementFinal {
	
  @Test(dataProvider = "getData")
  public void testcaseData(Hashtable<String, String > str) throws Exception {
	  System.out.println(str.get("Browser"));
	  
	 
  }
  
  
  @DataProvider
  public  Object[][]getData()throws Exception
  {
	  ExcelAPIData e=new ExcelAPIData("C:\\Users\\Lenovo\\Downloads\\suitex.xlsx");
	  String sheetName="data";
	  String testName="LoginTest";
	  
	return ExcelDataUtil.getTableData(e,sheetName,testName);
	  
  }
}
