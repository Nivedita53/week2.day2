package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launching Facebook URL
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Creating New Account
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Filling the fields
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("leaf");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("testleaf");
		
		//Handling th dropdowns
		WebElement source = driver.findElement(By.id("day"));
		Select day = new Select(source);
		day.selectByValue("13");
		
		WebElement source1 = driver.findElement(By.id("month"));
		Select month = new Select(source1);
		month.selectByValue("3");
		
		WebElement source2 = driver.findElement(By.id("year"));
		Select year = new Select(source2);
		year.selectByValue("2000");
		//Clicking the radio Button
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		driver.close();
		
		
				
		
		
	}

}
