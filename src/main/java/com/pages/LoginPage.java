package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	
	//1.By locators: Object repositries
	private By emailId = By.id("email");
	private By  password = By.id("passwd");
	private By signinBtn = By.id("SubmitLogin");
	private By forgetpwdlink = By.linkText("Forgot your password?");
	
	//2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page actions: feature behaviour of the page the form of methods
	public String getLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean checkforgetpwdLink() {
		return driver.findElement(forgetpwdlink).isDisplayed();
	}
	
	public void EnterEmail(String username) {
		driver.findElement(emailId).sendKeys(username);
			}
	
	public void EnterPwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void ClickonSignInBtn() {
		driver.findElement(signinBtn).click();
	}
	
	public AccountsPage DoLogin(String un, String Pwd) {
		System.out.println("Login with: " + un + "and" + Pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(Pwd);
		driver.findElement(signinBtn).click();
		
		return new AccountsPage(driver);
		
	}

}
