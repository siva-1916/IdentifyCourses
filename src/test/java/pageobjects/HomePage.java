package pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage  {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
    WebElement search_input;

    @FindBy(xpath = "//div[.='Language']")
    WebElement search_Language;

    @FindBy(xpath = "//span[text()='English']")
    WebElement engcheck_box;

    @FindBy(xpath = "//div[.='Level']")
    WebElement search_Level;

    @FindBy(xpath = "//span[.='View']")
    WebElement Click_View;

    @FindBy(xpath = "//span[text()='Beginner']")
    WebElement beginner_checkbox;

    @FindBy(xpath = "//h3[contains(@class, 'cds-CommonCard-title')]")
    List<WebElement> courses_list;

    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']/p")
    List<WebElement> durations_list;

    @FindBy(xpath = "//span[@class='css-4s48ix']")
    List<WebElement> ratings_list;

    @FindBy(xpath = "//div[@class=\"css-gmhln5\"]/div[8]")
    WebElement Language_Learning;



    public void setCourseName(String coursename) {

        search_input.sendKeys(coursename + Keys.ENTER);
    }

    public void clickCheckBox() {

        wait.until(ExpectedConditions.elementToBeClickable(search_Language)).click();
        wait.until(ExpectedConditions.elementToBeClickable(engcheck_box)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Click_View)).click();
        wait.until(ExpectedConditions.elementToBeClickable(search_Level)).click();
        wait.until(ExpectedConditions.elementToBeClickable(beginner_checkbox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Click_View)).click();
    }

    public void getCourseDetails() throws IOException {
        wait.until(ExpectedConditions.visibilityOfAllElements(courses_list));
        wait.until(ExpectedConditions.visibilityOfAllElements(ratings_list));
        wait.until(ExpectedConditions.visibilityOfAllElements(durations_list));

        for (int i = 0; i < 2; i++) {
            System.out.println("Course Name: " + courses_list.get(i).getText());
            System.out.println("Rating: " + ratings_list.get(i).getText());
            System.out.println("Duration: " + durations_list.get(i).getText());


        }

    }

    public void ClickOnLanguageLearning(){
         wait.until(ExpectedConditions.elementToBeClickable(Language_Learning)).click();

    }

}
