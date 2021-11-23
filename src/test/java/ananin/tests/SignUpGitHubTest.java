package ananin.tests;

import ananin.pageobjects.SignUpPage;

import org.junit.jupiter.api.Test;

public class SignUpGitHubTest extends SignUpPage {

    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void checkHeadingTest(){
        signUpPage.openPage();
        signUpPage.checkHeading();
    }

    @Test
    public void signUpWithShortPassTest() {
        signUpPage.openPage();
        signUpPage.setPassword("qwerty").checkPasswordError();
    }

    @Test
    public void signUpWithExistingEmailTest(){
        signUpPage.openPage();
        signUpPage.setEmail("mstitelnica1999@gmail.com").checkEmailError();
    }

    @Test
    public void signUpReservedUsernameTest(){
        signUpPage.openPage();
        signUpPage.setLogin("username").checkLoginError();

    }
}