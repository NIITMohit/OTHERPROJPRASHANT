package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class WindowsCapabilitie {
	public static WindowsDriver<WindowsElement> driver;
	public static AppiumDriverLocalService service;
	public String accountName;

	// Start Appium Server
	public AppiumDriverLocalService startServer() {
		boolean flag = checkServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public void installApp(String commands) throws IOException,
			InterruptedException {

		// String[] command =
		// {"cd C:/Users/M1052802/Desktop/Automation/Application","Add-AppxPackage",
		// "*.appxbundle"};
		// ProcessBuilder builder = new ProcessBuilder("powershell.exe", "/c",
		// "cd \"C:/Users/M1052802/Desktop/Automation/Application\" && Add-AppxPackage *.appxbundle");
		ProcessBuilder builder = new ProcessBuilder("powershell.exe", "/c",
				commands);
		builder.redirectErrorStream(true);
		System.out.println("Running command *******" + commands);
		Process p = builder.start();
		Thread.sleep(3000);
		/*
		 * builder.command("Add-AppxPackage *.appxbundle"); p = builder.start();
		 */
		BufferedReader r = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}

	}

	@BeforeSuite
	public void Windowcaps() throws MalformedURLException,
			InterruptedException, IOException {
		Reporter.log("Starting Appium", true);
		installApp("Add-AppxPackage *.appxbundle ; dir");
		service = startServer();
		service = AppiumDriverLocalService.buildDefaultService();
		// service.start();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "WindowsPC");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("platformName", "windows");
		// capabilities.setCapability("automationName", "WinAppDriver");
		// capabilities.setCapability("app",
		// "Microsoft.People_8wekyb3d8bbwe!x4c7a3b7dy2188y46d4ya362y19ac5a5805e5x");
		// capabilities.setCapability("app","C:\\Users\\M1052802\\Desktop\\Automation\\Application\\EverwellUnplugged.UWP_5.2.12.0_x86_x64_arm.appxbundle");
		capabilities.setCapability("app","01e2d2b2-2fb2-4a0c-a45b-b33a7d54c536_t387d2zbac88p!App");
		// capabilities.setCapability("app","sdfasdfasfasfdasdfsafasfgffdf_t387d2zbac88p!App");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,100);
		capabilities.setCapability("wdaStartupRetries", "4");
		// capabilities.setCapability("iosInstallPause","8000" );
		capabilities.setCapability("windowsInstallPause", "50");
		capabilities.setCapability("ms:experimental-webdriver", true);
		capabilities.setCapability("wdaStartupRetryInterval", "10");
		capabilities.setCapability("noReset", false);
		driver = new WindowsDriver<WindowsElement>(new URL(
				"http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		capabilities.getVersion();
	}

	/*
	 * @AfterTest(alwaysRun=true) public void stopService() throws IOException {
	 * 
	 * if(service!=null) service.stop(); }
	 */

	public static void getScreenShot(String s) throws InterruptedException {
		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("Taking Screen Shot");
			// String timeStamp = new
			// SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			File path = new File(System.getProperty("user.dir")
					+ "/ScreenShot/" + s + ".png");
			FileUtils.copyFile(srcfile, path);
			Reporter.log("<a href='" + path.getAbsolutePath() + "'> <img src='"
					+ path.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporting
					.logsGeneration("Unable to take screen shot Application is crashed");
			e.printStackTrace();

		}
	}

	public static boolean checkServerIsRunning(int port) {
		boolean IsServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			IsServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return IsServerRunning;
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	@AfterSuite(alwaysRun = true)
	public void End() throws IOException, InterruptedException {

		Reporting.logsGeneration("Inside After class");
		if (driver != null)
			driver.quit();

		if (service != null)
			service.stop();

		Reporting.logsGeneration("Closing node");
		installApp("taskkill /F /IM node.exe");
		// Stop appium server when test Is ended.
		// appiumStop();
	}

	private ThreadLocal<String> testName = new ThreadLocal<>();

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
		service.start();
		if (testData.length > 0) {
			try {
				if (!((String) testData[0]).contains("org.testng")) {
					testName.set(method.getName() + "_" + testData[0]);
					ctx.setAttribute("testName", testName.get());
				}
			} catch (ClassCastException cce) {
				ctx.setAttribute("testName", method.getName());
			}
		} else
			ctx.setAttribute("testName", method.getName());
	}

	@AfterMethod
	public void afterMethod() {
		service.stop();
	}

}
