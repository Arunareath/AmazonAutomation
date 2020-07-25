package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	 WebDriver driver;
	 Properties prop;
	 
	 public static ThreadLocal<WebDriver> thread=new ThreadLocal<WebDriver>();
	 
	 public static synchronized WebDriver getdriver()
	 {
		 return thread.get();
	 }

    
	public WebDriver initialization(String browsername)
	{
    	if(browsername.equals("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		ChromeOptions op=new ChromeOptions();
    		op.addArguments("--incognito");
    		//driver=new ChromeDriver(op);
    		thread.set(new ChromeDriver(op));
    		getdriver().get(prop.getProperty("url"));
    		
    		
    	}
    	else if(browsername.equals("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		//driver=new FirefoxDriver();
    		thread.set(new FirefoxDriver());
    		getdriver().get(prop.getProperty("url"));
   
    	}
    	return getdriver();
	}
	
	
	public Properties propinitialization()
	{
		prop=new Properties();
		FileInputStream l=null;
		try {
			l = new FileInputStream("C:\\Users\\Arun Areath\\Desktop\\API Project\\Amazontesting\\src\\main\\java\\com\\qa\\prop\\credentials.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(l);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public String getScreenshot() throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)getdriver());
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		File dest=new File(path);
		FileUtils.copyFile(src,dest);
		return path;
	}


}
