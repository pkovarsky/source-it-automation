import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by antonreznikov on 1/14/17.
 */
public class BaseWebDriverTest {
    public WebDriver driver;
    public WebDriverWait wait;
    private long startTime;

    @BeforeMethod
    public void initDriver(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver");
        //Navigate to rozetka
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        startTime = Reporter.getCurrentTestResult().getStartMillis();
        wait = new WebDriverWait(driver, 15);
    }

//    @AfterMethod
//    public void destroyDriver(){
//        if(driver!=null) {
//            driver.quit();
//        }
//
//        //Reporter.log("Elapsed time: "+(Reporter.getCurrentTestResult().getEndMillis()-startTime/1000),true);
//    }
}
