package ananin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpGitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void checkHeadingTest(){
        open("https://github.com/join");
        $(byText("Create your account")).shouldHave(Condition.exactText("Create your account"));
    }

    @Test
    public void signUpWithShortPassTest() {
        open("https://github.com/join");
        $("#user_password").setValue("qwerty");
        $(".error").shouldHave(Condition.exactText("Password is too short (minimum is 8 characters), needs at least 1 number, and is in a list of passwords commonly used on other websites"));
    }

    @Test
    public void signUpWithExistingEmailTest(){
        open("https://github.com/join");
        $("#user_email").setValue("mstitelnica1999@gmail.com");
        $(".error").shouldHave(Condition.exactText("Email is invalid or already taken"));
    }

    @Test
    public void signUpReservedUsernameTest(){
        open("https://github.com/join");
        $("#user_login").setValue("username");
        $(".error").shouldHave(Condition.exactText("Username 'username' is unavailable."));
    }
}