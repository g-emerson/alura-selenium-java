import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteAutomatizado {
	
	//
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Alura\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		
		//Abre firefox
		WebDriver driver = new FirefoxDriver();
				
		// acessa o site do google
		driver.get("http://www.google.com.br");
		
		// digita no campo "q" do google
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		
		// submete o form
		campoDeTexto.submit();
		
		driver.get("http://www.bing.com");
		
		 //digita no campo "q" do google
		campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
				
		// submete o form
		campoDeTexto.submit();
		
		//-------------------
		WebDriver driver2 = new ChromeDriver();
		
		// acessa o site do google
		driver2.get("http://www.google.com.br");
				
		// digita no campo "q" do google
		WebElement campoDeTexto2 = driver2.findElement(By.name("q"));
		campoDeTexto2.sendKeys("Caelum");
		
		// submete o form
		campoDeTexto2.submit();
	}
}
