package com.orangehr.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/AutomationReport.html");
		extent.attachReporter(spark);
	}

	@BeforeMethod
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(2000, 100));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test Failed");
		}
		driver.quit();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	public void createTest(String testName) {
		test = extent.createTest(testName);
	}

}
