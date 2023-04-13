package com.practice.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverBasePage {
	WebDriver driver;

	public WebDriverBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void SelectByValue(By loc, String value) {
		Select se = new Select(driver.findElement(loc));
		se.selectByValue(value);
	}
}
