package sanityTestMain_US;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import lib.Excel;
import lib.SendEmail;
import sanityTest_US.Step01_CreateRequest_US;

@Listeners(lib.TestNG_Listeners.class)
public class CreateRequest_US
{
	// TestNG logger

	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;


	public WebDriver driver;


	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");

		// to run Firefox in Headless mode
		FirefoxOptions op=new FirefoxOptions();
		op.setHeadless(false);
		driver=new FirefoxDriver(op);

		//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SanjayKushwaha\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
		driver.get(url);  
		driver.manage().window().maximize();
	}

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() 
	{

		Step01_CreateRequest_US login = new Step01_CreateRequest_US(driver);
		login.login();

	}
	@Test(priority=1)
	public void Create_Req() 
	{

		Step01_CreateRequest_US createreq = new Step01_CreateRequest_US(driver);
		createreq.Create_New_Request();
	}
	/*	@Test(priority=2)
	public void skill_Req() 
	{

		Step01_CreateRequest_US skillreq = new Step01_CreateRequest_US(driver);
		skillreq.Skill_Request();
	}
	@Test(priority=3)
	public void select_Req() 
	{

		Step01_CreateRequest_US selectreq = new Step01_CreateRequest_US(driver);
		try {
			selectreq.Select_Requestor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=4)
	public void select_jrss() 
	{

		Step01_CreateRequest_US jrss = new Step01_CreateRequest_US(driver);
		jrss.Select_JRSS();
	}

	@Test(priority=5)
	public void req_detail() 
	{

		Step01_CreateRequest_US reqdetail = new Step01_CreateRequest_US(driver);
		reqdetail.Request_detailpage();
	}
	@Test(priority=6)
	public void skill_loc() 
	{

		Step01_CreateRequest_US skillloc = new Step01_CreateRequest_US(driver);
		skillloc.Skill_detailLocationpage();
	}
	@Test(priority=7)
	public void alert_check() 
	{

		Step01_CreateRequest_US alertchk = new Step01_CreateRequest_US(driver);
		alertchk.isAlertPresent();
	}
	@Test(priority=8)
	public void skill_price() 
	{

		Step01_CreateRequest_US skillprice = new Step01_CreateRequest_US(driver);
		skillprice.Skill_detail_skillpricepage();
	}
	@Test(priority=9)
	public void supp() throws InterruptedException 
	{

		Step01_CreateRequest_US supplier = new Step01_CreateRequest_US(driver);
		supplier.SupplierSelectionPage();
	}
	@Test(priority=10)
	public void submitRequest() 
	{

		Step01_CreateRequest_US sub = new Step01_CreateRequest_US(driver);
		sub.Submit_Request();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
	@AfterSuite
	public void TriggerMail(ITestContext context) throws InterruptedException, MalformedURLException, EmailException {
		{
			IResultMap ls =context.getFailedTests();
			int size=ls.size();
			if(size>=1)
			{
				SendEmail.FailureMailWithAttach();
				System.out.println("Email for test results sent successfully");
			}
			else 
			{	
				SendEmail.PassMailWithAttach();
				System.out.println("Email for test results sent successfully");
			} 

		}
	}*/


}


