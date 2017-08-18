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

public class ChecklistTypeTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	ChecklistType p = new ChecklistType();
	

	 @Test(priority=3)
	  public void ChecklistTypeURL() throws Exception {
		 try{
		   test=report.startTest("Checklit Type URL");	  
		   p.ChecklistTypeURL(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,12,7,pass);
		   write_data.writedata(0,12,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,12,7,fail);
				 write_data.writedata(0,12,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Checklist Type URL"); 
		  System.out.println("Checklist Type URL open successfully");
	  }
	 
	/* 
	 @Test(priority=4)
	  public void AddNewChecklistType() throws Exception {
		 try{
		   test=report.startTest("Add New Checklist Type");	  
		   p.AddNewChecklistType(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,15,7,pass);
		   write_data.writedata(0,15,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,15,7,fail);
				 write_data.writedata(0,15,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Add New Checklist Type"); 
		  System.out.println("Add New Checklist Type executed successfully");
	  }
	 */

	 @Test(priority=5)
	  public void AddNewGrade() throws Exception {
		 try{
		   test=report.startTest("Add New Grade");	  
		   p.AddNewGrade(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,18,7,pass);
		   write_data.writedata(0,18,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,18,7,fail);
				 write_data.writedata(0,18,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Add New Grade"); 
		  System.out.println("Add New Grade executed successfully");
	  }
	 
	 @Test(priority=6)
	  public void AddNewCategory() throws Exception {
		 try{
		   test=report.startTest("Add New Category");	  
		   p.AddNewCategory(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,25,7,pass);
		   write_data.writedata(0,25,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,25,7,fail);
				 write_data.writedata(0,25,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Add New Category"); 
		  System.out.println("Add New Category executed successfully");
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
