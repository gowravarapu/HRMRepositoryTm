package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/gowra/OneDrive/Desktop/popup.html");
		driver.findElement(By.xpath("//button")).click();
		driver.switchTo().alert();
		String str=driver.switchTo().alert().getText();
		
		System.out.println(str);
		
		driver.switchTo().alert().dismiss();
		
	}

}
