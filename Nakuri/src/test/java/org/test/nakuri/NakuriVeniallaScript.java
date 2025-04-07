package org.test.nakuri;


import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.reporters.EmailableReporter2;

public class NakuriVeniallaScript {
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get("https://www.naukri.com/mnjuser/profile");
		driver.manage().window().maximize();

		// LOGIN

		driver.findElement(By.id("usernameField")).sendKeys("deepanbalaji0709@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Deepan@0709");
		driver.findElement(By.xpath("//button[text()='Login'][@type='submit']")).click();

		// Actions to be perform
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")).click();
		Thread.sleep(5000);
		WebElement find = driver.findElement(By.xpath("//input[@type='file'][@id='attachCV']"));
		find.sendKeys("C:\\Users\\Admin\\Documents\\Resume\\Resume.pdf");
		Thread.sleep(2000);
		WebElement success = driver.findElement(By.xpath("(//span[@id='attachCVMsgBox']/div/div/div/p)[2]"));
		String text = success.getText();

		if (text.equals("Resume has been successfully uploaded.")) {

			System.out.println("Pass");

		}

		driver.quit();

	}

}
