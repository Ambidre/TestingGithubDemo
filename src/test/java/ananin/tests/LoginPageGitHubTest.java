package ananin.tests;

import ananin.pageobjects.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginPageGitHubTest extends LoginPage {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginWithRealCredsTest() {
        loginPage.openPage();
        loginPage.setLogin("Ambidre").setPassword("mstitelnica1999");
        loginPage.clickSignIn().clickProfileDropdown();
        loginPage.checkLogin("Ambidre");
    }

    @Test
    public void loginWithEmptyCredsTest(){
        loginPage.openPage();
        loginPage.setLogin("Ambidre").setPassword("mstitelnica199");
        loginPage.clickSignIn();
        loginPage.checkError();
    }
}
