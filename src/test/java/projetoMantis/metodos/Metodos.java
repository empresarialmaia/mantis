package projetoMantis.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projetoMantis.driver.Driver;

public class Metodos extends Driver {	
	
		
	public static void abrirNavegador(String tipo) {
	
		String url = "http://mantis-prova.base2.com.br/";
		
		if (tipo.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (tipo.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (tipo.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.get(url);

	}

	public static void fecharNavegador( ) {	
        driver.quit();
    }
	
	
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
		
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
		
	}
	
	public void validarTitle( String titleDesejado) {
		assertEquals(driver.getTitle(), titleDesejado);
		
		
	}
	
	public void validarUrl(String urlEsperada) {
		assertEquals(driver.getCurrentUrl(), urlEsperada);
		
	}
	
	public void printTela(String historia, String nomeDoArquivo) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./evidencias/" + historia + "/" + nomeDoArquivo + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public void aguardarElementoVisivel(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		
	}
	
	public void validarTexto(By elemento, String textoEsperado) {
		String textoCapturado = driver.findElement(elemento).getText();
		assertTrue(textoCapturado.contains(textoEsperado));
		
	}
	
	

}
	
	
