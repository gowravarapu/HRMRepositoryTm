package MiniFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
FirefoxDriver driver= new FirefoxDriver();
driver.get("http://testingmasters.com/hrm/");
driver.manage().window().maximize();

driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("user02");

driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("TM1234");

driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
/*
WebElement leave=driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));

Actions act=new Actions(driver);

act.moveToElement(leave).build().perform();

driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
 
 driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']")).click();
 driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_1']")).click();
 driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
 int rows =driver.findElements(By.xpath("//table/tbody/tr")).size();
 System.out.println(rows);
	
 boolean btag=true;
	for(int i=1;i<rows;i++){
	String expected= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
	if(!(expected.startsWith("Pending")))
	{
		btag=false;
		System.out.println("You failed at line number"+i);
		break;
	}
	}
	
	if(btag)
		System.out.println("pass");
	else
		System.out.println("fail");
}

*/
//========================================================================================================================
/*int rows =driver.findElements(By.xpath("//table/tbody/tr")).size();
System.out.println(rows);
boolean btag =false;
for(int i=1;i<rows;i++)
{
String date= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText().trim();
String Status= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText().trim();
if((date.equals("2019-10-25"))&&(Status.contains("Pending Approval")))
{
	btag =true;
	driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]/select/option[text()='Cancel']")).click();
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	
	String Status1= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText().trim();
	if((date.equals("2019-10-25"))&&(Status1.contains("Cancelled")))
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
}}
*/
//=====================================================================================================================

//check whether data is inserted sucessfully or not in DEPENDENTS page
WebElement leave=driver.findElement(By.xpath("//a[.='My Info']"));
leave.click();
driver.findElement(By.xpath("//li/a[.='Dependents']")).click();
driver.findElement(By.xpath("//input[@id='btnAddDependent']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='dependent_name']")).sendKeys("dimond");
driver.findElement(By.xpath("//select[@id='dependent_relationshipType']/option[.='Child']")).click();
WebElement dependent=driver.findElement(By.xpath("//input[@id='dependent_dateOfBirth']"));
dependent.clear();
dependent.sendKeys("1997-08-09");
dependent.sendKeys(Keys.ESCAPE);
driver.findElement(By.xpath("//input[@id='btnSaveDependent']")).click();
int dsize=driver.findElements(By.xpath("//table/tbody/tr")).size();
System.out.println(dsize);
boolean btag=false;
 for(int i=1;i<=dsize;i++)
 {
	 String names=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
	 
	 if(names.contains("dimond"))
	 {
		  btag=true;
		 
		  break;
	 }
}
if(btag)
 System.out.println("data inserted suceesfully");
else
	System.out.println("data not inserted suceesfully");	}}





