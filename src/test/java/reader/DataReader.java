package reader;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
    WebDriver driver = null;

    @Test
    public void   readDataFromExcel() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
//Creating a workbook
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheetAt(0);
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(1).getCell(2));//row num,col num-starts with 0

//String cellval = cell.getStringCellValue();
//System.out.println(cellval);
    }
    @Test
    public void   getRowCount() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount= sheet.getLastRowNum();
        System.out.println("row count:"+rowCount);

    }

    @Test
    public void   getColCount() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheetAt(0);
        int colCount= sheet.getRow(1).getLastCellNum();//cols in row number
        System.out.println("col count:"+colCount);

    }
    @Test
    public void   getCellData() throws IOException {
//cell data gets based on row.col number
        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("Login");

       // row count
        int rowCount= sheet.getLastRowNum();
        System.out.println("row count:"+rowCount);
       // col count
        int colCount= sheet.getRow(1).getLastCellNum();
        System.out.println("col count:"+colCount);
        // celld data
        String s=sheet.getRow(2).getCell(0).getStringCellValue();//row num,col num-starts with 0
        System.out.println(s);

        int ss= (int) sheet.getRow(1).getCell(2).getNumericCellValue();//if cell val is numeric
        System.out.println(ss);


    }
    @Test
    public void   getSheetData() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("Login");
        // int rowCount= sheet.getPhysicalNumberOfRows();
        int rowCount= sheet.getLastRowNum();
        System.out.println("row count:"+rowCount);

for(int row=1;row<=rowCount;row++)
{
    int colCount= sheet.getRow(row).getLastCellNum();
    //System.out.println("col count:"+colCount);


    for(int col=0;col<=colCount-1;col++)
    {
        if(col==2) { // if col no is not euql to 2 then  ..it conains string values and use below method to get string values
            int n = (int) sheet.getRow(row).getCell(col).getNumericCellValue();
            System.out.println(n);
        }
        else {
            String ss = sheet.getRow(row).getCell(col).getStringCellValue();
            System.out.println(ss);
        }
}


}

    }


    @Test
    public void   launchApplication() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Training\\Selenium\\TestData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheet("Login");
        // int rowCount= sheet.getPhysicalNumberOfRows();
        int rowCount= sheet.getLastRowNum();
        System.out.println("row count:"+rowCount);

        int colCount= sheet.getRow(1).getLastCellNum();

        System.out.println("col count:"+colCount);


        String browserType=sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println(browserType);

        String url=sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println(url);


          if(browserType.equalsIgnoreCase("chrome")) {
              System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
              ChromeOptions options = new ChromeOptions();
              driver = new ChromeDriver(options);
              //driver.navigate().to("https://en-gb.facebook.com/");
              driver.navigate().to(url);
          }

        if(browserType.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "D:/Training/Selenium/drivers/msedgedriver.exe");
            EdgeOptions edgeOptions=new EdgeOptions();
            driver=new EdgeDriver(edgeOptions);
            driver.get(url);;}





    }

}