package pack1;


import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxDriver driver= new FirefoxDriver();
		
		driver.get("http://testingmasters.weebly.com/webtables.html");
		
		//assertion excepted and actual
		
		String tittle=driver.getTitle();
		String expected="TestingMastersPage";
		System.out.println(tittle);
		Assert.assertEquals(tittle,expected);
		
	//Adding names to list whose names is vinod
		
		List<WebElement> names=  driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'Vinod')]"));
		System.out.println(names.size());
		List<String> all_elements_text=new ArrayList<>();
		for(int i=0; i<names.size(); i++){
			all_elements_text.add(names.get(i).getText());
			System.out.println(names.get(i).getText());
			}
		
	//clicking whose names id s148111	
		
		driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'S148111')]/preceding-sibling::td")).click();
		Thread.sleep(2000);
		
//Getting only the analyst phone numbers		

List<WebElement> phn=  driver.findElements(By.xpath("//table/tbody/tr/td[5][contains(text(),'Analyst' )]/following-sibling::td[1]"));
System.out.println(phn.size());
List<String> phnnos=new ArrayList<>();
for(int i=0; i<phn.size(); i++){
	phnnos.add(phn.get(i).getText());
	System.out.println(phn.get(i).getText());
	}

driver.quit();
	}
	
}
