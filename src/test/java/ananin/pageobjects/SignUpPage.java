package ananin.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage {

    private final static String SIGN_UP_TEXT = "Create your account";
    private final static String PASSWORD_ERROR = "Password is too short (minimum is 8 characters), " +
            "needs at least 1 number, and is in a list of passwords commonly used on other websites";
    private final static String EMAIL_ERROR = "Email is invalid or already taken";
    private final static String LOGIN_ERROR = "Username 'username' is unavailable.";

    private SelenideElement
            headingText = $(byText("Create your account")),
            passwordInput = $("#user_password"),
            emailInput = $("#user_email"),
            loginInput = $("#user_login"),
            errorText = $(".error");

    public void openPage( ){
        Configuration.browserSize = "1920x1080";
        open("https://github.com/join");
    }

    public SignUpPage checkHeading(){
        headingText.shouldHave(Condition.exactText(SIGN_UP_TEXT));
        return this;
    }

    public SignUpPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    public SignUpPage checkPasswordError(){
        errorText.shouldHave(Condition.exactText(PASSWORD_ERROR));
        return this;
    }

    public SignUpPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public SignUpPage checkEmailError(){
        errorText.shouldHave(Condition.exactText(EMAIL_ERROR));
        return this;
    }

    public SignUpPage setLogin(String login){
        loginInput.setValue(login);
        return this;
    }

    public SignUpPage checkLoginError(){
        errorText.shouldHave(Condition.exactText(LOGIN_ERROR));
        return this;
    }
}