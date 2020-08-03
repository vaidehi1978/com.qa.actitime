package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop; 
	
	public DriverScript()
	{
		try
		{
			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		
		catch (Exception e)
		{
			System.out.println("unable to load the properties "+ e.getMessage());
		}
		
	}
		
		public static void initbrowser()
		{
			String browser = prop.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
				driver= new ChromeDriver();
				
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{ 
				System.setProperty("webdriver.gecko.driver", "./browsers/geckodriver.exe");
				driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "./browsers/IEDriverServer.exe");
				driver= new InternetExplorerDriver();
			}
			else
			{
				System.out.println("no proper browser specified");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			 String url = prop.getProperty("url");
			driver.get(url);
		}
		
		  
		
		
	

}
