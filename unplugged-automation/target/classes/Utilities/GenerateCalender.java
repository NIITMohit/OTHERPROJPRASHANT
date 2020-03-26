package Utilities;

import java.util.Random;

import org.openqa.selenium.remote.RemoteWebElement;

public class GenerateCalender extends WindowsCapabilitie{

public static void calender() throws InterruptedException{
		
		String month=randomMonth();
		Thread.sleep(1000);
		RemoteWebElement monthValue = driver.findElementByName(month);
		Thread.sleep(1000);
		monthValue.click();
		
		String date=randomDate();
		Thread.sleep(1000);
		RemoteWebElement dateValue=driver.findElementByName(date);
		dateValue.click();
		
		String year=randomYear();
		Thread.sleep(1000);
		RemoteWebElement yearValue=driver.findElementByName(year);
		yearValue.click();
		Thread.sleep(1000);
	}
	
   public static String randomDate(){
	Random r = new Random();
	int low = 1;
	int high = 29;
	int result = r.nextInt(high-low) + low;
	String date = Integer.toString(result);
	return date;
   }
   
   public static String randomYear(){
		Random r = new Random();
		int low = 1960;
		int high = 2004;
		int result = r.nextInt(high-low) + low;
		String Year = Integer.toString(result);
		return Year;
	   }
   
   public static String randomMonth(){
	   String[] monthList ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	   int idx = new Random().nextInt(monthList.length);
	   String month = (monthList[idx]);
		return month;
		
	   }
}
