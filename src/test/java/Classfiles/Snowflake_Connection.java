package Classfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snowflake_Connection extends Launch_Chromedriver{
	
	public static WebDriver driver;

	public static void snowflake_table() throws Exception, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dthirum4\\OneDrive - UHG\\Migrated\\Devibala_New\\Payer Products\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		try {
		
			Thread.sleep(5000);
			driver.manage().window().maximize();
			driver.get("https://app.snowflake.com/uhg/uhgdwaas/worksheets");
		
			Thread.sleep(10000);
			driver.findElement(By.cssSelector("button[class='G07HNKTEdY68V_9b O9HJkx4WN8HayagX T9fEqGWdoQp1I9hU TmlCwNtgR_kt6l8f']")).click();
			
			
		}finally 
		{
		//driver.close();
		}
	
	
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		snowflake_table();
		
	}

}
