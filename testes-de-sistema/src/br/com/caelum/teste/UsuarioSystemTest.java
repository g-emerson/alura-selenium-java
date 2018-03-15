package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuarioSystemTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		
		WebDriver driver2 = new ChromeDriver();
		
		// acessa o site do google
		driver2.get("http://localhost:8080/usuarios/new");
				
		// digita no campo "q" do google
		WebElement campoDeTexto2 = driver2.findElement(By.name("q"));
		campoDeTexto2.sendKeys("Caelum");
		
		// submete o form
		campoDeTexto2.submit();
	}

}
