package ananin.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final static String ERROR_TITLE = "Incorrect username or password.";

    private SelenideElement
            loginInput = $("#login_field"),
            passwordInput = $("#password"),
            signInInput = $(byXpath("//input[@value='Sign in']")),
            profileDropdown = $(byXpath("//summary[@aria-label ='View profile and more']")),
            loginText = $(byXpath("//strong[@class ='css-truncate-target']")),
            errorText = $(byXpath("//*[@id='js-flash-container']//div[@class='container-lg px-2']"));

    public void openPage( ){
        Configuration.browserSize = "1920x1080";
        open("https://github.com/login");
    }

    public LoginPage setLogin(String login){
        loginInput.setValue(login);
        return this;
    }

    public LoginPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage clickSignIn(){
        signInInput.click();
        return this;
    }

    public LoginPage clickProfileDropdown(){
        profileDropdown.click();
        return this;
    }

    public LoginPage checkLogin(String login){
        loginText.shouldHave(Condition.exactText(login));
        return this;
    }

    public LoginPage checkError(){
        errorText.shouldHave(Condition.exactText(ERROR_TITLE));
        return this;
    }
}