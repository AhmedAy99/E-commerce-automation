package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    P03_homePage homePage=new P03_homePage();

    @When("user choose slider {string}")
    public void userChooseSlider(String arg0) {
        homePage.selectSlider(arg0);
    }

    @Then("user is navigated to {string}")
    public void userIsNavigatedTo(String arg0) {
        String expectedResult=arg0;
        String actualResult=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(expectedResult,actualResult);
    }
}
