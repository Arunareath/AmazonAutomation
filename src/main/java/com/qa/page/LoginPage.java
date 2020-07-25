package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Base.BasePage;
import com.qa.utils.CredentialUtil;
import com.qa.utils.ElementUtils;
import com.qa.utils.JavaScriptUtils;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtils eu;
	JavaScriptUtils js;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
		js=new JavaScriptUtils(driver);
	}
	
	
	By hellosigin=By.xpath("(//span[@class='nav-line-1']//parent::a//../..//following-sibling::a)[2]");
	By header=By.xpath("//span[@class='nav-sprite nav-logo-base']");
	By email=By.id("ap_email");
	By next=By.id("continue");
	By pwd=By.id("ap_password");
	By sign=By.id("signInSubmit");
	
	
	public String LoginPageTitleTest()
	{
		return  eu.getTitle();
	}
	
	public boolean LoginPageHeaderTest()
	{
		return eu.Header(header);
	}
	
	public HomePage Login(CredentialUtil cu)
	{
		
		WebElement ele = eu.locator(hellosigin);
		js.clickElementByJS(ele);
		eu.visibilityOfEleLocated(email);
		eu.sendkeys(email,cu.getUsername());
		eu.doclick(next);
		eu.sendkeys(pwd, cu.getPassword());
		eu.doclick(sign);
		return new HomePage(driver);
	}

}
