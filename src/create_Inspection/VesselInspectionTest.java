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

public class VesselInspectionTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	VesselInspection w = new VesselInspection();
	

	 @Test(priority=9)
	  public void VesselInspectionURL() throws Exception {
		 try{
		   test=report.startTest("Vessel Inspection URL");	  
		   w.VesselInspectionURL(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,41,7,pass);
		   write_data.writedata(0,41,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,41,7,fail);
				 write_data.writedata(0,41,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->Vessel Inspection URL"); 
		  System.out.println("Vessel Inspection URL open successfully");
	  }
	 
	/* @Test(priority=10)
	   public void ScheduleInspections() throws Exception {
			 try{
			   test=report.startTest("Schedule Inspections");	  
			   w.ScheduleInspections(driver);
			   Assert.assertTrue(true);
			   write_data.writedata(0,44,7,pass);
			   write_data.writedata(0,44,6,pass);
			   
			   
			 }
			 catch(Exception e){			  
					String exception=e.getMessage();
					 write_data.writedata(0,44,7,fail);
					 write_data.writedata(0,44,6,exception);
					 Assert.assertTrue(false);	
				
			 }		 	 
			   
			  test.log(LogStatus.PASS, "Technical-->Admin-->ScheduleInspections"); 
			  System.out.println("ScheduleInspections successfully");
		  }
	 
 */
 	   @Test(priority=11)
      public void SearchSchedule() throws Exception {
		 try{
		   test=report.startTest("SearchSchedule");	  
		   w.SearchSchedule(driver);
		   Assert.assertTrue(true);
		   write_data.writedata(0,51,7,pass);
		   write_data.writedata(0,51,6,pass);
		   
		   
		 }
		 catch(Exception e){			  
				String exception=e.getMessage();
				 write_data.writedata(0,51,7,fail);
				 write_data.writedata(0,51,6,exception);
				 Assert.assertTrue(false);	
			
		 }		 	 
		   
		  test.log(LogStatus.PASS, "Technical-->Admin-->SearchSchedule"); 
		  System.out.println("Schedule Searched successfully");
	  }
	 
	 	 @Test(priority=12)
	  public void AddJobs() throws Exception {
			 try{
			   test=report.startTest("AddJobs");	  
			   w.AddJobs(driver);
			   Assert.assertTrue(true);
			   write_data.writedata(0,55,7,pass);
			   write_data.writedata(0,55,6,pass);
			   
			   
			 }
			 catch(Exception e){			  
					String exception=e.getMessage();
					 write_data.writedata(0,55,7,fail);
					 write_data.writedata(0,55,6,exception);
					 Assert.assertTrue(false);	
				
			 }		 	 
			   
			  test.log(LogStatus.PASS, "Technical-->Admin-->AddJobs"); 
			  System.out.println("Jobs Added successfully");
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
