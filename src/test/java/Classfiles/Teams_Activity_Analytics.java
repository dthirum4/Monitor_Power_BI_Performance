package Classfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Teams_Activity_Analytics extends Launch_Chromedriver{
	public static long totalTime_Team_Activity_Analytics_Page;
	
	public long team_activity_analytics_report() throws InterruptedException {
		
	ArrayList<String> arraylist = Report.getList();
		
	//click_home_button
	Thread.sleep(5000);	
	WebElement home=driver.findElement(By.xpath("//button[contains(@aria-label, 'Home')]"));
	home.click();
	
	//Scroll down page
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");

	
	//submit_Team_Activity_Analytics_link
	
	Thread.sleep(10000);
	System.out.println("going inside Team Activity Analytics link");
	WebElement Team_Activity_Analytics_LINK=driver.findElement(By.linkText("Teams activity analytics"));
	Team_Activity_Analytics_LINK.click();
	
	System.out.println("went into report");
	//To_find_response_time_of_Team_Activity_Analytics
	Date start_date = new Date();
	//long startTime_SPOG_RCM_Ambulatory_Page = System.currentTimeMillis();
	
	long startTime_Team_Activity_Analytics_Page = System.currentTimeMillis();
	String Start_Date_Time= dateFormat.format(start_date);
	System.out.println("Current date and time is " +Start_Date_Time);
	
	//new WebDriverWait(driver, 60).until(ExpectedConditions.
			//presenceOfElementLocated(By.linkText("Teams activity analytics")));
	
	System.out.println("went into report - start time");
	
	System.out.println("Start Time :" +startTime_Team_Activity_Analytics_Page);
	//capture_the_element_to_make_sure_the_page_is_fully_loaded
	Thread.sleep(15000);
	
	WebElement Destination_Element=driver.findElement(By.xpath ("//*[contains(./text(),'Meeting summary')]")) ;
	System.out.println("Data Element in the Page: " + Destination_Element.getText() );
	
	Date end_date = new Date();
	//long endTime_SPOG_RCM_Ambulatory_Page = System.currentTimeMillis();
	
	long endTime_Team_Activity_Analytics_Page = System.currentTimeMillis();
	String End_Date_Time= dateFormat.format(end_date);
	System.out.println("Current date and time is " +End_Date_Time);

	totalTime_Team_Activity_Analytics_Page = endTime_Team_Activity_Analytics_Page - startTime_Team_Activity_Analytics_Page;

	System.out.println("Total Page [TEAM_ACTIVITY_ANALYTICS_Page] Load Time: " + totalTime_Team_Activity_Analytics_Page + " milliseconds");
	
	arraylist.add(Start_Date_Time);arraylist.add(End_Date_Time);
	//String myString = String.valueOf(totalTime_SPOG_RCM_Ambulatory_Page);
	String totaltime = String.valueOf(totalTime_Team_Activity_Analytics_Page);
	arraylist.add(totaltime);
	
	return totalTime_Team_Activity_Analytics_Page;
	
	}
	
}
