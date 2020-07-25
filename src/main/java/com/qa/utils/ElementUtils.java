package com.qa.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	WebDriverWait wait;

	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,20);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean Header(By locator)
	{
		return locator(locator).isDisplayed();
	}
	
	public WebElement locator(By locator)
	{
		return driver.findElement(locator);
	}
	
	public void ActionsMethod(By locator)
	{
		Actions act=new Actions(driver);
		act.moveToElement(locator(locator));
	}
	
	public void doclick(By ele)
	{
	    locator(ele).click();
	}
	
	public void sendkeys(By locator,String str)
	{
		locator(locator).sendKeys(str);
	}
	
	public void visibilityoftheEleandClick(By locator)
	{
		WebElement ele = locator(locator);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void visibilityOfEleLocated(By locator)
	{
		wait.until(ExpectedConditions.visibilityOf(locator(locator)));
	}
	
	public Select dropdownoptions(By locator)
	{
		return new Select(locator(locator));
	
	}
}
