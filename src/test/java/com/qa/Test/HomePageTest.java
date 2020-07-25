package com.qa.Test;


import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.BasePage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;
import com.qa.utils.CredentialUtil;

public class HomePageTest {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	BasePage bp;
	Properties prop;
	CredentialUtil cu;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setup(String browsername) 
	{
		bp=new BasePage();
		prop=bp.propinitialization();
		driver=bp.initialization(browsername);
		cu=new CredentialUtil(prop.getProperty("email"),prop.getProperty("password"));
		lp=new LoginPage(driver);
		hp=lp.Login(cu);
	}
	
	@Test(enabled=true)
	public void HomePageDropDownTest()
	{
		 hp.AlldropdownOptions();
		
	}
	@Test(enabled=false)
	public void HomePageScrolling()
	{
		hp.scrollinpage();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
