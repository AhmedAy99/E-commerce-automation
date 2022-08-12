package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage=new P03_homePage();
    @When("user hover on main category and select sub category")
    public void hoverOnCategory() throws InterruptedException {
        homePage.hoverCategory();
        Thread.sleep(500);

    }

    @Then("user is navigated to subcategory page")
    public void userIsNavigatedToSubcategoryPage() {
        String title=homePage.pageTitle.getText().toLowerCase().trim();
        Assert.assertTrue(title.contains(homePage.selectedSubCategoryText.toLowerCase().trim()));
    }
}
