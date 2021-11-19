package ananin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageGitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://github.com/login");
    }

    @Test
    public void loginWithRealCredsTest() {
        $("#login_field").setValue("Ambidre");
        $("#password").setValue("mstitelnica1999");
        $(byXpath("//input[@value='Sign in']")).click();
        $(byXpath("//summary[@aria-label ='View profile and more']")).click();
        $(byXpath("//strong[@class ='css-truncate-target']")).shouldHave(Condition.exactText("Ambidre"));
    }

    @Test
    public void loginWithEmptyCredsTest(){
        $("#login_field").setValue("");
        $("#password").setValue("");
        $(byXpath("//input[@value='Sign in']")).click();
        $(byXpath("//*[@id='js-flash-container']//div[@class='container-lg px-2']")).shouldHave(Condition.exactText("Incorrect username or password."));
    }
}
