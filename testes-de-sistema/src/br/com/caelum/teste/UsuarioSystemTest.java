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
		
		// acessa o site do leilão
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

	@Test
	public void validarAddUsuarioNomeObrigatorio() {
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// acessa o site do leilão
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement email = driver.findElement(By.name("usuario.email"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		
		email.sendKeys("usuario2@com.com.br");
		botaoSalvar.click();
		
		//Garantir a mensagem apareceu
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

        driver.close();
	}
	
	@Test
	public void validarAddUsuarioEmailObrigatorio() {
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		
		nome.sendKeys("Usuario 3 Nome");
		botaoSalvar.click();

		//Garantir a mensagem apareceu
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

        driver.close();
	}

	@Test
    public void validarAddUsuarioNomeEmailObrigatorio() {
		System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/usuarios/new");
		
        WebElement email = driver.findElement(By.name("usuario.email"));
        email.submit();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

        driver.close();

    }
}