package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//button[text()=\"Log in\"]")
    WebElement buttonLogIn;

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement login(String username, String password, String flag){
        wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(this.buttonLogIn)).click();

        if(flag.toLowerCase().equals("correcto"))
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        return null;
    }
}
