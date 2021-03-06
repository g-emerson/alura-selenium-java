package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {
	private WebDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
    	System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        leiloes = new LeiloesPage(driver);

        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
    }
    @Test
    public void deveCadastrarUmLeilao() {

        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

        assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
    }
    
    @Test
    public void validaCadastrarUmLeilaoSemNome() {

        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("", 122, "Paulo Henrique", true);
        
        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
    }
    
    @Test
    public void validaCadastrarUmLeilaoSemLanceInicial() {

        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Teste", 0, "Paulo Henrique", true);

        assertTrue(driver.getPageSource().contains("Valor inicial deve ser maior que zero!"));
    }    
    
    @After
    public void encerra() {
        driver.close();
    }
}
