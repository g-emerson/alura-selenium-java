package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuarioSystemTest {
	
	@Test
	public void validarAddUsuario() {
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// acessa o site do leil�o
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		nome.sendKeys("Usuario 1 Nome");
		email.sendKeys("usuario1@com.com.br");
		
		// submete o form
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		//Garantir que o user foi inserido
		boolean achouNome =  driver.getPageSource().contains("Usuario 1 Nome");
		boolean achouemail =  driver.getPageSource().contains("usuario1@com.com.br");
		
		assertTrue(achouNome);	
		assertTrue(achouemail);	
		
		driver.close();
			
	}

	
}