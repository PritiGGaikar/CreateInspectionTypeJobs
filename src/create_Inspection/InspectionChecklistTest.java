package create_Inspection;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common_Function.WebDriverPass;

public class InspectionChecklistTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	InspectionChecklist w = new InspectionChecklist();
	

	 @Test(priority=7)
	  public void InspectionChecklistURL() throws Exception {
		 try{
		   test=report.startTest("Inspection Checklist URL");	  
		   w.InspectionChecklistURL(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,28,7,pass);
		   write_data.writedata(0,28,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,28,7,fail);
				 write_data.writedata(0,28,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Inspection Checklist URL"); 
		  System.out.println("Inspection Checklist URL open successfully");
	  }
	 

	 @Test(priority=8)
	  public void ChecklistDetails() throws Exception {
		 try{
		   test=report.startTest("Checklist Details");	  
		   w.ChecklistDetails(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,31,7,pass);
		   write_data.writedata(0,31,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,31,7,fail);
				 write_data.writedata(0,31,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Inspection Checklist URL"); 
		  System.out.println("Inspection Checklist URL open successfully");
	  }

	 @AfterMethod
	  	public void afterMethod(ITestResult result) {
	  	    if (result.getStatus() == ITestResult.FAILURE) {
	  	        test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
	  	    } else if (result.getStatus() == ITestResult.SKIP) {
	  	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	  	    } else {
	  	        test.log(LogStatus.PASS, "Test passed");
	  	    }
	  	    report.endTest(test);
	  	    report.flush();
	  }
	  @BeforeSuite
	  public void beforeSu() {
	  	  report = QuestionBank.getReporter(path.concat("Report.html"));
	  }

	  @AfterSuite
	  public void afterSu() {
	      report.close();
	  }

}
