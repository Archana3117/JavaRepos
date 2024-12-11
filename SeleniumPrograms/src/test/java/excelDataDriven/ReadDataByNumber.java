package excelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataByNumber {
	
	public static void main(String[] args) throws Exception {
		
		File f=new File("C:\\Users\\Lenovo\\Downloads\\testdata1.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheetname =wb.getSheet("login");
		
		XSSFRow row=sheetname.getRow(1);
		XSSFCell cell=row.getCell(1);
		String val=cell.getStringCellValue();
		System.out.println(val);
		wb.close();
		fis.close();
	}

}
