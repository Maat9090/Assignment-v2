package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
;import java.time.Duration;
import java.util.Random;


public class MyStepdefsRegistration {
    WebDriver  driver = new ChromeDriver();
    //**********************************************

    private String randomEmail;

    public String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        // Generera slumpmässiga tecken för e-postens användarnamn
        for (int i = 0; i < 8; i++) {
            email.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        // Lägg till en slumpmässig siffra
        email.append(random.nextInt(100));

        // Lägg till domännamnet
        email.append("@gmail.se");

        return email.toString();
    }
    //************************************************

    @Given("I am on the {string} page")
    public void iAmOnThePage(String arg0) {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount ");
        driver.manage().window().maximize();
    }

    @When("I enter the date of birth {string} with the correct format")
    public void iEnterTheDateOfBirthWithTheCorrectFormat(String dateOfBirth) {
        WebElement dateOfBirthElement = driver.findElement(By.id("dp"));
        dateOfBirthElement.sendKeys("16/12/2000");
        WebElement bodyElement = driver.findElement(By.className("bg-met"));
        bodyElement.click();
    }

    @And("I enter the first name{string}")
    public void iEnterTheFirstName(String arg0) {
        WebElement fName = driver.findElement(By.id("member_firstname"));
        fName.sendKeys("Peter");
    }

    @And("I enter the last name{string}")
    public void iEnterTheLastName(String arg0) {
        WebElement lName = driver.findElement(By.id("member_lastname"));
        lName.sendKeys("Karlson");
    }

    @And("I enter the email address{string}")
    public void iEnterTheEmailAddress(String arg0) {
            WebElement emailAddress = driver.findElement(By.id("member_emailaddress"));
            // Generera slumpmässig e-post och spara den i klassvariabeln
            randomEmail = generateRandomEmail();
            // Skicka in e-postadressen
            emailAddress.sendKeys(randomEmail);
            System.out.println("Random Email Generated: " + randomEmail);
    }

    @And("I verify the email address{string}")
    public void iVerifyTheEmailAddress(String arg0) {
        WebElement verEmailAddress = driver.findElement(By.id("member_confirmemailaddress"));
        // Använd den tidigare genererade e-postadressen
        verEmailAddress.sendKeys(randomEmail);
        System.out.println("Email Verified: " + randomEmail);
    }

    @And("I choose  and enter a password{string}")
    public void iChooseAndEnterAPassword(String arg0) {
        WebElement passWord = driver.findElement(By.id("signupunlicenced_password"));
        passWord.sendKeys("Password123");
    }

    @And("I retype the password{string}")
    public void iRetypeThePassword(String arg0) {
        WebElement retyePassWord = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        retyePassWord.sendKeys("Password123");
    }

    @And("I select an {string} that describes my role in basketball")
    public void iSelectAnThatDescribesMyRoleInBasketball(String options) {
        WebElement option = driver.findElement(By.xpath("//*[@id='signup_form']/div[10]/div/div/div[4]/div/label"));
        option.click();
   }

    @And("I select {string}")
    public void iSelect(String arg0) throws InterruptedException {

        WebElement selection  = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label > span.box"));
        Thread.sleep(1000);
        selection.click();
    }
    @And("I select responsibility term")
    public void iSelectResponsibilityTerm() throws InterruptedException {

        Thread.sleep(1000);
        WebElement selection  = driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box"));
        Thread.sleep(1000);
        selection.click();
    }

    @And("I select communicationPreferencesFromBasketballEngland")
    public void iSelectCommunicationPreferencesFromBasketballEngland() throws InterruptedException {
        WebElement selection = driver.findElement(By.xpath(" //*[@id=\"signup_form\"]/div[11]/div/div[4]/label/span[3]"));
        Thread.sleep(1000);
        selection.click();
    }

    @And("I select communicationPreferencesFromPartnersOfBasketballEngland")
    public void iSelectCommunicationPreferencesFromPartnersOfBasketballEngland() throws InterruptedException {
        WebElement selection  = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(5) > label > span.box"));
        Thread.sleep(1000);
        selection.click();
    }
    @And("I agree to the codeOfEthicsAndConduct")
    public void iAgreeToTheCodeOfEthicsAndConduct() throws InterruptedException {
        WebElement selection = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3] "));
        Thread.sleep(1000);
        selection.click();
    }


    @And("I click the confirm and Join button")
    public void iClickTheConfirmAndJoinButton() throws InterruptedException {
        WebElement button  = driver.findElement(By.cssSelector("#signup_form > div.form-actions.noborder > input"));
        Thread.sleep(1000);
        button.click();
    }

    @Then("an account should be created successfully")
    public void anAccountShouldBeCreatedSuccessfully() {

        WebElement element = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2"));
        String actualText = element.getText();
        String expectedText = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        Assert.assertEquals("The text is incorrect", expectedText, actualText);


    }

}
