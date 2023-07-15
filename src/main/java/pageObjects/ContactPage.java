package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ContactPage {

    @FindBy(xpath = "//*[@id=\"recipient-email\"]")
    WebElement contactEmail;

    @FindBy(xpath = "//*[@id=\"recipient-name\"]")
    WebElement contactName;

    @FindBy(xpath = "//*[@id=\"message-text\"]")
    WebElement contactMessage;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")
    WebElement sendMessage;


    private WebDriver driver;
    private WebDriverWait wait;

    private Map<String, String> contextData;

    public ContactPage(WebDriver driver, WebDriverWait wait, Map<String, String> contextData){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

        this.contextData = contextData;
    }

    public void contactMessage(String contactName, String contactEmail, String message){
        wait.until(ExpectedConditions.visibilityOf(this.contactName)).sendKeys(contactName);
        wait.until(ExpectedConditions.visibilityOf(this.contactEmail)).sendKeys(contactEmail);
        wait.until(ExpectedConditions.visibilityOf(this.contactMessage)).sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(this.sendMessage)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();



    }


}
