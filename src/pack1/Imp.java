package pack1;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Imp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();

		
		driver.get("http://testingmasters.com/register/");
		
		driver.findElement(By.xpath("//select[@name='menu-123']/option[.='Manual Testing']")).click();
		                              //OR
		driver.findElement(By.xpath("//select[@name='menu-123']/option[contains(text(),'Testing')]")).click();
		                              //OR
		driver.findElement(By.xpath("//select[@name='menu-123']/option[3]")).click();
		                                //OR
		driver.findElement(By.xpath("//select[@name='menu-123']/option[contains(.,'Testing')]")).click();
		
		Thread.sleep(2000);
			
	
	
	}

}
