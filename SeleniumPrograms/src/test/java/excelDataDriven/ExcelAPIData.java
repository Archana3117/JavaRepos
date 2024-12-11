package excelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPIData {
	
	
	public  File f=null;
	public  FileInputStream fis=null;
	public  FileOutputStream fos=null;
	public  XSSFSheet sheet=null; 
	public  XSSFRow row=null;
	public  XSSFCell cell=null;
	public  XSSFWorkbook wb=null;
	String  xfilepath;
	
	ExcelAPIData(String xfilepath) throws Exception
	{
		System.out.println("Excel has initalized..");
		f=new File(xfilepath);
		fis=new FileInputStream(f);
		wb=new XSSFWorkbook(fis);
	}
	
	//get row count
	public int getRowCount(String sheetName)
	{
		sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	//get totalColumn count
	public int getCellCount(String sheetName)
	{
		
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(0);
		int cellCount=row.getLastCellNum();
		return cellCount;
		
	
	}
	//reading cell data from Excel by using Column Number
	public String getCellData(String sheetName,int colName,int rowNum)
	{
		
		try {
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colName);
		
		
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
		{
			String cellValue=String.valueOf(cell.getNumericCellValue());
			
			if(HSSFDateUtil.isCellDateFormatted(cell))
			{
				
				DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
				Date date =cell.getDateCellValue();
				cellValue=dt.format(date);
			}
			return cellValue;
		}
		else if(cell.getCellType()==CellType.BLANK)
		
			return "" ;
			
			else
				return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "no matching value";
		}
		
	}
		

		//Reading excel cell data by using colume name
		public String getCellData(String sheetName,String colName,int rowNum)
		{
			try {
			int colNum=-1;
		
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(0);
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					colNum=i;
				}
			}
			
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
			{
				String cellValue=String.valueOf(cell.getNumericCellValue());
				
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					Date date =cell.getDateCellValue();
					cellValue=dt.format(date);
					
				}
				return cellValue;
			}
			else if(cell.getCellType()==CellType.BLANK)
				return "";
			
			
			else 
			return String.valueOf(cell.getBooleanCellValue());
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching value" ;
		}
			
		}		
			//Writing cell data to Excel by using Column Number
			public boolean setCellData(String sheetName,int colNum,int rowNum,String value)
			{
				
				try
				{
					sheet=wb.getSheet(sheetName);
					row=sheet.getRow(rowNum);
					cell=row.getCell(colNum);
					
					cell.setCellValue(value);
					
					fos=new FileOutputStream(xfilepath);
					wb.write(fos);
					fos.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			
			//Writing cell data to Excel by using Column Name
			public boolean setCellData(String sheetName,String colName,int rowNum,String value)
			{
				
				try
				{
					int colNum=-1;
					sheet=wb.getSheet(sheetName);
					
					row=sheet.getRow(rowNum);
					for(int i=0;i<row.getLastCellNum();i++)
					{
						if(row.getCell(i).getStringCellValue().trim().equals(colName));
						{
							colNum=i;
						}
					}
					row=sheet.getRow(rowNum+1);
					//if(row==null)
						//row=sheet.createRow(rowNum-1);
					
					cell=row.getCell(colNum);
					//if(cell==null)
						//cell=row.createCell(colNum);
					
					cell.setCellValue(value);
					
							
					fos=new FileOutputStream(xfilepath);
					wb.write(fos);
					fos.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}

}

