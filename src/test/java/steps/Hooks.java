package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utilities.TestContext;
import utilities.ScreenRecorderUtil;

import static utilities.ScreenRecorderUtil.*;

public class Hooks {
    TestContext testContext;
    WebDriver webDriver;


    public Hooks(TestContext context)
    {
        testContext = context;
    }

    @Before
    public void setUp() throws Exception {
        startRecord("test");
        webDriver = testContext.getDriverManager().getDriver();
        webDriver.get("https://www.demoblaze.com/index.html");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if(scenario.isFailed()){
            try {
                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        try {
            stopRecord();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        testContext.getDriverManager().tearDown();

    }
}
