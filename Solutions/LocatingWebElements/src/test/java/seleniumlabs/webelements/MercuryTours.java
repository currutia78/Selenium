package seleniumlabs.webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTours {
	public static final String appURL = "http://newtours.demoaut.com/";
	public static final String flightFindURL = "http://newtours.demoaut.com/mercuryreservation.php";

	@Test
	public void bookFlight() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get(appURL);              
                                         // assert we are in the right place
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
		Assert.assertEquals(appURL, driver.getCurrentUrl());
		
		// One Mercury Tours Home Page
		//===============================
		WebElement name = driver.findElement(By.name("userName"));
		WebElement passwrd = driver.findElement(By.name("password"));
		// WebElement signIn = driver.findElement(By.name("login"));

		name.sendKeys("mercury");
		passwrd.sendKeys("mercury");
		name.submit();
		// signIn.click();               // use a button... the hard way  :~(

		Assert.assertTrue(driver.getCurrentUrl().startsWith(flightFindURL));
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

		// On Flight Finder Page
		//===============================

		List <WebElement> radType = driver.findElements(By.name("tripType"));
		if(radType.get(0).isSelected())
			System.out.println(radType.get(0).getAttribute("value"));
		else
			System.out.println(radType.get(1).getAttribute("value"));
		
		Select selNumPassengers = new Select(driver.findElement(By.name("passCount")));
		selNumPassengers.selectByValue("4");
		
		Select selFromPort = new Select(driver.findElement(By.name("fromPort")));
		selFromPort.selectByValue("Frankfurt");
		
		Select selFromMonth = new Select(driver.findElement(By.name("fromMonth")));
		selFromMonth.selectByValue("11");
		
		Select selFromDay = new Select(driver.findElement(By.name("fromDay")));
		selFromDay.selectByValue("20");
		
		Select selToPort = new Select(driver.findElement(By.name("ToPort")));
		selToPort.selectByValue("Paris");
		
		Select selToMonth = new Select(driver.findElement(By.name("toMonth")));
		selToMonth.selectByValue("12");
		
		Select selToDay = new Select(driver.findElement(By.name("toDay")));
		selToDay.selectByValue("1");
		
		List <WebElement> radClass = driver.findElements(By.name("servClass"));
		if(!radClass.get(2).isSelected())
			radClass.get(2).click();
		
		Select selAirline = new Select(driver.findElement(By.name("airline")));
		selAirline.deselectByVisibleText("Unified Airlines");
		WebElement btnContinue = driver.findElement(By.name("findflights"));
		btnContinue.submit();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http//newtours.demoaut.com/mercuryreservation2.php");
		
		
		
		
		 	//driver.findElement(By.name("passCount")).click();
		    //new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
		    //driver.findElement(By.name("fromPort")).click();
		    //new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
		    //driver.findElement(By.name("fromMonth")).click();
		    //new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("November");
		    //driver.findElement(By.name("fromDay")).click();
		    //new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("20");
		    //driver.findElement(By.name("toPort")).click();
		    //new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
		    //driver.findElement(By.name("toMonth")).click();
		    //new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("December");
		    //driver.findElement(By.name("toDay")).click();
		    //new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("1");
		    //driver.findElement(By.name("airline")).click();
		    //new Select()
		    //new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");
		    //driver.findElement(By.name("airline")).click();
		  }
		//Thread.sleep(3000);
		//driver.quit();
	
	
	@Test
	public void test2()   {
		System.out.println("Running Test 2!");
	}

	@Test
	public void test3()   {
		System.out.println("Running Test 3!");
	}

	@Test
	public void test4()   {
		System.out.println("Running Test 4!");
	}
}
