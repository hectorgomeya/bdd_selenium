package utilities;

import managers.ChromeManager;
import managers.PageObjectManager;

public class TestContext {

    private final ChromeManager driverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext(){
        driverManager = new ChromeManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver(), driverManager.getWait());
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
