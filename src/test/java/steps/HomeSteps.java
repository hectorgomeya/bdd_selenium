package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import utilities.TestContext;

public class HomeSteps {
    HomePage homePage;
    TestContext testContext;

    private WebDriverWait wait;

    public HomeSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = testContext.getPageObjectManager().getHomePage();
        wait = testContext.getDriverManager().getWait();
    }

    @Given("Login form in login page")
    public void goToLoginPage() {
        homePage.clickInLoginButton();
    }

    @Then("Find product \"(.*)\" and category \"(.*)\"$")
    public void findProduct(String product, String category){
        String currentUrl = homePage.findProduct(product, category);
        Assert.assertTrue(currentUrl.contains("prod"));
    }

    @Given("Go to Sing In page")
    public void gotoSingIn() {
        homePage.goToLoginSingIng();
    }


    @Given("Go to contact page")
    public void gotoContactPage() {
        homePage.goContact();

            }

}
