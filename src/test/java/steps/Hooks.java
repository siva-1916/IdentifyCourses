package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

public class Hooks {

    WebDriver driver;

    // The @After hook runs automatically after every scenario
    @After
    public void tearDown(Scenario scenario) {
        // Validation: Only take screenshot if the test fails
        if (scenario.isFailed()) {
            // Logic to capture screenshot from Selenium
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Attach the screenshot directly to the Allure Report
            Allure.addAttachment("Failed_Scenario_Screenshot", new ByteArrayInputStream(screenshot));
        }

        // Clean up: Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}