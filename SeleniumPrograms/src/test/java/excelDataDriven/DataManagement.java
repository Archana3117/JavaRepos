package excelDataDriven;

public class DataManagement {
	
	public static void main(String[] args) throws Exception {

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
		
		  for(int rnum=datastartrownum;rnum<datastartrownum+rows;rnum++)  
		  { 
			  for(int cnum=0;cnum<cols;cnum++) 
			  { 
				  System.out.println(e.getCellData(sheetName, cnum, rnum));
			  }
		  
		  } 
			 
		  
	}

}
