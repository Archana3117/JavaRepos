package excelDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readdata {

	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\Lenovo\\Downloads\\data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("people");

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		double numValue = 0;

		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < cols; c++) {

				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					numValue = cell.getNumericCellValue();
					System.out.print(cell.getNumericCellValue());

					break;
				default:
					if (numValue < 18) {
						cell.setCellValue("Minor");
						FileOutputStream fos = new FileOutputStream(f);
						wb.write(fos);

						System.out.println("Minor");
					} else {

						cell.setCellValue("Major");
						FileOutputStream fos = new FileOutputStream(f);
						wb.write(fos);

						System.out.println("Major");
					}

					break;

				}
				System.out.print("|");

			}
			System.out.println();
		}

	}

}
