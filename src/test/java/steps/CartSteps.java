package steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.TestContext;

import java.util.HashMap;
import java.util.Map;

public class CartSteps {
    CartPage cartPage;
    TestContext testContext;

    public Map<String, String> contextData;
    private WebDriverWait wait;

    public CartSteps(TestContext testContext){
        this.testContext = testContext;
        cartPage = testContext.getPageObjectManager().getCartPage();
        this.wait = testContext.getDriverManager().getWait();
        this.contextData = testContext.getDriverManager().getMyMap();
    }

    @And("validate order with product \"(.*)\" and price \"(.*)\"$")
    public void validatePriceAndProduct(String product, String price){
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()=\"" + product + "\"]")))
                .getText(), contextData.get("product"));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()=\"" + price + "\"]")))
                        .getText(), contextData.get("price"));
    }

    @And("go to place order")
    public void clickButtonPlaceOrder(){
        cartPage.goToPlaceOrder();
    }

    @And("delete all products")
    public void deleteAllProducts() {
        cartPage.deleteAllProducts();

    }

}
