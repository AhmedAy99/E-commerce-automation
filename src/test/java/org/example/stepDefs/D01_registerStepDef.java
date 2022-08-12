package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register=new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerBtn.click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.maleGenderBtn.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstNameEl.sendKeys(arg0);
        register.lastNameEl.sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        register.fillBirthDate();
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.emailEl.sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.PasswordEl.sendKeys(arg0);
        register.confirmPasswordEl.sendKeys(arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() throws InterruptedException {
        register.registerButtonEl.click();
        Thread.sleep(500);
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert softAssert=new SoftAssert();
        //first assertion
        String expectedResult="Your registration completed";
        String actualResult =Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        softAssert.assertTrue(expectedResult.contains(actualResult));
        //second assertion
        actualResult =Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]")).getCssValue("color");
        expectedResult="rgba(76, 177, 124, 1)";
        softAssert.assertEquals(actualResult,expectedResult);
        //assert all
        softAssert.assertAll();
    }
}
