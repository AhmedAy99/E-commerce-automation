package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_followUsStepDef {

    P03_homePage homePage=new P03_homePage();
    
    @When("user choose {string} icon")
    public void userChooseIcon(String arg0){
        homePage.chosenIcon(arg0);
    }

    @Then("user is navigated to {string} new tab")
    public void userIsNavigatedToNewTab(String arg0) throws InterruptedException {
        homePage.checkNewTabUrl(arg0);
    }
}
