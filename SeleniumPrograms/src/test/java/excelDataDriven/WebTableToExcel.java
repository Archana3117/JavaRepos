package excelDataDriven;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableToExcel {
	
	public static void main(String[] args) throws IOException 
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers");
		
		String path="C:\\Users\\Lenovo\\Downloads\\ShareMarketdataSheet.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		//Write headers in excel sheet
		xlutil.setCellData("Sheet1", 0,0, "Company");
		xlutil.setCellData("Sheet1", 0,1, "Prev Close");
		xlutil.setCellData("Sheet1", 0,2, "Current Price");
		xlutil.setCellData("Sheet1", 0,3, "Change");
		
		
		//capture table cols
		
		WebElement table=driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr"));
		int cols=table.findElements(By.xpath("th")).size(); // cols present in web table
		System.out.println("cols is"+cols);
		
		for(int thead=1;thead<=cols;thead++)
		{
			//read data from web table
			
			String Company=table.findElement(By.xpath("th[1]")).getText();
			String PrePrice=table.findElement(By.xpath("th[3]")).getText();
			String ClosePrice=table.findElement(By.xpath("th[4]")).getText();
			String Change=table.findElement(By.xpath("th[5]")).getText();
			
			System.out.println(Company + PrePrice + ClosePrice + Change);
			
			//writing the data in excel sheet
			xlutil.setCellData("Sheet1", 0, 0, Company);
			xlutil.setCellData("Sheet1", 0, 1, PrePrice);
			xlutil.setCellData("Sheet1", 0, 2, ClosePrice);
			xlutil.setCellData("Sheet1", 0, 3, Change);			
		}

		//find size for all table rows data
		WebElement tableData=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody"));
		int tabledatRowSize=tableData.findElements(By.xpath("tr")).size();
		System.out.println(tabledatRowSize+"size of rows");
		
		
			for(int i=1;i<=tabledatRowSize;i++)
			{
				for(int j=0;j<=cols;j++)
				{
					String Company=tableData.findElement(By.xpath("tr[]")).getText();
					System.out.println(Company +"...");
				}
			}
		
		System.out.println("Web scrapping is done succesfully.....");
		driver.close();
		
	}

}
