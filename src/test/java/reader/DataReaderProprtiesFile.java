package reader;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReaderProprtiesFile {
    WebDriver driver = null;

    @Test
    public void   readDataFromPropetyFile() throws IOException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\Training\\Selenium\\config.properties"));
        String url = prop.getProperty("url");
        String uid = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        System.out.println(url);
        System.out.println(uid);
        System.out.println(pwd);


    }

    @Test
    public void   writeDataFromPropetyFile() throws IOException {
 // during run time we can store temp...but physically it wont store
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\Training\\Selenium\\config.properties"));
       prop.setProperty("testingType","Automation");
        String outData = prop.getProperty("testingType");
        System.out.println(outData);


    }

}