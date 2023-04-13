package com.practice.Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.practice.BaseTest.BaseTests;
import com.practice.Page.LoginPage;

public class LoginTest extends BaseTests {
	LoginPage loginPage;
	WebDriverWait wait;
@Test
public void OpenFacebookPageAndClickCreateAccount() throws Exception
{
	wait=BaseTests.ExplicitWait(driver,Duration.ofSeconds(5));
	loginPage=new LoginPage(driver);
	loginPage.ValidateTitle("Facebook – log in or sign up")
	         .ClickNewAccountButton()
	         .VeriFySignUpPage(wait)
	         .FillingSignUpForms();
	         //.ClickOnContinue();
}
}
