package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before

    public static void openBrowser(){
        // 1- Bridge
        String edgePath=System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver",edgePath+ "\\src\\main\\resources\\msedgedriver.exe");

        // 2- create object from edge browser
        driver = new EdgeDriver();

        //3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 4- navigate to url
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
