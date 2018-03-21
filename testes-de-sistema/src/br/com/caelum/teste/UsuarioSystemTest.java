package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuarioSystemTest {

	private WebDriver driver;
    private UsuariosPage usuarios;

    @Before
    public void inicializa() {
    	//Abrindo pelo firefox
    	//System.setProperty("webdriver.gecko.driver", "D:\\Alura\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        //this.driver = new FirefoxDriver();
        //Abrindo pelo Chrome
        System.setProperty("webdriver.chrome.driver","D:\\Alura\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        this.usuarios = new UsuariosPage(driver);
    }

    @Test
    public void deveAdicionarUmUsuario() {
        usuarios.visita();
        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");

        assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
    }
    
    @Test
    public void deveExcluirUsuario() {
        usuarios.visita();
        usuarios.novo().cadastra("Usuario Excluir", "apagar@apa.gar");

        assertTrue(usuarios.existeNaListagem("Usuario Excluir", "apagar@apa.gar"));
        
        usuarios.apagarUsuario(1);
        assertFalse(usuarios.existeNaListagem("Usuario Excluir", "apagar@apa.gar"));  
    }
    
    @Test
    public void deveEditarrUsuario() {
        usuarios.visita();
        usuarios.novo().cadastra("Usuario Editar", "editar@edi.tar");

        assertTrue(usuarios.existeNaListagem("Usuario Editar", "editar@edi.tar"));        
        
        usuarios.editaUsuario(1).editar("Usuario Editado", "editado@edita.do");
        assertFalse(usuarios.existeNaListagem("Usuario Editar", "editar@edi.tar"));
        assertTrue(usuarios.existeNaListagem("Usuario Editado", "editado@edita.do"));     
    }    

    @After
    public void encerra() {
        driver.close();
    }
}
