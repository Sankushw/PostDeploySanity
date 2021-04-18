package sanityTestMain_GB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import lib.Excel;
import sanityTest_GB.Step01_CreateRequest_GB;


@Listeners(lib.TestNG_Listeners.class)
public class CreateRequest_GB
{
	// TestNG logger

	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;


	@BeforeClass
	public void setup(){

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");

		// to run Firefox in Headless mode--->both below methods are working
		/*FirefoxBinary firefoxBinary =new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions fo=new FirefoxOptions();
		fo.setBinary(firefoxBinary);
		driver = new FirefoxDriver(fo);*/

		// to run Firefox in Headless mode
		FirefoxOptions op=new FirefoxOptions();
	    op.setHeadless(false);
	    driver=new FirefoxDriver(op);
	  
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SanjayKushwaha\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);
		driver.get(url);  
		driver.manage().window().maximize();
		
	}	

	// test to Login to the application as RIPC

	@Test(priority=0)
	public void RIPC_Login() 
	{

		Step01_CreateRequest_GB login = new Step01_CreateRequest_GB(driver);
		login.login();
	}
	@Test(priority=1)
	public void Create_Req() 
	{

		Step01_CreateRequest_GB createreq = new Step01_CreateRequest_GB(driver);
		createreq.Create_New_Request();
	}
	@Test(priority=2)
	public void skill_Req() 
	{

		Step01_CreateRequest_GB skillreq = new Step01_CreateRequest_GB(driver);
		skillreq.Skill_Request();
	}
	@Test(priority=3)
	public void select_Req() 
	{

		Step01_CreateRequest_GB selectreq = new Step01_CreateRequest_GB(driver);
		selectreq.Select_Requestor();
	}

	@Test(priority=4)
	public void select_jrss() 
	{

		Step01_CreateRequest_GB selectreq = new Step01_CreateRequest_GB(driver);
		selectreq.Select_JRSS();
	}

	@Test(priority=5)
	public void req_detail() 
	{

		Step01_CreateRequest_GB reqdetail = new Step01_CreateRequest_GB(driver);
		reqdetail.Request_detailpage();
	}
	@Test(priority=6)
	public void skill_loc() 
	{

		Step01_CreateRequest_GB skillloc = new Step01_CreateRequest_GB(driver);
		skillloc.Skill_detailLocationpage();
	}
	@Test(priority=7)
	public void alert_check() 
	{

		Step01_CreateRequest_GB alertchk = new Step01_CreateRequest_GB(driver);
		alertchk.isAlertPresent();
	}
	@Test(priority=8)
	public void skill_price() 
	{

		Step01_CreateRequest_GB skillprice = new Step01_CreateRequest_GB(driver);
		skillprice.Skill_detail_skillpricepage();
	}
	@Test(priority=9)
	public void supp() throws InterruptedException 
	{

		Step01_CreateRequest_GB supplier = new Step01_CreateRequest_GB(driver);
		supplier.SupplierSelectionPage();
	}
	@Test(priority=10)
	public void submitRequest() 
	{

		Step01_CreateRequest_GB sub = new Step01_CreateRequest_GB(driver);
		sub.Submit_Request();
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
}

