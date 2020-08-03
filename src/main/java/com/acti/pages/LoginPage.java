package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*tester Name: A
 * Date Created 8/2/2020
 * Approved by: Santhosh
 * 
 */

public class LoginPage extends DriverScript{

	@FindBy(id="username") WebElement usernameTbox;
	@FindBy(name="pwd") WebElement passwordtbox;
	@FindBy(id="loginButton") WebElement loginButton;
	@FindBy(xpath="//div[@class='atLogoImg']") WebElement actilogo;
	
	//*********************************************************************
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//******************************************************************************
	
	public void validateloginFunction(String username, String password)
	{
		usernameTbox.sendKeys(username);
		passwordtbox.sendKeys(password);
		loginButton.click();
		
	}
	
	public boolean verifyActilogo()
	{
		return actilogo.isDisplayed();
	}
	
	public String verifyloginpagetitle()
	{
		return driver.getTitle();
	}
}
