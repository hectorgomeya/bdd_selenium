package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class PageObjectManager {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private HomePage homePage;
    private LoginPage loginPage;
    public PageObjectManager(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver, wait) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver, wait) : loginPage;
    }
}
