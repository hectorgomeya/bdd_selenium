package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ValidateMessagePage;
import utilities.TestContext;

public class ValidateMessageSteps {
    ValidateMessagePage validateMessagePage;
    TestContext testContext;

    private WebDriverWait wait;

    public ValidateMessageSteps(TestContext testContext){
        this.testContext = testContext;
        validateMessagePage = testContext.getPageObjectManager().getValidateMessagePage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @And("Validate message page with name \"(.*)\" and card number \"(.*)\"$")
    public void validateMessage(String name, String cardNumber){
        String[] validateFields = validateMessagePage.validateAllFields();

        Assert.assertTrue(validateFields[0].contains("Id"));
        Assert.assertTrue(validateFields[1].contains("Amount"));
        Assert.assertTrue(validateFields[2].contains("Card Number: " + cardNumber));
        Assert.assertTrue(validateFields[3].contains("Name: " + name));
        Assert.assertTrue(validateFields[4].contains("Date: "));

    }
}
