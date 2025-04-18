package Classfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.common.io.Files;

import Utility.Report;

public class Launch_Chromedriver {
	
	//private static final String String = null;
		//public static int ans=0;
		public static WebDriver driver;
		public static long totalTime_SPOG_RCM_Ambulatory_Page;
		static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		public static String select_email_id;
	
		public static long Launch_Chromebrowser() throws Exception, InterruptedException
		{
		ArrayList<String> arraylist = Report.getList();
		//System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe" );
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\dthirum4\OneDrive - UHG\Migrated\Devibala_New\Payer Products\Drivers\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dthirum4\\OneDrive - UHG\\Migrated\\Devibala_New\\Payer Products\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		try {
		//launch_chrome
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get("https://app.powerbi.com/");
		
		//Login_Process	
		Thread.sleep(5000);
		
		//WebElement email=driver.findElement(By.id("email"));
		select_email_id=Select_credentials.select_credentials(0, 0);
		driver.findElement(By.id("email")).sendKeys(select_email_id);
		//driver.findElement(By.id("email")).sendKeys("devibala.thirumalraj@optum.com");
		WebElement submit=driver.findElement(By.id("submitBtn")); 
		submit.click();
		
		//click_browse
		Thread.sleep(40000);
		WebElement browser=driver.findElement(By.xpath("//button[contains(@aria-label, 'Browse')]"));
		browser.click();
		
		//submit_SPOG_RCM_link
		
		Thread.sleep(10000);
		//System.out.println("going inside SPOG link");
		WebElement SPOG_LINK=driver.findElement(By.linkText("SPoG - RCM Ambulatory"));
		SPOG_LINK.click();
		
		//To_find_response_time_of_SPOG_RCM
		Date start_date = new Date();
		long startTime_SPOG_RCM_Ambulatory_Page = System.currentTimeMillis();
		String Start_Date_Time= dateFormat.format(start_date);
		System.out.println("Current date and time is " +Start_Date_Time);

		
		new WebDriverWait(driver, 10).until(ExpectedConditions.
				presenceOfElementLocated(By.linkText("SPoG - RCM Ambulatory")));
		
		//capture_the_element_to_make_sure_the_page_is_fully_loaded
		Thread.sleep(15000);
		
		WebElement Dest_Element=driver.findElement(By.xpath ("//*[contains(./text(),'Gross Charges')]")) ;
		System.out.println("Data Element in the Page: " + Dest_Element.getText() );
		
		//Fit_to_page_to_capture_full_page
		WebElement Fit_to_Page=driver.findElement(By.xpath("//button[@id='fitToPageButton']"));
		Fit_to_Page.click();
		
		//Take_Screenshot_before_finding_the_end_time
		//TakeScreenshot();
		Date end_date = new Date();
		long endTime_SPOG_RCM_Ambulatory_Page = System.currentTimeMillis();
		String End_Date_Time= dateFormat.format(end_date);
		System.out.println("Current date and time is " +End_Date_Time);

		totalTime_SPOG_RCM_Ambulatory_Page = endTime_SPOG_RCM_Ambulatory_Page - startTime_SPOG_RCM_Ambulatory_Page;

		System.out.println("Total Page [SPOG_RCM_Ambulatory_Page] Load Time: " + totalTime_SPOG_RCM_Ambulatory_Page + " milliseconds");
		
		
		//Create_Alerts_when_page_loading_is_exceeding_morethan_one_minute
		if (totalTime_SPOG_RCM_Ambulatory_Page > 60000)
		{
			System.out.println("[SPOG_RCM_Ambulatory_Page] is loading more than 1 minute");
		}
		
		arraylist.add(Start_Date_Time);arraylist.add(End_Date_Time);
		//String myString = String.valueOf(totalTime_SPOG_RCM_Ambulatory_Page);
		String totaltime = String.valueOf(totalTime_SPOG_RCM_Ambulatory_Page);
		arraylist.add(totaltime);
		}
		finally 
		{
		//driver.close();
		}
	
		
		return totalTime_SPOG_RCM_Ambulatory_Page;
	}
		
		public static void TakeScreenshot() throws IOException
		{
			// Delete existing screenshot
			File screenshotFile = new File(System.getProperty("user.dir") + "\\Screenshots\\screenshot.jpg");
			if (screenshotFile.exists()) {
				System.out.println("Screenshot exists");
				FileUtils.deleteQuietly(screenshotFile); 
			}
			TakesScreenshot screenshot = (TakesScreenshot)driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(System.getProperty("user.dir") +"\\Screenshots\\screenshot.jpg");
            FileUtils.copyFile(srcFile, destFile);
		}
		
		public static void main (String a[]) throws InterruptedException, Exception
		{
			System.out.println(Launch_Chromebrowser());
		}
}



