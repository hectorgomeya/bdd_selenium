package pageObjects;

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

public class CartPage{
    private WebDriver driver;
    private WebDriverWait wait;

    private Map<String, String> contextData;
    @FindBy(xpath = "//button[text()=\"Place Order\"]")
    WebElement placeOrder;
    

    public CartPage(WebDriver driver, WebDriverWait wait, Map<String, String> contextData){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
        this.contextData = contextData;
    }

    public String getPrice(String price){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()=\"" + price + "\"]"))).getText();
    }

    public String getProduct(String product){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()=\"" + product + "\"]"))).getText();
    }

    public void goToPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }
    
    
    public void deleteAllProducts() {
             boolean isVisible = true;
        while (isVisible) {
            List<WebElement> rows = driver.findElements(By.tagName("tr"));
            int size = rows.size() - 1;
            if (size == 1) {
                WebElement deleteproducto = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a"));
                wait.until(ExpectedConditions.elementToBeClickable(deleteproducto)).click();
                isVisible = false;

            } else {
                WebElement deleteproducto = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a"));
                wait.until(ExpectedConditions.elementToBeClickable(deleteproducto)).click();

            }

            }
        }
    }
//*[@id="tbodyid"]/tr/td[4]/a

        
        


