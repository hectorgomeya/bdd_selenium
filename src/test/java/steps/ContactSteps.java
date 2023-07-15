package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SingInPage;
import utilities.TestContext;

public class ContactSteps {
    ContactPage contactPage;
    TestContext testContext;

    private WebDriverWait wait;

    public ContactSteps(TestContext testContext){
        this.testContext = testContext;
        contactPage = testContext.getPageObjectManager().getContactPage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @Then("Contact:\"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void contactMessage(String name, String email,String message) throws InterruptedException {
        contactPage.contactMessage(name, email,message);

    }
}
