package com.qait.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HrisTest {
	WebDriver driver;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Arpanmishra\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void Step01_LaunchHris() {
		driver.get("https://hris.qainfotech.com/login.php");
	}
	
	@Test
		public void Step_02_AttemptToLoginWithIncorrectPasswordWillShowInvalidLogin() {
		
			driver.findElement(By.cssSelector("input[id=txtUserName]")).sendKeys("arpanmishra");
			driver.findElement(By.id("txtPassword")).sendKeys("Incorrect_Password");
			driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > input")).submit();
	
			// Expected error Message
	
			Assert.assertTrue(
					driver.findElement(By.cssSelector("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div"))
					.getText().contains("Invalid Login"));
	
		}
	
			@Test
		
		public void Step_03_AttemptToLoginWithBlankPasswordWillHighlightRedBox()
		{
			driver.findElement(By.cssSelector("input[id=txtUserName]")).sendKeys("arpanmishra");
			driver.findElement(By.id("txtPassword")).sendKeys("");
			driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > input")).submit();
			
			//Expected Error
			
			String Input =driver.findElement(By.cssSelector("#txtPassword")).getAttribute("style");
			Assert.assertTrue( Input.contains("red"));
			
			driver.findElement(By.cssSelector("input[id=txtUserName]")).clear();
			driver.findElement(By.id("txtPassword")).clear();
			
			
		}

	@Test
	 
	public void Step_04_CorrectLogin()
	{
		
		
		driver.findElement(By.cssSelector("input[id=txtUserName]")).sendKeys("arpanmishra");
		driver.findElement(By.id("txtPassword")).sendKeys("Arpan@321#");
		driver.findElement(By.id("txtPassword")).submit();
		boolean b=false;
		//Expected Error
		 
	try {
		 driver.findElement(By.cssSelector("#txtUserName"));
	}catch(NoSuchElementException e) {
		b = true;
	}
		 Assert.assertTrue(b);
	
	}
	}

