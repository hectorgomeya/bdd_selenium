package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SingInPage;
import utilities.TestContext;

public class SingSteps {
    SingInPage singPage;
    TestContext testContext;

    private WebDriverWait wait;

    public SingSteps(TestContext testContext){
        this.testContext = testContext;
        singPage = testContext.getPageObjectManager().getSingPage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @Then("Sing In \"(.*)\" and password \"(.*)\"$")
    public void login(String username, String password) throws InterruptedException {
        singPage.SingIn(username, password);

    }
}
