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

public class QuestionBankTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	QuestionBank p = new QuestionBank();
	

	 @Test(priority=1)
	  public void QuestionBankURL() throws Exception {
		 try{
		   test=report.startTest("Question Bank URL");	  
		   p.QuestionBankURL(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,2,7,pass);
		   write_data.writedata(0,2,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,2,7,fail);
				 write_data.writedata(0,2,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Alarm Unit URL"); 
		  System.out.println("Question Bank URL open successfully");
	  }
	 
	 
	 @Test(priority=2)
	  public void AddQuestions() throws Exception {
		 try{
		   test=report.startTest("Add Questions");	  
		   p.AddQuestions(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,5,7,pass);
		   write_data.writedata(0,5,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,5,7,fail);
				 write_data.writedata(0,5,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Add Questions"); 
		  System.out.println("Add Questions executed successfully");
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



