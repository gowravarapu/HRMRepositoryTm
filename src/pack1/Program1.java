package pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Program1 {
@Test
	public static void main() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String actual=driver.getTitle();
		String expected="OrangeHRM";
		driver.get("http://testingmasters.com/hrm/");
		SoftAssert sassert= new SoftAssert();
		sassert.assertEquals(actual, expected,"orange hrm page not found");
		System.out.println("page1..............");
		
		sassert.assertAll();

	}

@Test
public static void main1() 
{
	System.out.println("page..............");
}

}
