package excelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRowAndColumCOunt {
	public static void main(String[] args) throws Exception {
		
		File f=new File("C:\\Users\\Lenovo\\Downloads\\testdata1.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		
		int rowcount = sheet.getLastRowNum()+1;
		System.out.println("total row is:"+rowcount);
		
		short cellCount = sheet.getRow(0).getLastCellNum();
		System.out.println("total cell:"+cellCount);
	}

}
