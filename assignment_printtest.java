package forall_selenium_assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_printtest {

	public static void main(String[] args) {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.cleartrip.com/");
		driver.manage().window().maximize();

		String parent = driver.getWindowHandle();

		Set<String> popups = driver.getWindowHandles();
		{
			Iterator<String> it = popups.iterator();
			while (it.hasNext()) {

				String popupHandle = it.next().toString();
				if (!popupHandle.contains(parent)) {
					driver.switchTo().window(popupHandle);
					System.out.println("Popu Up Title: " + driver.switchTo().window(popupHandle).getTitle());
					driver.close();
				}
			}
		}

		// select todays date in calendar
		driver.findElement(By.id("DepartDate")).click();

		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active ")).click();

//select number in 1st dropdown 

		WebElement adult = driver.findElement(By.id("Adults"));

		Select dropd1 = new Select(adult);

		dropd1.selectByIndex(4);

//select number in 2nd dropdown 

		WebElement children = driver.findElement(By.id("Childrens"));

		Select dropd2 = new Select(children);

		dropd2.selectByIndex(4);

		driver.findElement(By.xpath("//a[@title='More search options']")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Airindia");

		driver.findElement(By.id("SearchBtn")).click();

//Print error message in red

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}