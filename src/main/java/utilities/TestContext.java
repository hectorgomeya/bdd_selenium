package utilities;

import com.github.bogdanlivadariu.gifwebdriver.GifWebDriver;
import managers.ChromeManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TestContext {

    private final ChromeManager driverManager;
    private final PageObjectManager pageObjectManager;

  //  private final WebDriver driver2;

    public TestContext(){
        driverManager = new ChromeManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver(), driverManager.getWait());
     //   driverManager.sampleGifRecorder();
     //   driver2 = new GifWebDriver(new ChromeDriver());
    }

    //Devuelve el contecto de lo que hay en este thread en el driver
    public ChromeManager getDriverManager(){
        return driverManager;
    }

    //Devuelve el contecto de lo que hay en la pagina actual
    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    /**public void tomagif() {
        GifWebDriver gifDriver = (GifWebDriver) driver2;
        driver2.quit();
        File createdGif = gifDriver.getGifScreenshotWorker().createGif();
        String rootFolder = gifDriver.getGifScreenshotWorker().getRootDir();
        System.out.println(rootFolder);

    }
**/


}
