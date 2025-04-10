package plum;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://plum-labs-web.vercel.app/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("testnew@gmail.com");
		driver.findElement(By.id("password")).sendKeys("143sunil@Pune");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement svgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']/*[name()='circle'][1]")));
WebElement svg=		driver.findElement(By.xpath("//*[name()='svg']/*[name()='circle'][1]"));
svg.click();
driver.findElement(By.xpath("//div[normalize-space()='PLUM Vision']")).click();
 
 
WebElement fileelement=driver.findElement(By.xpath("//img[@alt='xlsx']"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", fileelement);    //click on img
//fileelement.click();
 
Robot rb=new Robot();
rb.delay(2000);
 
StringSelection ss=new StringSelection("C:\\Users\\Admin\\Downloads\\portfolio_updated 1 2");
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
 
//ctr v action
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_V);
 
rb.keyRelease(KeyEvent.VK_CONTROL);
rb.keyRelease(KeyEvent.VK_V);
 
rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
 
//SELECTION OF DATE
WebElement strtdate=driver.findElement(By.xpath("//input[@placeholder='Start Date']"));
Thread.sleep(5000);
 
strtdate.click();
strtdate.sendKeys("2024/06/01");
WebElement enddate=driver.findElement(By.xpath("//input[@placeholder='End Date']"));
enddate.sendKeys("2024/06/30");
enddate.sendKeys(Keys.ENTER);
driver.findElement(By.xpath("//div[contains(@class,'_playBtnDiv')]")).click();
WebElement source1=driver.findElement(By.xpath("//div[contains(text(),'Asset Allocation')]/parent::div"));
WebElement destination1=driver.findElement(By.xpath("//div[@class='_dropChartContainer_pl9cj_11']"));
Actions actions = new Actions(driver);
actions.dragAndDrop(source1, destination1).perform();
 Thread.sleep(10000);
//drag and drop2
WebElement source2=driver.findElement(By.xpath("//div[contains(text(),'Asset Performance')]/parent::div"));
WebElement destination2=driver.findElement(By.xpath("//div[contains(@class,'_chartContainer_')]"));
actions.dragAndDrop(source2, destination2).perform();
 
Thread.sleep(2000);
//WebElement source3=driver.findElement(By.xpath(" (//*[name()='svg'][@stroke='currentColor'])[6]"));
//actions.dragAndDrop(source3, destination2);
 
 
		
	}
}
