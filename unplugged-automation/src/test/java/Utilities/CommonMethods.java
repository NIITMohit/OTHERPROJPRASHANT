package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.google.common.base.Verify;


public class CommonMethods extends WindowsCapabilitie{
	
	
	public void waitForVisibility(WebElement element) throws Error {
		new WebDriverWait(driver, 300).until(ExpectedConditions
				.visibilityOf(element));
	}
	
	 public static String randomGender(){
		   String[] genderList ={"Male","Female"};
		   int idx = new Random().nextInt(genderList.length);
		   String  genderName = (genderList[idx]);
			return genderName;
			
		   }
	   public static String selectGender()
	   {
		   String gender = randomGender();
		   Reporting.logsGeneration("Selected gender is "+ gender);
		  RemoteWebElement selectGender = driver.findElementByName(gender);
			selectGender.click();
		   return gender;
	   }

	   
	   public void selectAccount(ITestContext context) throws IOException{
		   String accountName=PropertyReaderUtility.getPropertyVal(
					"Account",
					context.getCurrentXmlTest().getParameter("accountType")
							+ ".properties");
		   RemoteWebElement account = driver.findElementByName(accountName);
		   Reporting.logsGeneration("Select Account " + accountName);
		   account.click();
	   }
	   
	   
	   public static String randomFirstName(){
		   String[] firstNameList ={"JAMES","JOHN","ROBERT","MICHAEL","WILLIAM","DAVID","RICHARD","CHARLES","JOSEPH","THOMAS","CHRISTOPHER","DANIEL"};
		   int idx = new Random().nextInt(firstNameList.length);
		   String  firstName = (firstNameList[idx]);
			return firstName;
			
		   }
	   
	   public static String randomLastName(){
		   String[] lastNameList ={"Smith","Carter","Johnson","Williams","Brown","Davis","Miller","Wilson","Moore","Taylor","Anderson","Tomas"};
		   int idx = new Random().nextInt(lastNameList.length);
		   String  lastName = (lastNameList[idx]);
			return lastName;
			
		   }
	   
	   public static String randomMobileNumber(){
		   String randomNumbers = RandomStringUtils.randomNumeric(10);
		   String phNo = randomNumbers;
			return phNo;
		   }
	   
	   public static String randomAccountNumber(){
		   String randomNumbers = RandomStringUtils.randomNumeric(16);
		   String phNo = randomNumbers;
			return phNo;
		   }
	 
	   public static String randomSSN()
		   { 
		   Random rNum = new Random();
			int result = 0;
			for (int i = 1; i < 10; i++) {
				result = result * 10 + (rNum.nextInt(9) + 1);
			}
			String SSN = Integer.toString(result);
			return SSN; 
		   }
	   
	   public static void scroll(AppiumDriver<?> driver, WebElement e){
			 Actions act = new Actions(driver);
			    act.moveToElement(e);
			    act.sendKeys(Keys.PAGE_DOWN).perform();
			   
		}

		public static void scrollUp(AppiumDriver<?> driver, WebElement e){
			 Actions act = new Actions(driver);
			    act.moveToElement(e);
			    act.sendKeys(Keys.PAGE_UP).perform();
			   
		}
		
	
		public static String randomAlfaNumericString(){
			String id = UUID.randomUUID().toString().substring(0,10);
			return id;
		}
		
	public static String randomString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return output;
		}
		
		public static void scrollInsidePopup(AppiumDriver<?> driver, WebElement e, String StateName) throws InterruptedException, AWTException{
			
			e.click();
			//WebElement state1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[4]/Custom[3]/ComboBox/ListItem[1]/Text");
			Robot robot = new Robot(); 
			Thread.sleep(1000);
			//e.sendKeys(Keys.ARROW_DOWN);
			
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			//state1.sendKeys(Keys.ENTER);
			 String s1 = StateName;
			/*for(int i=1;i<=54;i++){
				//WebElement e1 = driver.findElementByXPath("/Window/Window[3]/Custom/Custom/Custom/Custom[3]/Custom[3]/Custom/Custom/Custom/Pane/Custom/Custom/Custom/Pane/Custom/Custom[6]/Custom[1]/ComboBox/ListItem/Text");
			String states1 =e.getText();	    
				if (Objects.equals(states1,s1)){
					//e1.sendKeys(Keys.ENTER);
					break;
				}
				else {
					e.sendKeys(Keys.ARROW_DOWN);
				if(i==54)
				Assert.assertEquals(states1,s1);
				}	
			 
			}*/
			 Thread.sleep(1000);
			 e.sendKeys(s1);  
			 Thread.sleep(1000);
			 String states1 =e.getText();
			 if (Objects.equals(states1,s1)){
				 Reporting.logsGeneration(states1);
			 }
			 else
				 e.sendKeys(s1);
			 Thread.sleep(1000);
		}


		public static void scroll(AppiumDriver<?> driver, String s){
			 Actions act = new Actions(driver);
			 RemoteWebElement e = (RemoteWebElement) driver.findElementByName(s);
			    act.moveToElement(e);
			    act.sendKeys(Keys.PAGE_UP).perform();
		}
		
		public static void compareElementsText(WebElement w1, WebElement w2){
			
			String s1 = w1.getText();
			String s2 = w2.getText();
			Reporting.logsGeneration("Comparing "+ s1 + " With " + s2);
			//Assert.assertEquals(s1, s2);
			if(s1.equals(s2)){
				Reporting.passLogsGeneration("Pass");
			}
			else
				Reporting.failLogsGeneration("Does'nt match");
			
		}
		
public static void checkNull(WebElement w1){
			
			w1.click();
	        String s1 = w1.getText();
	        if (s1 != null && !s1.isEmpty())
			Reporting.logsGeneration("Checking "+ s1);
	        
	        else
	        	Assert.assertEquals(false, true);
		}
		
   public static void compareElementsText(WebElement w1, String s1){
			
			String s2 = w1.getText();
			Reporting.logsGeneration("Comparing "+ s1 + " With " + s2);
			//Assert.assertEquals(s2, s1);
			if(s1.equals(s2)){
				Reporting.passLogsGeneration("Pass");
			}
			else
				Reporting.failLogsGeneration("Does'nt match");
		}
   

    public static void compareElementsContains(WebElement w1, String s1){
	
	String s2 = w1.getText();
	Reporting.logsGeneration("Comparing "+ s1 + " With " + s2);
	
	//Assert.assertTrue(s2.contains(s1));
	if(s2.contains(s1)){
		Reporting.passLogsGeneration("Pass");
	}
	else
		Reporting.failLogsGeneration("Does'nt match");
	
   }

    

   public static void stringToChar(WebElement element, String value){
    String val = value;
    element.click();
    element.clear();

    for (int i = 0; i < val.length(); i++){
        char c = val.charAt(i);
        String s = new StringBuilder().append(c).toString();
        element.sendKeys(s);
    }       
    
    
}
   
   public static String getNumber(WebElement e){
		String employeeNumber_value= e.getText();
		   String employeeNumberOnly= employeeNumber_value.replaceAll("[^0-9]", "");
		   return employeeNumberOnly;
   }
   
   public static void checkElementPresent(String s){
	   
	   Boolean isPresent = driver.findElementsByAccessibilityId(s).size() > 0;
	   if(isPresent)
		   Reporting.logsGeneration("Saved successfully");
		   else
			   Assert.assertEquals(true, false);
	   }
   
   
   public void waitForLoader() throws InterruptedException{
		
		/*int counter = 0;
		Thread.sleep(4000);
		while(driver.findElementsByClassName("ProgressBar").size()>0)
		{
		Thread.sleep(1000);
		counter++;
		if(counter ==100)
			break;
		}*/
	   Thread.sleep(4000);
	   if(driver.findElementsByClassName("ProgressBar").size()>0){
	   @SuppressWarnings("deprecation")
	Wait<WindowsDriver<?>> wait = new FluentWait<WindowsDriver<?>>(driver).withTimeout(100, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ProgressBar")));
	   }
		
	}
   
   public static String randomMemberId() {
		Random rNum = new Random();
		int result = 0;
		for (int i = 1; i < 10; i++) {
			result = result * 10 + (rNum.nextInt(9) + 1);
		}
		String SSN = "M" + Integer.toString(result);
		return SSN;
	} 
   
}
