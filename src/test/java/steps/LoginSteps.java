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
import utilities.TestContext;

public class LoginSteps {
    LoginPage loginPage;
    TestContext testContext;

    private WebDriverWait wait;

    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @Then("Insert user \"(.*)\" and password \"(.*)\" and \"(.*)\"$")
    public void login(String username, String password, String flag) throws InterruptedException {
        switch (flag.toLowerCase()){
            case "correcto":
                WebElement loginCheck = loginPage.login(username, password, flag);

                Assert.assertTrue(loginCheck.getText()
                                  .contains("asd")
                                  );
                break;
            case "incorrecto":
                loginPage.login(username, password, flag);
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                break;
        }

    }
}
