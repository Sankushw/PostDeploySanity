package sanityTest_IN;

import lib.Excel;
import lib.Screenshots;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step01_CreateRequest_IN {

	private WebDriver driver;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src/test/resources\\testdata.xls";
	public String sheet="Login";

	//@FindBy ( xpath="//Form[@name='searchResultsCandidatesForm']/table") private WebElement Table1 ;
	//@FindAll({@FindBy(name="tblcolCandId")}) private List<WebElement>  Select_Checkbox ;
	@FindAll({@FindBy(xpath="//Form[@name='searchResultsCandidatesForm']/table/tbody/tr")}) private List<WebElement> Table ;
	//@FindAll({@FindBy(tagName="tr")}) private List<WebElement> Table ;
	@FindBy ( xpath="//h3[contains(text(), 'Status legend')]") private WebElement legend ;

	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy ( id="btn_signin") private WebElement Signin_Button ;
	@FindBy ( xpath=".//*[@id='desktop']") private WebElement Username_Box ;
	@FindBy ( xpath=".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement Password_Box ;

	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;

	//Skill Request Page	
	@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
	@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
	@FindBy (name = "btnContinue") private WebElement Continue ;

	//Select Requestor
	@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
	@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;

	// Job Role/Skill
	@FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
	@FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
	@FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;

	//Project Creation
	@FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
	@FindBy ( id="FLD_CONTACT_NAME") private WebElement Customer_Name;
	@FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
	@FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
	@FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
	@FindBy ( id="FLD_CLIENT") private WebElement Client ;
	@FindBy ( id="FLD_BRAND") private WebElement Brand ;
	@FindBy ( id="FLD_SECTOR") private WebElement Sector ;
	@FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
	@FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
	@FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
	@FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
	@FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
	@FindBy ( xpath = ".//*[@name='btnAddContingentMgr']")  private WebElement Project_Task_Manager_AddButton ;
	@FindBy ( xpath = ".//*[@id='FLD_IS_TIME_APPROVAL_TASK1']")  private WebElement Will_Manager_perform_TimeApproval_Yes ;
	@FindBy ( xpath = ".//*[@id='FLD_IS_TIME_APPROVAL_TASK0']")  private WebElement Will_Manager_perform_TimeApproval_No ;
	@FindBy ( xpath = ".//*[@name='btnAddTimeApprovalMgr']")  private WebElement TimeApproverID_AddButton ;

	@FindBy ( xpath = ".//*[@name='FLD_EMP_WEB_ID']")  private WebElement Email_Id_TextBox ;
	@FindBy ( xpath = ".//*[@name='BTN_GO']")  private WebElement GoButton ;
	@FindBy (xpath = ".//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
	@FindBy ( xpath = ".//input[@name='TEMP TIME APPROVER BUTTON']")  private WebElement UseAsTimeApprover_Button ;
	@FindBy ( xpath = ".//input[@name='TEMP MANAGER FOR CR BUTTON']")  private WebElement UseAsManager_Button ;


	//Skill detail Location
	@FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
	@FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
	@FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
	@FindBy ( name="Continue" ) private WebElement Continue_2 ;
	@FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
	@FindBy (xpath = ".//*[@id='FLD_ABOVE_MATRIX_RATES']") private WebElement Above_Matrix_Rate;


	//Skill detail skill price
	@FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	@FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	@FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	@FindBy (xpath =".//*[@id='FLD_ST']") private WebElement ST_time;
	@FindBy ( xpath= ".//h3[contains(text(),'Supplier warning' )]") private WebElement SuppWarning_header;

	//Skill Summary Page
	@FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;

	//Review Skill request
	@FindBy (name = "Submit request") private WebElement SubmitRequest;

	//Request Created
	@FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated_Header;
	@FindBy ( xpath= ".//a[contains(text(),'Return to request')]") private WebElement Return2request;

	//special way of writing  xpath
	//@FindBy (xpath ="//input[@name='Submit' and contains (@onclick,'"+U22SR8+"')]") private WebElement ST_timeaa;


	// Initialize the web elements 
	public Step01_CreateRequest_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	// Function to login to the application
	public void login(){

		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(loginToContractor_Link));
		loginToContractor_Link.click();
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Signin_Button));

		Username_Box.clear();
		Username_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 3, 0));
		Password_Box.clear();
		Password_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 3, 1));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		//Taking screenshot
		/*	Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();*/

		Signin_Button.click();

	}
	//Create Request
	public void Create_New_Request()
	{
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));

		Create_New_Request.click();
		System.out.println("clicked create request");
	}
	//Skill Request Page
	public void Skill_Request(){

		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));

		New_Request.click();
		Time_Materials.click();
		//Taking screenshot
		/*Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();*/

		Continue.click();

	}

	//Select Requestor Page
	public void Select_Requestor(){

		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Requesting_Company));

		String RC = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 0);
		String RO = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 1);  

		Select Rcom = new Select(Requesting_Company);
		Rcom.selectByVisibleText(RC);

		Select Rog = new Select(Requesting_Organization);
		Rog.selectByVisibleText(RO);

		//Taking screenshot
		/*Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();*/
		Continue.click();		
	}

	//JRSS
	public void Select_JRSS()

	{

		WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Priced_JRSS)); 

		Priced_JRSS.click();	

		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Select_JobRole));	

		String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 2);
		String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 3); 

		Select JRlistbox = new Select(Select_JobRole);
		JRlistbox.selectByVisibleText(JR);

		Select SSlistbox = new Select(Select_SkillSet);
		SSlistbox.selectByVisibleText(SS);

		//Taking screenshot 
		/*	Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();*/
		Continue.click();

	}

	//request details
	public void Request_detailpage()

	{
		WebDriverWait wait22 = new WebDriverWait(driver, 160);
		wait22.until(ExpectedConditions.visibilityOf(Project_Name));

		Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 4));
		Customer_Name.sendKeys("Test_CustName123&@#");
		GlobalResource_No.click();
		Govt_FederalContract.click();
		Project_Task_Manager_AddButton.click();
		String ParentWindowId=driver.getWindowHandle();

		//calling SwitchWindow method
		SwitchWindow(ParentWindowId);

		WebDriverWait wait8 = new WebDriverWait(driver, 160);
		wait8.until(ExpectedConditions.visibilityOf(Email_Id_TextBox)); 
		Email_Id_TextBox.sendKeys("csatestus1@c25a0161.toronto.ca.ibm.com");                                                                     
		GoButton.click();
		WebDriverWait wait07 = new WebDriverWait(driver, 180);
		wait07.until(ExpectedConditions.visibilityOf(Name));
		Name.click();
		WebDriverWait wait08 = new WebDriverWait(driver, 180);
		wait08.until(ExpectedConditions.visibilityOf(UseAsManager_Button));
		UseAsManager_Button.click();

		//Switching to Parent window i.e Main Window.
		driver.switchTo().window(ParentWindowId);

		WebDriverWait wait10 = new WebDriverWait(driver, 160);
		wait10.until(ExpectedConditions.visibilityOf(Continue)); 

		String clientValue = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 5);
		String brandValue = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 6); 
		String sectorValue = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 7);
		String industryValue = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 8); 

		Select clientdropdown = new Select(Client);
		clientdropdown.selectByVisibleText(clientValue);

		Select branddropdown = new Select(Brand);
		branddropdown.selectByVisibleText(brandValue);

		Select sectordropdown = new Select(Sector);
		sectordropdown.selectByVisibleText(sectorValue);

		Select industrydropdown = new Select(Industry);
		industrydropdown.selectByVisibleText(industryValue);

		Accounting_Type.click();
		//Taking screenshot
		Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();
		Continue.click();
	}

	//skill detail Page
	public void Skill_detailLocationpage()

	{

		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(State_Region_Province)); 

		Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Karnataka");

		Select ct = new Select(City);
		ct.selectByVisibleText("BANGALORE");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Continue_2.click();
	}

	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			driver.switchTo().alert().accept();
			return true;


		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
		//driver.switchTo().alert().accept();
	}

	//above matrix rate confirmation and Skill detail skill price
	public void Skill_detail_skillpricepage()

	{

		WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Skill_Level));

		String SL_Value = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 12); 

		Select SLDropdown = new Select(Skill_Level);
		SLDropdown.selectByVisibleText(SL_Value);

		Quantity.clear();
		driver.switchTo().alert().accept();
		Quantity.sendKeys("3");
		ST_time.clear();
		driver.switchTo().alert().accept();
		ST_time.sendKeys("12");
		Above_Matrix_Rate.click();
		Continue_2.click();

	}
	//Supplier Selection Page
	public void SupplierSelectionPage()
	{   

		WebDriverWait wait9 = new WebDriverWait(driver, 160);
		wait9.until(ExpectedConditions.visibilityOf(Continue));

		//Taking screenshot
		Screenshots shot4=new Screenshots(driver);
		shot4.ScreenShot_IN();
		Continue.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(SuppWarning_header));

		Continue.click();
	}
	public void Submit_Request()
	{
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));

		//Taking screenshot
		Screenshots shot6=new Screenshots(driver);
		shot6.ScreenShot_IN();
		ContinueToRequestSummary.click();

		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));

		//Taking screenshot
		Screenshots shot7=new Screenshots(driver);
		shot7.ScreenShot_IN();
		SubmitRequest.click();

		WebDriverWait wait11 = new WebDriverWait(driver, 160);
		wait11.until(ExpectedConditions.visibilityOf(Return2request));
		String header=RequestCreated_Header.getText();
		System.out.println("header= "+header);
		System.out.println("header length= "+header.length());

		String RequestNumber = header.substring((header.length()-7),(header.length()-1) );
		System.out.println("REQUEST Number= "+RequestNumber);
		Excel.setCellValue(xlsFilePath, "Request_creation", 3, 15, RequestNumber );

		//Taking screenshot
		Screenshots shot8=new Screenshots(driver);
		shot8.ScreenShot_IN();
	}
	public void SwitchWindow(String ParentWindowId)
	{

		String MainWindow=ParentWindowId;
		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		

		while(i1.hasNext())			
		{		
			String ChildWindow=i1.next();		

			if(!MainWindow.equalsIgnoreCase(ChildWindow))			
			{    		
				System.out.println("Window handler Id of Parent window= "+MainWindow);
				System.out.println("Window handler Id of Child window= "+ChildWindow);

				// Switching to Child window
				driver.switchTo().window(ChildWindow);	
			}		
		}

	}
}
