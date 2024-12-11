package excelDataDriven;

public class ExcelOperations {
	
	public static void main(String[] args) throws Exception {
		
		ExcelAPIData e=new ExcelAPIData("C:\\Users\\Lenovo\\Downloads\\testdata1.xlsx");
		System.out.println("row count"+e.getRowCount("login"));
		System.out.println("col count"+e.getCellCount("login"));
		
		System.out.println(e.getCellData("login",0,1));
		System.out.println(e.getCellData("login","Password",1));
		e.setCellData("login", 4, 2, "Abort");
		
	}

}
