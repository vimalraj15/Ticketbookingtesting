import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ticket {

	@Test
	public void one() {

		System.setProperty("webdriver.chrome.driver", "D:\\hello\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.redbus.in/bus-tickets");

		WebElement drop1 = driver.findElement(By.id("txtSource"));
		drop1.click();
		driver.findElement(By.xpath("//*[@id=\"C120_suggestion-wrap\"]/li[2]")).click();

		WebElement drop2 = driver.findElement(By.id("txtDestination"));
		drop2.click();
		driver.findElement(By.xpath("//*[@id=\"C120_suggestion-wrap\"]/li[1]")).click();
		

		WebElement drop3 = driver.findElement(By.id("txtOnwardCalendar"));
		drop3.click();
		driver.findElement(By.xpath("//*[@id=\"rb-calmiddle\"]/ul[2]/li[24]/span")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button")).click();

		String test = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div")).getText();

		String message = Ticket.test(test);
		System.out.println(message);
	}

	public static String test(String actualdata) {
		String testdata = "As per government guidelines, bus services on this route are temporarily suspended";
		Assert.assertEquals(testdata, actualdata);
		return "No Tickets Opened ,temporarily suspended, Not able book a ticket";
	}
}
