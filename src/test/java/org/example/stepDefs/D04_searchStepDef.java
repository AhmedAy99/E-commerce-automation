package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class D04_searchStepDef {

    P03_homePage homePage=new P03_homePage();
    @When("user search for {string}")
    public void userSearchFor(String arg0) throws InterruptedException {
        homePage.searchEl.sendKeys(arg0);
        homePage.searchEl.sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }
    @Then("user is navigated to search page")
    public void navigatedToSearchPage(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

    @And("search show relevant {string}")
    public void searchShowRelevantItems(String arg0) {
        homePage.checkItems(arg0);
    }

    @And("user clicked on the product")
    public void userClickedOnTheProduct() {
        homePage.productDetails.click();
    }

    @Then("user find product with exact {string}")
    public void userFindProductWithExactSku(String arg0) {
        String expectedResult=arg0;
        String actualResult=homePage.skuEl.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
