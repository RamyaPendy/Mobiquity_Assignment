import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testapp {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramya\\Desktop\\Mobiquity_Assignment\\exe\\chromedriver_win32_Latest\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/");
		driver.manage().window().maximize();

		//UseCase 1 - Log in to application
		
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/label[1]/input")).sendKeys("Luke");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/label[2]/input")).sendKeys("Skywalker");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/button")).click();
		Thread.sleep(2000);
		System.out.println("\n UseCase 1 - Login - PASS");
		
		//UseCase 2 - Read Employee Details
		
		Actions action = new Actions(driver);
		WebElement btnElement=driver.findElement(By.xpath("//*[@id=\"employee-list\"]/li[1]"));
		action.doubleClick(btnElement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"sub-nav\"]/li/a")).click();
		Thread.sleep(2000);
		System.out.println("\n UseCase 2 - Read Employee Details - PASS");
		
		//UseCase 3 - Adding New Employee to the list
		
		driver.findElement(By.xpath("//*[@id=\"bAdd\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input")).sendKeys("Andrew");
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[2]/input")).sendKeys("Peterson");
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[3]/input")).sendKeys("2017-12-31");
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[4]/input")).sendKeys("andrew123@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div/button[2]")).click();
		Thread.sleep(2000);
		System.out.println("\n UseCase 3 - Add New Employee - PASS");
		
		
		//UseCase 4 - Updating Employee Details
		
		btnElement=driver.findElement(By.xpath("//*[@id=\"employee-list\"]/li[1]"));
		action.doubleClick(btnElement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input")).sendKeys(" John");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/form/fieldset/div/button[1]")).click();
		Thread.sleep(3000);
		System.out.println("\n UseCase 4 - Update Empployee details - PASS");
		
		//UseCase 5 - Deleting Employee Details
		
		//Case 1: Selecting cancel on deletion confirmation popup
		driver.findElement(By.xpath("//*[@id=\"employee-list\"]/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"bDelete\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		System.out.println("\n UseCase 5: Case 1 - Cancel Delete - PASS");
		
		//Case 2: Selecting OK on deletion confirmation popup
		driver.findElement(By.xpath("//*[@id=\"employee-list\"]/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"bDelete\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("\n UseCase 5: Case 2 -  Delete Employee - PASS");
		
		//UseCase 6 - Logout from the application
		driver.findElement(By.xpath("/html/body/div/header/div/p[1]")).click();
		System.out.println("\n UseCase 6 - Logout - PASS");
		}
		
		
}
