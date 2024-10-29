package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {

    public  static WebDriver driver;
    public static File getJSONSchema(String JSONFile){
        return  new File("src/test/java/helper/JSONSchema/"+JSONFile);
    }

    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
//        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // driver = WebDriverManager.chromedriver().create();
    }

    public static void quitDriver(){
        driver.quit();
    }
}
