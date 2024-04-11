package reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Z_PropertiesFileReader {

    @Test

        public void readProperties() throws IOException {
       // FileReader fileReader=new FileReader("D:/TestingTry/Selenium/config.properties");
       FileInputStream fileInputStream=new FileInputStream("D:/TestingTry/Selenium/config.properties");
            Properties properteis=new Properties();
            properteis.load(fileInputStream);
            String brwBrowser=properteis.getProperty("url");
        System.out.println(brwBrowser);


        }
    }

