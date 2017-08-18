package create_Inspection;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class InspectionChecklist extends RW{
	
		
	

	private static ExtentReports report;
	public synchronized static ExtentReports getReporter(String filePath) { //allow only one thread to access the shared resource,To prevent thread interference.
	    if (report == null) {
	    	report = new ExtentReports(path.concat("Report\\Purchase_Admin_Report.html"));
	        
	        report
	            .addSystemInfo("Host Name", "Priti") //Environment Setup For Report
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
	}



	
	   public void InspectionChecklistURL(WebDriver driver1) throws Exception {
	    	  WebDriver driver = driver1;
	    	  
	    	//  driver.get("http://192.168.1.202/STG_VEKTOR/Technical/Inspection/Checklist.aspx");
	    	
	   	     ArrayList<Row> row= OR_tech.searchSheet("InspectionChecklistURL",0,9);//Functn key,sheetNo.,Column no.// Xpath locator
	   	     ArrayList<Row> row1=input_tech.searchSheet("InspectionChecklistURL", 0,0);//Functn key, sheet no,//test data excel
	   	 	
	   	     //  URL Path Concat
	   	     String input_URL =url.concat(input_tech.getData(0, 29, 4));
	   	     
	   		for(int i=0;i<row.size();i++)
	   			{
	   				String strValue=""; 
	   			
			  for (int j = 0; j < row1.size(); j++) {
				if (row.get(i).getCell(0) != null) {

					if (row1.get(j).getCell(1) != null) {
						if (row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString()) == 0) {
							strValue = row1.get(j).getCell(4).toString();

							switch (row1.get(j).getCell(4).getCellTypeEnum()) {

							case NUMERIC:
								strValue = String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
								break;
							case STRING:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							case BOOLEAN:
								strValue = String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
								break;
							default:
								strValue = row1.get(j).getCell(4).getStringCellValue();
								break;
							}

						}
					}
				}

			}
	   				 

			if (row.get(i).getCell(10) != null) {

				String strControlTypeKey = row.get(i).getCell(10).toString();
			
				if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {

					driver.get(input_URL);
					Thread.sleep(k);

					String actualTitle = driver.getTitle().trim();

					String expectedTitle = " 	Inspection Checklist ".trim();

					Assert.assertEquals(expectedTitle, actualTitle);
					if (expectedTitle.equals(actualTitle)) {
						System.out.println("Title Match");
						Thread.sleep(k);
					} else {
						System.out.println("Title does not Match");
						Thread.sleep(k);

					}

				}

			}
		}
	}
	   	
	      public void ChecklistDetails(WebDriver driver1) throws Exception {  //(priority=34)

	  		WebDriver driver = driver1;
	  		           
	  		 ArrayList<Row> row= OR_tech.searchSheet("ChecklistDetails",0,9);//Functn key,sheetNo.,Column no.// Xpath locator
	  	     ArrayList<Row> row1=input_tech.searchSheet("ChecklistDetails", 0,0);//Functn key, sheet no,//test data excel
	  	 
	  	     
	  	     for(int i=0;i<row.size();i++)
	  			{
	  				String strValue=""; 
	  				String LocatorType=row.get(i).getCell(1).getStringCellValue();
	  				String strControl=row.get(i).getCell(2).getStringCellValue();
	  				 for(int j=0;j<row1.size();j++)
	  				 {
	  					 if(row.get(i).getCell(0)!=null)
	  						{
	  						
	  						 	if(row1.get(j).getCell(1)!=null)
	  							{
	  							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
	  							  {
	  								  strValue=row1.get(j).getCell(4).toString();
	  								  
	  								  switch(row1.get(j).getCell(4).getCellTypeEnum()){
	  								     
	  								     case NUMERIC: 
	  								    	 strValue=String.valueOf(row1.get(j).getCell(4).getNumericCellValue());
	  								    	 break;
	  								     case STRING:
	  								    	 strValue=row1.get(j).getCell(4).getStringCellValue();
	  								    	 break;
	  								     case BOOLEAN:
	  								    	 strValue=String.valueOf(row1.get(j).getCell(4).getBooleanCellValue());
	  								    	 break;
	  								     default:
	  								    	 strValue=row1.get(j).getCell(4).getStringCellValue();
	  								    	 break;
	  								     }
	  								     
	  							  }
	  							}
	  						}
	  				 
	  				 }
	  				 
	  				
	  					
	  				
	  				
	  					
	  					if(row.get(i).getCell(10)!=null)
	  					{
	  							
	  						
	  						String strControlTypeKey=row.get(i).getCell(10).toString();

	  						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
	  							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
	  								click_element(driver, LocatorType, strControl); 
	  								Thread.sleep(k);
	  							}

	  							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
	  								
	  								dropdown(driver, LocatorType, strControl, strValue);
	  								Thread.sleep(k);															
	  							}

	  							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
	  								sendkeys(driver, LocatorType, strControl, strValue); 
	  								Thread.sleep(k);
	  							}

	  							if (strControlTypeKey.compareTo("Alert_accept") == 0) {
	  								click_element(driver, LocatorType, strControl);
	  								Thread.sleep(k);
	  								Alert(driver);
	  								Thread.sleep(k);
	  							}
	  							
	  							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
	  								clear_element(driver, LocatorType, strControl); 																										
	  								Thread.sleep(k);
	  							}

	  							
	  					}
	  			}
	  			}
	  			}
	          
	     
}
