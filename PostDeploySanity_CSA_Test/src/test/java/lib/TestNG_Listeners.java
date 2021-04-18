package lib;

import java.awt.List;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IFactoryAnnotation;

public class TestNG_Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Listners:starting test execution for method= "+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Listners:Test execution passed for method= "+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Listners:Test execution failed for method= "+result.getName());

		/*if (result.getStatus()==ITestResult.FAILURE)
		{		SendEmail.FailureMailWithAttach();
				System.out.println("Email for test results sent successfully");
		}*/

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Listners:Test execution skipped for method= "+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Listners:onStart= "+context.getName()+"  -->test started");

	}

	public void onFinish(ITestContext context)
	{
		System.out.println("Listners:onfinish = "+context.getName()+"  -->test finished");
		/*IResultMap ls =context.getFailedTests();
		int size=ls.size();
		if(size>=1)
		{
			try {
				SendEmail.FailureMailWithAttach();
				System.out.println("Email for test results sent successfully");
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (EmailException e) {

				e.printStackTrace();
			}
		}
		else 
		{	
			try {
				SendEmail.PassMailWithAttach();
				System.out.println("Email for test results sent successfully");
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (EmailException e) {

				e.printStackTrace();
			}

		}*/
	}



}
