package pack1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {

	public static  void main1() {
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.vce.ac.in/");
		//String actual=driver.getTitle();
	    //String expected="Find a Flight: Mercury Tours:";
		//System.out.println(actual);
		//WebElement ele=driver.findElement(By.name("q"));
		//ele.sendKeys("hello google");
		//ele.sendKeys(Keys.ENTER);
		/*driver.findElementByXPath("//input[@name='userName']").sendKeys("gowravarapu");;
		driver.findElementByXPath("//input[@name='password']").sendKeys("1234");
		driver.findElementByXPath("//input[@name='login']").click();
		String actual=driver.getTitle();
	    String expected="Find a Flight: Mercury Tours:";
		System.out.println(actual);
	    Assert.assertEquals(expected, actual);
		//driver.close();*/
		
               
	}

	

}
