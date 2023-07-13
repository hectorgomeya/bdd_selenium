package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.PlaceOrderPage;
import utilities.TestContext;

public class PlaceOrderSteps {
    PlaceOrderPage placeOrderPage;
    TestContext testContext;

    private WebDriverWait wait;

    public PlaceOrderSteps(TestContext testContext){
        this.testContext = testContext;
        placeOrderPage = testContext.getPageObjectManager().getPlaceOrderPage();
        this.wait = testContext.getDriverManager().getWait();
    }

    @Then("Fill name \"(.*)\", country \"(.*)\", city \"(.*)\", credit card \"(.*)\", month \"(.*)\" and year \"(.*)\" and go to purchase$")
    public void fillAndGo(String name, String country, String city, String creditCard, String month, String year){
        placeOrderPage.goToPurchase(name, country, city, creditCard, month, year);
    }
}
