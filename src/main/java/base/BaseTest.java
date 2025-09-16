package base;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

import utils.Constants;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent=new ExtentReports();
	public ExtentTest logger;
@BeforeTest
public void SetupExtentReport()
{
	//String path=System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"freeCRM.html";
	sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"freeCRM.html");
	//extent=new ExtentReports();
	extent.attachReporter(sparkreporter);
	sparkreporter.config().setDocumentTitle("FreeCRM Login Automation");
	sparkreporter.config().setReportName("freeCRM Automation");
	sparkreporter.config().setTheme(Theme.DARK);
	extent.setSystemInfo("Username", "Login");
	
}
@BeforeMethod
@Parameters("Browser")
public void beforeMethod(String brow, Method name)
{
	logger=extent.createTest(name.getName());
	setupDriver(brow);
	driver.get(Constants.url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
}

public void setupDriver(String browser)
{
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();}
	else if(browser.equalsIgnoreCase("fireFox")) {
		driver=new FirefoxDriver();}
	else if(browser.equalsIgnoreCase("Edge")) {
		driver=new EdgeDriver();}
	
	
}
@AfterTest
public void afterTest()
{
	extent.flush();
}
@AfterMethod
public void afteeMethod(ITestResult results)
{
	if(results.getStatus()==ITestResult.FAILURE) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(results.getName() + " - Test Case Failed ", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(results.getThrowable() + " - Test Case Failed ", ExtentColor.RED));}
	if(results.getStatus()==ITestResult.SKIP) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(results.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));}
	if(results.getStatus()==ITestResult.SUCCESS) {
		logger.log(Status.PASS, MarkupHelper.createLabel(results.getName() + " - Test Case PASS ", ExtentColor.GREEN));}
	driver.quit();
		
	}
		
}

