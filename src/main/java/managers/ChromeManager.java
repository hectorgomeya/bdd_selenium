package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.HashMap;
import java.util.Map;

public class ChromeManager {

    private WebDriver driver;
    private WebDriverWait wait;
    public Map<String, String> myMap = new HashMap<>();


    private WebDriver setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

        return driver;
    }

    //Si no hay driver lo crea
    public WebDriver getDriver(){
        if (driver == null)
            driver = setUp();
        return driver;
    }

    //Si no hay wait lo crea
    public WebDriverWait getWait(){
        if (wait == null)
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }
    public Map<String, String> getMyMap(){
        return myMap;
    }
    public void tearDown(){
        driver.quit();
    }
}
