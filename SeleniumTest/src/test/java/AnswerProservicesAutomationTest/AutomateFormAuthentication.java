package AnswerProservicesAutomationTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFormAuthentication  {
	WebDriver driver;
	
//Arrange
		@Before
		public void initRun() {
			
			////config
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe" ); 
			String url = "http://the-internet.herokuapp.com/ ";

			driver = new ChromeDriver(); 
			driver.get(url);
			driver.manage().window().maximize(); //pour maximizer windows	
			
			
			WebElement el1 =	driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']"));
			el1.click();
		}

//ACT

		@Test
		public void loginInCorrect() {
		//WebElement el1 =	driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']"));
		//el1.click();

		WebElement el2 = driver.findElement(By.id("username"));
		el2.sendKeys("tomsmith");
		WebElement el3 = driver.findElement(By.id("password"));
		el3.sendKeys("xxxxx");
		
		WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
		login.click();
		
		//ASSERT
		WebElement el4 = driver.findElement(By.xpath("//div[@id='flash']"));
	Boolean c = el4.getText().contains("Your password is invalid!");
		Assert.assertTrue(c);

    //	String actuelResult = el4.getText();
		//String expectedResult ="Your password is invalid!";
		//Assert.assertEquals(el4.getText(),"Your password is invalid!");
		
		}
		


		@Test
		public void loginCorrect() {
			
		//WebElement el1 =	driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']"));
		//el1.click();

		WebElement el2 = driver.findElement(By.id("username"));
		el2.sendKeys("tomsmith");
		WebElement el3 = driver.findElement(By.id("password"));
		el3.sendKeys("SuperSecretPassword!");
		WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
		login.click();
		
		//ASSERT
		WebElement alert2 = driver.findElement(By.id("flash"));
		Boolean b = alert2.getText().contains("You logged into a secure area!");
		Assert.assertTrue(b);
		//Assert.assertEquals("You logged into a secure area!", alert2.getText());
		
		}
		
		@Test
		public void logOut() {
		WebElement el2 = driver.findElement(By.id("username"));
			el2.sendKeys("tomsmith");
		WebElement el3 = driver.findElement(By.id("password"));
			el3.sendKeys("SuperSecretPassword!");
		WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
		login.click();
		WebElement logout = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		logout.click();
		
		//ASSERT
		Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/login");
		}	

		@After
		public void tearDown() {

			driver.close();
			driver.quit();

			}

	
	
	

}

