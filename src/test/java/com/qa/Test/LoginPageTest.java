package com.qa.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.BasePage;
import com.qa.page.LoginPage;
import com.qa.utils.CredentialUtil;

public class LoginPageTest {
	
	
	BasePage Bp;
	LoginPage lp;
	WebDriver driver;
	CredentialUtil cu;
	Properties prop;
	
	
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setup(String browsername)
	{
		Bp=new BasePage();
		prop=Bp.propinitialization();
		driver = Bp.initialization(browsername);
		lp=new LoginPage(driver);
		cu=new CredentialUtil(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(enabled=true)
	public void LoginPageTitleTest()
	{
		String title = lp.LoginPageTitleTest();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	@Test(enabled=true)
	public void LoginPageHeaderTest()
	{
		Assert.assertTrue(lp.LoginPageHeaderTest());
	}
	
	@Test(enabled=true)
	public void LoginPageLoginTest() throws InterruptedException
	{
		lp.Login(cu);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
