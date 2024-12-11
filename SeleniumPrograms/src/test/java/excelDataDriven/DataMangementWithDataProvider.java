package excelDataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataMangementWithDataProvider {
	
	
	@Test(dataProvider =("getData"))
	public void testcaseData(String RunMode,String browser,String UserName,String UserPassword,String expectedResult) 
	{
		
	}

	
	@DataProvider
	 public Object[][] getData() throws Exception
	  {
   	    ExcelAPIData e = new ExcelAPIData("C:\\Users\\Lenovo\\Downloads\\suitex.xlsx");
		String sheetName = "data";
		String testName = "TestA";

		// find matching testcase Rownumber
		int teststartrownum = 0;
		while(!e.getCellData(sheetName, 0, teststartrownum).equals(testName)) {
			teststartrownum++;
		}
		System.out.println(testName + " start row num " + teststartrownum);

		
		  int colstartrownum=teststartrownum+1;  //colum name starts so add +1 browser
		  int datastartrownum=teststartrownum+2;  //for row test case data add+2 eg y
		  
		  //calculate the rows of data
		  
		  int rows=0;
		  
		  while(!e.getCellData(sheetName, 0, datastartrownum+rows).equals(""))
		  {
		  rows++;
		  } 
		  System.out.println("total rows are in testcase:"+rows);
		  
		  
		  //calculate col of data 
		  int cols=0; 
		  while(!e.getCellData(sheetName, cols,colstartrownum).equals("")) 
		  { 
			  cols++; 
		 } 
		  System.out.println(cols);
		  
		  //Read the test data 
		  int dataRow=0;
		  Object[][] data=new Object[rows][cols];
		  for(int rnum=datastartrownum;rnum<datastartrownum+rows;rnum++)  
		  { 
			  for(int cnum=0;cnum<cols;cnum++) 
			  { 
				  data[dataRow][cnum]=e.getCellData(sheetName, cnum, rnum);
			  }
			  dataRow++;
		  } 
			return data; 
		  
	}
	  }
		  
		 

