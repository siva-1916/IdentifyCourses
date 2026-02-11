package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterprisePage{

    WebDriver driver;
    public  EnterprisePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath="//a[text()='For Enterprise']")
    WebElement forEnterprise_link;
    @FindBy(id= "FirstName")
    WebElement firstname;
    @FindBy(id="LastName")
    WebElement lastname;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(xpath="//input[@id='Phone']")
    WebElement phone;
    @FindBy(xpath="//*[@name='rentalField9']")
    WebElement orgn;
    @FindBy(id="Institution_Type__c")
    WebElement inst_Type;
    @FindBy(id="Department")
    WebElement dep_name;
    @FindBy(id="Employee_Range__c")
    WebElement size;
    @FindBy(id="Self_Reported_Needs__c")
    WebElement need;
    @FindBy(id="Country")
    WebElement country;
    @FindBy(id="C4C_Job_Title__c")
    WebElement jobTitle;
    @FindBy(id="State")
    WebElement state;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submitbtn;
    @FindBy (id =  "ValidMsgEmail")
    WebElement errorMsg;


    public void clickForEnterpriseLink() {
        // forEnterprise_link.click();
        wait.until(ExpectedConditions.elementToBeClickable(forEnterprise_link)).click();
    }

    public void setfName(String name) {
        firstname.sendKeys(name);
    }

    public void setlName(String lname ) {

        lastname.sendKeys(lname);
    }

    public void setEmail(String Email) {
        email.sendKeys(Email);
    }

    public void setPhone(String phno) {
        phone.sendKeys(phno);
    }

    public void orgDropDown(String org) {
        Select select=new Select(orgn);
        select.selectByVisibleText(org);
    }

    public void setInsType(String itype) {
        Select select=new Select(inst_Type);
        select.selectByVisibleText(itype);
    }
    public void setJobRole(String JobRole) {
        Select select=new Select(jobTitle);
        select.selectByVisibleText(JobRole);
    }
    public void setCName(String Department) {
        Select select = new Select(dep_name);
        select.selectByVisibleText(Department);
    }
    public void setNeedMsg(String msg) {
        Select select=new Select(need);
        select.selectByVisibleText(msg);
    }
    public void setCountry(String cntry) {
        Select select=new Select(country);
        select.selectByVisibleText(cntry);
    }

    public void setState(String st) {
        Select select=new Select(state);
        select.selectByVisibleText(st);
    }

    public void sbmtButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitbtn)).click();
    }

    public void getMessage() {
        System.out.println("--------Error Message----------");
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        System.out.println(errorMsg.getText());
    }

}
