package com.practice.Page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
private By CreateNewButton=By.xpath("//a[text()='Create new account']");
@FindBy(xpath="//a[text()='Create new account']")
private WebElement CreateNewButton1;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

	public LoginPage ValidateTitle(String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Title does not match");
		return this;
	}
	public SignUpPage ClickNewAccountButton() throws Exception
	{
		driver.findElement(CreateNewButton).click();
		//Thread.sleep(5000);
		return new SignUpPage(driver);
	}
}
