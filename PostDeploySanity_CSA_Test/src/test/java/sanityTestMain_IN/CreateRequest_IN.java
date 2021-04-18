package sanityTestMain_IN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import lib.Excel;
import sanityTest_IN.Step01_CreateRequest_IN;
import sanityTest_US.Step01_CreateRequest_US;


@Listeners(lib.TestNG_Listeners.class)
public class CreateRequest_IN
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
	public void setup()
	{
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

		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, sheet, 3, 2);
		driver.get(url); 
		driver.manage().window().maximize();

	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() 
	{

		Step01_CreateRequest_IN login = new Step01_CreateRequest_IN(driver);
		login.login();
	}
	@Test(priority=1)
	public void Create_Req() 
	{
		Step01_CreateRequest_IN createreq = new Step01_CreateRequest_IN(driver);
		createreq.Create_New_Request();

	}
	@Test(priority=2)
	public void skill_Req() 
	{
		Step01_CreateRequest_IN skillreq = new Step01_CreateRequest_IN(driver);

		skillreq.Skill_Request();

	}
	@Test(priority=3)
	public void select_Req() 
	{Step01_CreateRequest_IN selectreq = new Step01_CreateRequest_IN(driver);
	selectreq.Select_Requestor();

	}

	@Test(priority=4)
	public void select_jrss() 
	{
		Step01_CreateRequest_IN jrss = new Step01_CreateRequest_IN(driver);
		jrss.Select_JRSS();

	}
	@Test(priority=5)
	public void req_detail() 
	{
		Step01_CreateRequest_IN reqdetail = new Step01_CreateRequest_IN(driver);
		reqdetail.Request_detailpage();

	}

	@Test(priority=6)
	public void skill_loc() 
	{Step01_CreateRequest_IN loc = new Step01_CreateRequest_IN(driver);
	loc.Skill_detailLocationpage();

	}
	@Test(priority=7)
	public void alert_check() 
	{
		Step01_CreateRequest_IN alert = new Step01_CreateRequest_IN(driver);
		alert.isAlertPresent();

	}

	@Test(priority=8)
	public void skill_price() 
	{Step01_CreateRequest_IN price = new Step01_CreateRequest_IN(driver);
	price.Skill_detail_skillpricepage();

	}
	@Test(priority=9)
	public void supp() 
	{
		Step01_CreateRequest_IN supplier = new Step01_CreateRequest_IN(driver);
		supplier.SupplierSelectionPage();

	}
	@Test(priority=10)
	public void submitRequest() 
	{

		Step01_CreateRequest_IN sub = new Step01_CreateRequest_IN(driver);
		sub.Submit_Request();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}	
}
