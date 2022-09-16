package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException  {
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
				
				driver.findElement(By.id("username")).sendKeys("DemoCSR");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//clicking on CRM/SFA
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//clicking on Leads
				
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.linkText("Find Leads")).click();
				driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Ahalya");
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
			
				driver.findElement(By.linkText("Edit")).click();
				WebElement oldCompanyName=driver.findElement(By.id("updateLeadForm_companyName"));
				String oldComName = oldCompanyName.getAttribute("value");
				System.out.println(oldComName);
				
	            driver.findElement(By.id("updateLeadForm_companyName")).clear();
				driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Testleaf123");
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				
				WebElement newCompanyName=driver.findElement(By.id("viewLead_companyName_sp"));
				String[] newComName = newCompanyName.getText().split(" ");
				
				System.out.println(newComName);
				if(newComName[0].equals(oldComName)) {
					System.out.println("company name is not updated");
				}
				else {
					System.out.println("company name is updated");
				}
				driver.close();
				
			
	}

}
