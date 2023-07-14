package pageObjects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestContext;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingInPage{
    private WebDriver driver;
    private WebDriverWait wait;

    private Map<String, String> contextData;
    @FindBy(id = "sign-username")
    WebElement username2;

    @FindBy(id = "sign-password")
    WebElement password2;

    @FindBy (xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    WebElement SingButton;




    public SingInPage(WebDriver driver, WebDriverWait wait, Map<String, String> contextData){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
        this.contextData = contextData;
    }

    public void SingIn(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(username2)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password2)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(SingButton)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

           }

}
//*[@id="tbodyid"]/tr/td[4]/a





