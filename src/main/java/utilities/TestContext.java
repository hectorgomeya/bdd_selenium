package utilities;

import managers.ChromeManager;
import managers.PageObjectManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final ChromeManager driverManager;
    private final PageObjectManager pageObjectManager;

    private Map<String, String> myMap;

    public TestContext(){
        driverManager = new ChromeManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver(), driverManager.getWait(), driverManager.getMyMap());
        myMap = new HashMap<>();
    }

    //Devuelve el contecto de lo que hay en este thread en el driver
    public ChromeManager getDriverManager(){
        return driverManager;
    }

    //Devuelve el contecto de lo que hay en la pagina actual
    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

}
