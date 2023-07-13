package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {
    @FindBy(id = "name")
    WebElement fillName;

    @FindBy(id = "country")
    WebElement fillCountry;

    @FindBy(id = "city")
    WebElement fillCity;

    @FindBy(id = "card")
    WebElement fillCreditCard;

    @FindBy(id = "month")
    WebElement fillMonth;

    @FindBy(id = "year")
    WebElement fillYear;

    @FindBy(id = "totalm")
    WebElement totalPriceOrder;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
    WebElement buttonClose;

    @FindBy(xpath = "//button[text()=\"Purchase\"]")
    WebElement buttonPurchase;
    private WebDriver driver;
    private WebDriverWait wait;

    public PlaceOrderPage(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    private void fillAllFields(String name, String country, String city,
                              String creditCard, String month, String year){
        wait.until(ExpectedConditions.visibilityOf(fillName)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(fillCountry)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOf(fillCity)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOf(fillCreditCard)).sendKeys(creditCard);
        wait.until(ExpectedConditions.visibilityOf(fillMonth)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOf(fillYear)).sendKeys(year);
    }

    public void goToPurchase(String name, String country, String city,
                             String creditCard, String month, String year){
        fillAllFields(name, country, city, creditCard, month, year);
        wait.until(ExpectedConditions.visibilityOf(buttonPurchase)).click();
    }
}
