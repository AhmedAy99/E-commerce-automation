package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_homePage {

    public P03_homePage(){
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(id = "customerCurrency")
    WebElement currencyEl;

    @FindBy(className = "search-box-text")
    public WebElement searchEl;

    //@FindBy(className = "product-title")
    //public WebElement productEl;

    @FindBy(xpath = "//img[@title]")
    public WebElement productDetails;

    @FindBy(className = "sku")
    public WebElement skuEl;

    @FindBy(className = "page-title")
    public WebElement pageTitle;
    public String selectedSubCategoryText;

    @FindBy(id = "nivo-slider")
    public WebElement nivoSlider;
    @FindBy(className = "content")
    public WebElement barNotification;
    @FindBy(className = "bar-notification")
    public WebElement barNotificationEl;
    @FindBy(className = "close")
    public WebElement barNTFClose;
    @FindBy(className = "ico-wishlist")
    public WebElement wishListBtn;

    @FindBy(className = "qty-input")
    public WebElement wishListQtyEl;

    public void changeCurrency(){
        Select dropdown = new Select(currencyEl);
        dropdown.selectByVisibleText("Euro");
    }
    public void checkPrices() {
        String expectedResult = "€";
        String actualResult;
        List<WebElement> pricesList = Hooks.driver.findElements(By.className("prices"));
        for (int i = 0; i < pricesList.size(); i++) {
            actualResult = pricesList.get(i).getText();
            Assert.assertTrue(actualResult.contains(expectedResult));
        }
    }
    public void checkItems(String arg0) {
            String expectedResult = arg0;
            String actualResult;
            List<WebElement> itemsList = Hooks.driver.findElements(By.className("product-title"));
            for (int i = 0; i < itemsList.size(); i++) {
                actualResult = itemsList.get(1).getText();
                Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult));
            }
        }
    public void hoverCategory() throws InterruptedException {

        Actions actions=new Actions(Hooks.driver);
        List<WebElement> mainLinks = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
        int min = 0;
        int max = 2;
        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        Thread.sleep(1000);
        selectedCategory = selectedCategory+1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li";
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
        Thread.sleep(1000);
        int subCategoryCount = subCategoryLinks.size();
        max=subCategoryCount-1;
        int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
        subCategoryLinks.get(selectedSubCategory).click();
    }

    public void selectSlider(String arg0){
        List<WebElement> slider = Hooks.driver.findElements(By.className("nivo-imageLink"));
        slider.get(Integer.parseInt(arg0)-1).click();
        Hooks.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        }
    public void chosenIcon(String arg0){
        Hooks.driver.findElement(By.className(arg0)).click();
    }

    public void checkNewTabUrl(String arg0) throws InterruptedException {
        ArrayList<String>  tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        if(tabs.size()>1){ Hooks.driver.switchTo().window(tabs.get(1)); }
        Thread.sleep(500);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),arg0);
        Hooks.driver.close();
    }

    public void addToWishList(){
        Hooks.driver.findElements(
                By.xpath("//button[@class=\"button-2 add-to-wishlist-button\"]"))
                .get(2).click();
    }
    public void wishListSuccessMsg(){
        SoftAssert softAssert=new SoftAssert();
        //first assertion
        String expectedResult="The product has been added to your wishlist";
        String actualResult =barNotification.getText();
        softAssert.assertTrue(expectedResult.contains(actualResult));
        //second assertion
        actualResult =barNotificationEl.getCssValue("background-color");
        expectedResult="rgba(75, 176, 122, 1)";
        softAssert.assertEquals(actualResult,expectedResult);
        //assert all
        softAssert.assertAll();
    }
}
