package com.qa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.BasePage;
import com.qa.utils.ElementUtils;
import com.qa.utils.JavaScriptUtils;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtils eu;
	JavaScriptUtils js;
	
	By dropopt=By.id("searchDropdownBox");
	By scrollview=By.xpath("(//select[@id='searchDropdownBox']/option)[28]");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
		js=new JavaScriptUtils(driver);
	}
	
	public void AlldropdownOptions()
	{
		 eu.doclick(dropopt);
		//eu.visibilityOfEleLocated(scrollview);
	     eu.dropdownoptions(dropopt);
	     js.scrollIntoView(eu.locator(scrollview));
	}
	
	public void scrollinpage()
	{
		js.scrollIntoView(eu.locator(scrollview));
		//js.scrollPageDown();
	}

}
