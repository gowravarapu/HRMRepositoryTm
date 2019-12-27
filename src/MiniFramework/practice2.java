package MiniFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class practice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://testingmasters.com/hrm/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("user02");

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("TM1234");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement leave=driver.findElement(By.xpath("//a[.='My Info']"));
		leave.click();
		driver.findElement(By.xpath("//li/a[.='Dependents']")).click();
		driver.findElement(By.xpath("//input[@id='btnAddDependent']")).click();
		
		Thread.sleep(2000);
		
		
		
		
		int dsize=driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println(dsize);
		boolean btag=false;
		 for(int i=1;i<=dsize;i++)
		 {
			 String names=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
			 
			 if(!(names.contains("dimond")))
			 {
				 btag=true;
				 driver.findElement(By.xpath("//input[@id='dependent_name']")).sendKeys("dimond");
				 driver.findElement(By.xpath("//select[@id='dependent_relationshipType']/option[.='Child']")).click();
				 WebElement dependent=driver.findElement(By.xpath("//input[@id='dependent_dateOfBirth']"));
				 dependent.clear();
				 dependent.sendKeys("1997-08-09");
				 dependent.sendKeys(Keys.ESCAPE);
				 driver.findElement(By.xpath("//input[@id='btnSaveDependent']")).click();
				 
			 }
			 
			 else{
				 System.out.println("data already present");
				 
				 
			 }
			 
		
			 
		 }
		
		 if(btag)
				
				System.out.println("data inserted sucessfully");
			 


	}

}
