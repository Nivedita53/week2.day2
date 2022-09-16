package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launching Leafground URL
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys("India");
		
		Boolean  confirmDisabled = driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled']")).isEnabled();
		System.out.println(confirmDisabled);
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();
		String typedText = driver.findElement(By.xpath("//input[@value='My learning is superb so far.']")).getAttribute("value");
		System.out.println(typedText);
		
		driver.findElement(By.xpath("//input[@placeholder='Your email and tab']")).sendKeys("test@123.gmail.com");
		
		
		
	}

}
