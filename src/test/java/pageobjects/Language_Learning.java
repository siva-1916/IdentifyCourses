package pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Language_Learning  {
    WebDriver driver;

    public Language_Learning(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    JavascriptExecutor js;



    @FindBy(xpath = "//div[@id=\"search-page-filters\"]/div/div/div/div/div/div/div/div/div[2]/div[2]/button")
    WebElement lang_ShowMore;
    @FindBy(xpath = "//div[@data-testid='search-filter-group-Language']//label")
    List<WebElement> languages;

    public void ClickShowMore() {
        js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.elementToBeClickable(lang_ShowMore));
        js.executeScript("arguments[0].scrollIntoView({ block: 'center'});", lang_ShowMore);
        lang_ShowMore.click();

    }

    public void CountLanguages() {
        wait.until(ExpectedConditions.visibilityOfAllElements(languages));
        System.out.println("===========================================");
        System.out.println("TOTAL LANGUAGES FOUND: " + languages.size());
    }

    public void getLanguages() throws IOException {
        System.out.println("===========================================");
        for (int i = 0; i < languages.size(); i++) {
            String name = languages.get(i).getText();
            // Cleaning up potential empty strings or count numbers (e.g., "English (1200)")
            if (!name.isEmpty()) {
                System.out.println((i + 1) + ". " + name);
            }
        }
    }


}
