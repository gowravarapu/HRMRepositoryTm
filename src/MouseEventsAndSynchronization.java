import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseEventsAndSynchronization {

	public static void main(String[] args) throws Exception {
		
        //hi vasu
         //System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
         //ChromeDriver driver=new ChromeDriver();
		FirefoxDriver driver=new FirefoxDriver();
        // driver.get("http://www.jqueryui.com");
         driver.navigate().to("http://www.jqueryui.com");
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[.='Droppable']")).click();
         WebElement dframe= driver.findElement(By.className("demo-frame"));
         driver.switchTo().frame(dframe);
         
         WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
         WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
          
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
        
        
        Actions obj=new Actions(driver);
       // obj.dragAndDrop(source, target).build().perform();
          obj.clickAndHold(source).moveToElement(target).release().build().perform();
        boolean isdisplay=driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed();
        
        if(isdisplay)
        {
        	System.out.println("dropped sucessfully");
        }
        else
        {
        	throw new Exception("not dropped");
        }
        
        driver.switchTo().defaultContent();
        
        driver.findElement(By.xpath("//a[.='Droppable']")).click();
        
        driver.quit();
        
	}

}
