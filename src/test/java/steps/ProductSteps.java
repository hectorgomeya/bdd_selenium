package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.TestContext;

public class ProductSteps {
    ProductPage productPage;
    HomePage homePage;
    TestContext testContext;

    public static String price;

    public static String product;
    private WebDriverWait wait;

    public ProductSteps(TestContext testContext){
        this.testContext = testContext;
        productPage = testContext.getPageObjectManager().getProductPage();
        homePage = testContext.getPageObjectManager().getHomePage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @And("Get price and product")
    public void getPriceAndProduct(){
        productPage.getPrice();
        productPage.getProduct();
    }

    @And("Go to cart")
    public void goToCart(){
        productPage.goToCart();
        homePage.goToButtonCart();
        Assert.assertTrue(testContext.getDriverManager().getDriver().getCurrentUrl().contains("cart"));
    }
}
