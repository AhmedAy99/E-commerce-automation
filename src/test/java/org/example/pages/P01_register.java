package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public P01_register(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerBtn;
    @FindBy(id = "gender-male")
    public WebElement maleGenderBtn;
    @FindBy(id="FirstName")
    public WebElement firstNameEl;
    @FindBy(id="LastName")
    public WebElement lastNameEl;
    @FindBy(id="Email")
    public WebElement emailEl;
    @FindBy(id="Password")
    public WebElement PasswordEl;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmPasswordEl;
    @FindBy(id="register-button")
    public WebElement registerButtonEl;
    @FindBy(name="DateOfBirthDay")
    public WebElement dayOfBirth;
    @FindBy(name="DateOfBirthMonth")
    public WebElement monthOfBirth;
    @FindBy(name="DateOfBirthYear")
    public WebElement yearOfBirth;
    public void fillBirthDate(){
        Select dropdown = new Select(dayOfBirth);
        dropdown.selectByVisibleText("19");
        dropdown=new Select(monthOfBirth);
        dropdown.selectByVisibleText("May");
        dropdown=new Select(yearOfBirth);
        dropdown.selectByVisibleText("1930");
    }

}
