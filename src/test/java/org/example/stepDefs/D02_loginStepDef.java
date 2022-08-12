package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login login=new P02_login();
    @Given("user go to login page")
    public void navigateToLogin(){
        login.loginBtn.click();
    }
    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1) {
        login.emailEl.sendKeys(arg0);
        login.passwordEl.sendKeys(arg1);
    }
    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert=new SoftAssert();
        //assertion 1
        softAssert.assertEquals( Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        //assertion 2
        softAssert.assertTrue(login.myAccEl.isDisplayed());
        //assert all
        softAssert.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert softAssert=new SoftAssert();
        //assertion 1
        softAssert.assertTrue( login.errorMsgEl.getText().contains("Login was unsuccessful."));
        //assertion 2
        softAssert.assertEquals( Color.fromString(login.errorMsgEl.getCssValue("color")).asHex(),"#e4434b");
        //assert all
        softAssert.assertAll();
    }
}
