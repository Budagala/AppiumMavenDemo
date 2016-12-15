package com.maven.appium;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDropTestNGDemo {

	DesiredCapabilities cap;
	AndroidDriver driver;

	@BeforeClass
	public void setUP() {
		try{
		
		cap = new DesiredCapabilities();
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", System.getProperty("PlatformName"));
		cap.setCapability("platformVersion", System.getProperty("PlatformVersion"));
		cap.setCapability("deviceName", "ASUS_T00J");
		cap.setCapability("app", "F:\\Appium\\Drag.Sort.Demos.apk");
		cap.setCapability("appackage", "com.mobeta.android.demodslv");
		cap.setCapability("appactivity", ".Launcher");
		cap.setCapability("noReset", false);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}catch(Exception e)
		{
			System.out.println("Exception occured while executing:"+e.toString());
			
		}

	}

	@Test
	public void dragAndDropTest() {

		List<WebElement> headerlist = driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title"));

		headerlist.get(0).click();

		List<WebElement> dragAndDroplist = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		new TouchAction((MobileDriver) driver).longPress(dragAndDroplist.get(0)).moveTo(dragAndDroplist.get(3))
				.release().perform();

	}
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}

}
