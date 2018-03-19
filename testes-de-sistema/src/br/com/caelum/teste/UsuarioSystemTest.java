package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuarioSystemTest {
	private WebDriver driver;

	@Before
	public void inicializa() {
	    	 
	    	System.setProperty("webdriver.gecko.driver", "D:\\Alura\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	        driver = new FirefoxDriver();
	    }

	    @Test	
	public void validarAddUsuario() {
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

			
	}

	@Test
	public void validarAddUsuarioNomeObrigatorio() {
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement email = driver.findElement(By.name("usuario.email"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		
		email.sendKeys("usuario2@com.com.br");
		botaoSalvar.click();
		
		//Garantir a mensagem apareceu
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

	}
	
	@Test
	public void validarAddUsuarioEmailObrigatorio() {
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		
		nome.sendKeys("Usuario 3 Nome");
		botaoSalvar.click();

		//Garantir a mensagem apareceu
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

	}

	@Test
    public void validarAddUsuarioNomeEmailObrigatorio() {
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));
        email.submit();

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

  
    }
	
	@Test
	public void navegarLink() {
	        driver.get("http://localhost:8080/usuarios");
	        WebElement ligacao = driver.findElement(By.linkText("Novo Usuário"));
	        ligacao.click();        

	        //garantir que abriu pagina de inclusao
	        boolean achouCampoNome = driver.getPageSource().contains("Nome:");
	        boolean achouCampoEmail = driver.getPageSource().contains("E-mail:");

	        assertTrue(achouCampoNome);
	        assertTrue(achouCampoEmail);

	}
	
	
	
	@After
	public void encerra() {
	        driver.close();
	    }
}