package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	private WebDriver driver;
    private LeiloesPage leiloes;
    private DetalhesDoLeilaoPage lances;

   /* @Before
    public void inicializa() {
    	System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.get("http://localhost:8080/apenas-teste/limpa");

        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
        usuarios.novo().cadastra("José Alberto", "jose@alberto.com");

        leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
    }*/

    @Before
    public void criaCenario() {
    	System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.get("http://localhost:8080/apenas-teste/limpa");
    	
        new CriadorDeCenarios(driver)
            .umUsuario("Paulo Henrique", "paulo@henrique.com")
            .umUsuario("José Alberto", "jose@alberto.com")
            .umLeilao("Paulo Henrique", "Geladeira", 100, false);
        
        leiloes = new LeiloesPage(driver);
        lances = new DetalhesDoLeilaoPage(driver);
    }     
    
    @Test
    public void deveFazerUmLance() {

    	leiloes.detalhes(1);
		lances.lance("José Alberto",150);

        assertTrue(lances.existeLance("José Alberto", 150));
    }
}
