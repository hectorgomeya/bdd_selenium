package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateMessagePage {
    @FindBy(xpath = "//p[@class=\"lead text-muted \"]")
    WebElement tableMessage;
    private WebDriver driver;
    private WebDriverWait wait;

    public ValidateMessagePage(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public String[] validateAllFields(){
        return wait.until(ExpectedConditions.visibilityOf(tableMessage)).getText().split("\n");
    }

}
