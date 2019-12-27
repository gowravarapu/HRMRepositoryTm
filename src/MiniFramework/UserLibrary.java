package MiniFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UserLibrary {

	public static FirefoxDriver driver;
	//=============================================//enter url
	public static void driverLaunchApp()
	{
		driver = new FirefoxDriver();
		driver.get("http://testingmasters.com/hrm/");
		driver.manage().window().maximize();
	}
	
	//====================================//user login
	public static void hrmLogin(String usrname,String pswd)
	{
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(usrname);;
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pswd);
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	//======================================//navgateMyLeave Page
	public static void navgateMyLeave()
	{
			WebElement leave=driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
			Actions act=new Actions(driver);
			act.moveToElement(leave).build().perform();
			 driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
			
	}
	
	//================================================//selecting the appropriate check box
	
	
	public static void searchWithLeaveStatus(String LeaveStatus)
	{
		driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']")).click();
		
		switch(LeaveStatus.toUpperCase().trim())
		{
		case "REJECTED":  driver.findElement(By.xpath("//a[@id='leaveList_chkSearchFilter_-1']")).click();
		                                           break;
	    case "CANCELLED": driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_0']")).click();
                                                   break;  
                          
        case "PENDING APPROVAL": driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_1']")).click();
                                                   break;
        case "SCHEDULED": driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_2']")).click();
                                                   break; 
                                              
        case "TAKEN": driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_3']")).click();
                                                   break;                           

		            default:System.out.println("incorrect status");
		
	  }
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();	
	}
//=============================================================================================		
	public static void verifyPendingApprovedOrNot(String LeaveStatus)//verify whether column contain all pendingApproval status or not
		{
		int rows =driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println(rows);
			boolean btag=true;
		for(int i=1;i<rows;i++){
		String expected= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
		if(!(expected.contains("Pending Approval")))
		{
			btag=false;
		}
		}
		
		if(btag)
			System.out.println("pass");
		else
			System.out.println("fail");
	}
	

//=================================================================================================
	//cancel the leave with specified date and whether the status  changed to cancel or not
	public static void CancelLeavesStatusSpecifiedDate(String Date)
	{
		int rows =driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println(rows);
		boolean btag =false;
	 for(int i=1;i<rows;i++)
	  {
		String getdate= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText().trim();
		String Status= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText().trim();
		if((getdate.equals(Date))&&(Status.contains("Pending Approval")))
		{
			btag =true;
			driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]/select/option[text()='Cancel']")).click();
			driver.findElement(By.xpath("//input[@id='btnSave']")).click();
			
			String Status1= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText().trim();
			if((getdate.equals(Date))&&(Status1.contains("Cancelled")))
			{
				System.out.println("Sucess");
			}
			
			else
			{
				System.out.println("fail");	
			}
			break;
	   }


      }
		if(btag==false)
			System.out.println("leave date with pending status not found");	

	}
//==================================================================================================
public static void closeBrowser()
{
	driver.quit();	
}
}