package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.HashMap;
import java.util.Map;

public class PageObjectManager {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private HomePage homePage;
    private LoginPage loginPage;

    private CartPage cartPage;

    private PlaceOrderPage placeOrderPage;
    private ValidateMessagePage validateMessagePage;
    private ProductPage productPage;

    private ContactPage contactPage;

    private SingInPage singPage;

    public Map<String, String> contextData;

    public PageObjectManager(WebDriver driver, WebDriverWait wait, Map<String, String> contextData){
        this.driver = driver;
        this.wait = wait;
        this.contextData = contextData;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver, wait) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver, wait) : loginPage;
    }

    public ProductPage getProductPage() {
        return (productPage == null) ? productPage = new ProductPage(driver, wait, contextData) : productPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver, wait, contextData) : cartPage;
    }

    public PlaceOrderPage getPlaceOrderPage() {
        return (placeOrderPage == null) ? placeOrderPage = new PlaceOrderPage(driver, wait) : placeOrderPage;
    }

    public ValidateMessagePage getValidateMessagePage() {
        return (validateMessagePage == null) ? validateMessagePage = new ValidateMessagePage(driver, wait) : validateMessagePage;
    }

    public SingInPage getSingPage() {
        return (singPage == null) ? singPage = new SingInPage(driver, wait, contextData) : singPage;
    }

    public ContactPage getContactPage() {
        return (contactPage == null) ? contactPage = new ContactPage(driver, wait, contextData) : contactPage;


    }
}
