package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class D08_WishlistStepDef {
    P03_homePage homePage=new P03_homePage();

    @When("user add item to wishlist")
    public void addItemToWishList(){
        homePage.addToWishList();
    }

    @Then("wishlist success message is displayed")
    public void wishlistSuccessMessageIsDisplayed() {
        homePage.wishListSuccessMsg();
    }

    @And("user click on wishlist page")
    public void userClickOnWishlistPage() throws InterruptedException {
        homePage.barNTFClose.click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.wishListBtn));
        Thread.sleep(1000);
        homePage.wishListBtn.click();
    }

    @Then("item is found on wishlist page")
    public void itemIsFoundOnWishlistPage() {
        String actualResult= homePage.wishListQtyEl.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(actualResult)>0);
    }
}
