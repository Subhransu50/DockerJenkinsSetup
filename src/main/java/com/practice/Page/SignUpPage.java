package com.practice.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.practice.Page.WebDriverBasePage;

import com.practice.CommonData.CommonDatas;

public class SignUpPage extends WebDriverBasePage {
	WebDriver driver;

	private By SignUpLable = By.xpath("//div[text()='Sign Up']");
	private By FirstName = By.xpath("//input[@name=\"firstname\"]");
	private By SurName = By.xpath("//input[@name=\"lastname\"]");
	private By MobileNumber = By.xpath("//input[@class=\"inputtext _58mg _5dba _2ph-\" and @name=\"reg_email__\"]");
	private By Password = By.xpath("//input[@id='password_step_input']");
	private By Date = By.xpath("//select[@title='Day']");
	private By Month = By.xpath("//select[@title='Month']");
	private By Year = By.xpath("//select[@title='Year']");

	private By Gender(String gender) {
		return By.xpath("//label[text()='" + gender + "']");
	}

	private By SignUp = By.xpath("(//button[text()='Sign Up'])[1]");
	private By Continue = By.xpath("//span[text()='Continue']");

	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public SignUpPage VeriFySignUpPage(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpLable));
		Boolean status = driver.findElement(SignUpLable).isDisplayed();
		Assert.assertTrue(status, "SignUP page does not displayed");
		return this;
	}

	public SignUpPage FillingSignUpForms() throws Exception {
		driver.findElement(FirstName).sendKeys(CommonDatas.FirstName);
		driver.findElement(SurName).sendKeys(CommonDatas.SurName);
		driver.findElement(MobileNumber).sendKeys(CommonDatas.MobileNumber);
		driver.findElement(Password).sendKeys(CommonDatas.Newpassword);
		/*
		 * Select se = new Select(driver.findElement(Date)); se.selectByValue("1");
		 * Select sc = new Select(driver.findElement(Month)); sc.selectByValue("2");
		 * Select sl = new Select(driver.findElement(Year)); sl.selectByValue("2000");
		 */
		SelectByValue(Date, "1");
		SelectByValue(Month, "2");
		SelectByValue(Year, "2000");
		driver.findElement(Gender(CommonDatas.Gender)).click();
		driver.findElement(SignUp).click();
		Thread.sleep(5000);
		return this;
	}

	public SignUpPage ClickOnContinue() {
		driver.findElement(Continue).click();
		return this;
	}

}
