package steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.EnterprisePage;
import pageobjects.HomePage;
import pageobjects.Language_Learning;


import java.io.IOException;
import java.time.Duration;

public class StepDefinition {
    static WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor JS;
    HomePage hp;
    Language_Learning ll;
    EnterprisePage ep;



    @Given("I am on the Coursera homepage")
    public void navigateHome() {
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.coursera.org/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        hp = new HomePage(driver);
        ll = new Language_Learning(driver);
        ep = new EnterprisePage(driver);
    }

    @When("I search for {string}")
    public void searchCourse(String term) {
        hp.setCourseName(term);
    }

    @And("I filter for Level {string} and Language {string}")
    public void i_filter_for_level_and_language(String level, String lang) throws IOException {
        // Apply Filters (Beginner & English)
        hp.clickCheckBox();

    }

    @Then("I capture the first {int} course details")
    public void i_capture_the_first_course_details(Integer count) throws IOException {
        hp.getCourseDetails();
    }

    @When("I navigate to Language Learning section")
    public void i_navigate_to_language_learning_section() {
        hp.ClickOnLanguageLearning();

    }

    @Then("I list all languages and levels with their counts")
    public void i_list_all_languages_and_levels_with_their_counts() throws IOException {
        ll.ClickShowMore();
        ll.CountLanguages();
        ll.getLanguages();
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String menu) {
        ep.clickForEnterpriseLink();

    }

    @And("I fill the Ready to transform form with invalid email {string}")
    public void i_fill_the_form_with_invalid_email( String badEmail) {
        ep.setfName("Siva");
        ep.setlName("Prasad");
        ep.setEmail(badEmail);
        ep.setPhone("9988776655");

        ep.orgDropDown("College/University");
        ep.setInsType("University/4 Year College");
        ep.setJobRole("Student");
        ep.setCName("International");

        ep.setNeedMsg("Courses for myself");
        ep.setCountry("India");

        ep.setState("Andhra Pradesh");
        ep.sbmtButton();


    }

    @Then("I capture and display the validation error message")
    public void i_capture_and_display_the_validation_error_message(){

        ep.getMessage();

    }
    @And("I quit from browser")
    public void i_quit_from_browser(){
        driver.quit();
    }
}


