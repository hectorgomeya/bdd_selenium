package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath = "//a[text()=\"Phones\"]")
    WebElement categoryPhones;

    @FindBy(xpath = "//a[text()=\"Monitors\"]")
    WebElement categoryMonitors;

    @FindBy(xpath = "//a[text()=\"Laptops\"]")
    WebElement categoryLaptops;

    @FindBy(id = "login2")
    WebElement loginButton;

    @FindBy(id = "cartur")
    WebElement cartButton;

    @FindBy (xpath = "//*[@id=\"signin2\"]")
    WebElement singButton;

    @FindBy (xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    WebElement contactButton;


    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
        this.driver = driver;
        this.wait = wait;
    }

    public void clickInLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    private void selectCategory(String category){
        switch (category.toLowerCase()){
            case "monitors":
                wait.until(ExpectedConditions.visibilityOf(categoryMonitors)).click();
                break;
            case "phones":
                wait.until(ExpectedConditions.visibilityOf(categoryPhones)).click();
                break;
            case "laptops":
                wait.until(ExpectedConditions.visibilityOf(categoryLaptops)).click();
                break;
        }
    }
    public String findProduct(String product, String category){
        selectCategory(category);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), \""+ product +"\")]"))).click();

        return driver.getCurrentUrl();
    }

    public void goToButtonCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    public void goToLoginSingIng() { wait.until(ExpectedConditions.elementToBeClickable(singButton)).click();}

    public void goContact() { wait.until(ExpectedConditions.elementToBeClickable(contactButton)).click();}



}
