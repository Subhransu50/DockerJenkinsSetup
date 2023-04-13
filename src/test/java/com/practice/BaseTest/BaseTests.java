package com.practice.BaseTest;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
	public WebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void LunchBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public static WebDriverWait ExplicitWait(WebDriver driver, Duration sec) {
		wait = new WebDriverWait(driver, sec);
		return wait;
	}

	@AfterMethod
	public void TearDown() throws Exception {
		TakeScreenshot();
		driver.close();
		driver.quit();
	}

	public void TakeScreenshot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File(
				"D:\\JavaWorkspace\\DemoTest\\src\\main\\resource\\Screenshot\\" + TimeUnit.MILLISECONDS + ".png"));

	}
}
