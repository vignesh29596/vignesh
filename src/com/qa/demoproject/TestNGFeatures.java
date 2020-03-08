package com.qa.demoproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGFeatures {
	static WebDriver driver;
	
	@BeforeSuite
	public static void setup()
	{
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public static void appinstall()
	{
		System.out.println("BeforeTest");
	}
		
	@BeforeClass
	public static void readytocode()
	{
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public static void openBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "./src/browserDriver/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	System.out.println("Before Method");
	}
	
	@Test(priority=1, groups="logintest")
	public static void test1()
	{
		System.out.println("test1 is executed");
	}
	
	@Test(priority=2,  dependsOnMethods="test1", groups="searchpagetest")
	public static void test2()
	{
		System.out.println("test2 is executed");
	}
	
	@Test(priority=3, invocationCount=2, groups="homepagetest")
	@Parameters({"password"})
	public static void test3(String password)
	{
		System.out.println("test3 is executed and "+password);
	}
	
	@AfterMethod
	public static void closebrowser()
	{
		driver.quit();
		System.out.println("After Method");
	}

	@AfterClass
	public static void teardown()
	{
		System.out.println("After Class");
	
	}
	
	@AfterTest
	public static void setdown()
	{
		System.out.println("After Test");
	}
	

}
