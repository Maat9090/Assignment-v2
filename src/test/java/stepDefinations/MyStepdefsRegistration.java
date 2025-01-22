package stepDefinations;

import io.cucumber.java.After;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
;import java.time.Duration;
import java.util.Random;


public class MyStepdefsRegistration {
//    WebDriver  driver = new ChromeDriver();
  //  WebDriver driver = new EdgeDriver();
WebDriver  driver;
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
    @Given("I am using {string} as browser")
    public void iAmUsingAsBrowser(String browser) {
        // driver = new ChromeDriver();
//        driver = new EdgeDriver();


        if(browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge")){
            driver = new EdgeDriver();
        }
        else{
            driver = new ChromeDriver();
          }

    }

     @Given("I am on the Create an Account page")
    public void iAmOnTheCreateAnAccountPage() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount ");
        driver.manage().window().maximize();
    }

    @When("I enter the date of birth dateOfBirth with the correct format")
    public void iEnterTheDateOfBirthDateOfBirthWithTheCorrectFormat() {
        WebElement dateOfBirthElement = driver.findElement(By.id("dp"));
        dateOfBirthElement.sendKeys("16/12/2000");
        WebElement bodyElement = driver.findElement(By.className("bg-met"));
        bodyElement.click();
    }
    @And("I enter the first name first Name")
    public void iEnterTheFirstNameFirstName() {
        WebElement fName = driver.findElement(By.id("member_firstname"));
        fName.sendKeys("Peter");
    }

    @And("I enter the last name last Name")
    public void iEnterTheLastNameLastName() {
        WebElement lName = driver.findElement(By.id("member_lastname"));
        lName.sendKeys("Karlson");
    }

       @And("I enter the email address")
    public void iEnterTheEmailAddress() {
        WebElement emailAddress = driver.findElement(By.id("member_emailaddress"));
        // Generera slumpmässig e-post och spara den i klassvariabeln
        randomEmail = generateRandomEmail();
        // Skicka in e-postadressen
        emailAddress.sendKeys(randomEmail);
     //   System.out.println("Random Email Generated: " + randomEmail);
    }

    @And("I verify the email address")
    public void iVerifyTheEmailAddress() {
        WebElement verEmailAddress = driver.findElement(By.id("member_confirmemailaddress"));
        // Använder tidigare genererade e-postadressen
        verEmailAddress.sendKeys(randomEmail);
      //  System.out.println("Email Verified: " + randomEmail);
    }

    @And("I choose  and enter a password")
    public void iChooseAndEnterAPassword() {
        WebElement passWord = driver.findElement(By.id("signupunlicenced_password"));
        passWord.sendKeys("Password123");
    }

        @And("I retype the password")
    public void iRetypeThePassword() {
        WebElement retyePassWord = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        retyePassWord.sendKeys("Password123");
    }

    @And("I select an Fan that describes my role in basketball")
    public void iSelectAnFanThatDescribesMyRoleInBasketball() {
        WebElement option = driver.findElement(By.xpath("//*[@id='signup_form']/div[10]/div/div/div[4]/div/label"));
        option.click();
    }

    @And("I select Terms and Conditions")
    public void iSelectTermsAndConditions() throws InterruptedException {
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

    //2****************************************************************************
    @And("I will leave the last name field blank")
    public void iWillLeaveTheLastNameFieldBlank() {
        WebElement lName = driver.findElement(By.id("member_lastname"));
        lName.clear();
    }

    @Then("A warning message should be displayed on the last name field")
    public void aWarningMessageShouldBeDisplayed() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span/span"));
        String actualText = text.getText();
        String expectedText= "Last Name is required";
        Assert.assertEquals("The text is incorrect", expectedText, actualText);
    }
    //3****************************************************************************
    @And("I enter a password that does not match")
    public void iEnterAPasswordThatDoesNotMatch() {
        WebElement retyePassWord = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        retyePassWord.sendKeys("Password000");
    }

    @Then("A warning message should be displayed on the password field")
    public void aWarningMessageShouldBeDisplayedOnThePasswordField() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span"));
        String actualText = text.getText();
        String expectedText= "Password did not match";
        Assert.assertEquals("The text is incorrect", expectedText, actualText);
    }
    //4****************************************************************************
    @And("I do not accept the terms and conditions")
    public void iDoNotAcceptTheTermsAndConditions() {
        WebElement selection  = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label > span.box"));

    }

    @Then("A warning message should be displayed on the conditions are not accepted field")
    public void aWarningMessageShouldBeDisplayedOnTheConditionsAreNotAcceptedField() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span"));
        String actualText = text.getText();
        String expectedText= "You must confirm that you have read and accepted our Terms and Conditions";
        Assert.assertEquals("The text is incorrect", expectedText, actualText);
    }
//*****************************Scenario Outline*****************************************
    @When("I enter the date of birth {string} with the correct format")
    public void iEnterTheDateOfBirthWithTheCorrectFormat(String birth) {
        WebElement dateOfBirthElement = driver.findElement(By.id("dp"));
        dateOfBirthElement.sendKeys(birth);
        WebElement bodyElement = driver.findElement(By.className("bg-met"));
        bodyElement.click();
        
    }

    @And("I enter the first name{string}")
    public void iEnterTheFirstName(String fNam) {
        WebElement fName = driver.findElement(By.id("member_firstname"));
        fName.sendKeys(fNam);
    }

    @And("I enter the last name{string}")
    public void iEnterTheLastName(String lNam) {
        WebElement lName = driver.findElement(By.id("member_lastname"));
        lName.sendKeys(lNam);
    }

    @And("I enter the email address{string}")
    public void iEnterTheEmailAddress(String arg0) {
        WebElement emailAddress = driver.findElement(By.id("member_emailaddress"));
        // Generera slumpmässig e-post och spara den i klassvariabeln
        randomEmail = generateRandomEmail();
        // Skicka in e-postadressen
        emailAddress.sendKeys(randomEmail);
        //   System.out.println("Random Email Generated: " + randomEmail);

    }

    @And("I choose and enter a {string}")
    public void iChooseAndEnterA(String password) {

        WebElement passWord = driver.findElement(By.id("signupunlicenced_password"));
        passWord.sendKeys(password);
    }
    @And("I retype the {string}")
    public void iRetypeThe(String password) {
        WebElement passWord = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        passWord.sendKeys(password);
    }


    @And("I select an {string} that describes my role in basketball")
    public void iSelectAnThatDescribesMyRoleInBasketball(String role) {
        WebElement options;

        if (role.equalsIgnoreCase("Basketball media")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[1]/div/label/span[3]"));
            options.click();
        } else if (role.equalsIgnoreCase("Fan")) {
            options = driver.findElement(By.xpath("//*[@id='signup_form']/div[10]/div/div/div[5]/div/label"));
            options.click();
        } else if (role.equalsIgnoreCase("Player's relative/guardian")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[7]/div/label/span[3]"));
            options.click();
        } else if (role.equalsIgnoreCase("Club/League/Area/Region role")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[2]/div/label/span[3]"));
            options.click();
        }else if (role.equalsIgnoreCase("Official")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[5]/div/label/span[3]"));
            options.click();
        }else if (role.equalsIgnoreCase("Sports science role")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[8]/div/label/span[3]"));
            options.click();
        }else if (role.equalsIgnoreCase("Coach")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[3]/div/label/span[3]"));
            options.click();
        }else if (role.equalsIgnoreCase("Player")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[6]/div/label/span[3]"));
            options.click();
        }else if (role.equalsIgnoreCase("Welfare officer")) {
            options = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[10]/div/div/div[9]/div/label/span[3]"));
            options.click();
        }
        else {
            System.out.println("Invalid role: " + role);
        }
        
    }


}

