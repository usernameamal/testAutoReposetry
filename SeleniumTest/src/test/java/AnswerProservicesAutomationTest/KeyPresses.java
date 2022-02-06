package AnswerProservicesAutomationTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPresses {
WebDriver driver;
	
	//Arrange
		@Before
		public void initRun() {
			
			////config
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe" ); //setproperty java natif na5dhoha kifma heya just nbadlou lpadh mta3 chromedriver win 3amla l'extarction
			
			
			String url = "http://the-internet.herokuapp.com/ ";

			driver = new ChromeDriver(); 
			driver.get(url);
			driver.manage().window().maximize(); //pour maximizer windows	
		}

@Test
public void keyPresses () {
	
WebElement el =	driver.findElement(By.xpath("//a[normalize-space()='Key Presses']"));
el.click();	

WebElement el2 = driver.findElement(By.xpath("//input[@id='target']"));
el2.sendKeys("A");


//ASSERT
WebElement el3 = driver.findElement(By.id("result"));
 String actuelResult = el3.getText();
 String expectedResult ="You entered: A";
Assert.assertEquals(expectedResult, actuelResult);
}



@After
public void tearDown() {

	driver.close();
	driver.quit();

	}
}