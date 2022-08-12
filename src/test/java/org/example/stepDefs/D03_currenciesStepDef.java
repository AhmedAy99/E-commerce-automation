package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {

    P03_homePage homePage=new P03_homePage();
    @Given("user navigated to homePage")
    public void navigateToHome(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user change currency")
    public void userChangeCurrency() throws InterruptedException {
        homePage.changeCurrency();
        Thread.sleep(1000);
    }

    @Then("currency is changed for all product")
    public void currencyIsChangedForAllProduct() {
        homePage.checkPrices();
    }
}
