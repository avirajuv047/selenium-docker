package tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;



public class BaseTest {

    protected WebDriver driver;
    private Properties prop;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws IOException {

        //BROWSER=>chrome/firefox
//HUB_HOST=>localhost/10.0.1.3/hostname

        //Stringhost;
        MutableCapabilities dc;

//        Properties properties=new Properties();
//        String file="data.properties";
//        InputStream inputstream=getClass().getClassLoader().getResourceAsStream(file);
//        properties.load(inputstream);
        String browserName=System.getProperty("BROWSER");
        String host=System.getProperty("HUB_HOST");


        if(browserName!=null&&
                browserName.equalsIgnoreCase("firefox")){
            System.out.println("firefoxloading...");
            dc=new FirefoxOptions();
        }else{
            dc=new ChromeOptions();
            System.out.println("chromeloading...");

        }


        String testName=ctx.getCurrentXmlTest().getName();

        String completeUrl="http://"+host+":4444/wd/hub";
        System.out.println(host);
        dc.setCapability("test",testName);
        this.driver=new RemoteWebDriver(new URL(completeUrl),dc);
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}


