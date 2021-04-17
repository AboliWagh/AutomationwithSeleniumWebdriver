package com.amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.Chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().fullscreen();

		driver.get("https://www.amazon.in/");

		/**
		 * Sing in to Amazon
		 */

		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

		driver.findElement(By.id("ap_email")).sendKeys("aboliwagh@gmail.com");

		driver.findElement(By.xpath("//input[@id='continue']")).click();

		driver.findElement(By.name("password")).sendKeys("Airforce@1");

		driver.findElement(By.xpath("//input[@name='rememberMe']")).click();

		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * Click on Pantry Menu
		 */
		WebElement PantryLink = driver.findElement(By.xpath("//a[normalize-space()='Pantry']"));
		PantryLink.click();
		Thread.sleep(2000);

		/**
		 * Click on Cooking Essentials Menu
		 */
		driver.findElement(By.xpath("//span[normalize-space()='Cooking Essentials']")).click();
		Thread.sleep(2000);
		
		/**
		 * Find Elements under Cooking Essentials Menu and print it in Console
		 */

		WebElement CookingEssentialDropdown = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(30) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)"));

		List<WebElement> listelement = CookingEssentialDropdown.findElements(By.tagName("li"));
		for (WebElement webElement : listelement) {

			System.out.println(webElement.getText());
			
			
		}
		
		System.out.println("--------------");
		
		driver.quit();

	}
}
