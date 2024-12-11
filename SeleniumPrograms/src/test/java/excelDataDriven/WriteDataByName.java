package excelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataByName {
	
	public static void main(String[] args) throws Exception {
		
		
		File f=new File("C:\\Users\\Lenovo\\Downloads\\testdata1.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell=null;
		
		int cellIndex=-1;
		for(int c=0;c<row. getLastCellNum();c++)
		{
			if(row.getCell(c).getStringCellValue().trim().contains("Result"))
			{
				cellIndex=c;
			}
		}
		
	 row = sheet.getRow(4);
	 cell=row.getCell(cellIndex);
	 cell.setCellValue("Pass");
	 
	 
	 FileOutputStream fo=new FileOutputStream(f);
	 wb.write(fo);
	 fo.close();
	 wb.close();
	}

}
