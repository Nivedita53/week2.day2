package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// webdriver setup
		
		WebDriverManager.chromedriver().setup();
		//String driverpath = System.getProperty("Webdriver.chrome.driver");
		//System.out.println(driverpath);
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//maximize the window
		driver.manage().window().maximize();
		
		//login
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//clicking on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	
		//clicking on Leads
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8220301148");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//getting the first lead id
		Thread.sleep(2000);
		WebElement lead=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String oldLead = lead.getText();
		System.out.println(oldLead);
		
		//delete the first id
		driver.findElement(By.xpath("//a[text()='pandiyan']")).click();
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		//checking whether the id is deleted 
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(oldLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement display=driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor'][@id='ext-gen304']"));
		String noId = display.getText();
		System.out.println(noId);
	}

}
