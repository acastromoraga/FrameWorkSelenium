package frameWorkAutomatizacionA_Castro.automatizacion;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;



public class HumoTrello {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://trello.com/es");
		driver.manage().window().maximize();
//		String nombrePag = Function.obtenerNombrePag(driver);
		Thread.sleep(3000);
		WebElement inicioSesion = driver.findElement(By.xpath(" //*[@href='/signup']//preceding::a[@href='/login']"));
		inicioSesion.click();
		Thread.sleep(3000);
		WebElement user = driver.findElement(By.id("user"));
		if (user.isDisplayed()) {
			user.sendKeys("testTrelloTecnova@gmail.com");
		} else {
			System.out.println("No se encuentra campo usuario");
		}
		
		Thread.sleep(3000);
		WebElement btniniciosesion1 = driver.findElement(By.xpath("//input[@type='submit']"));
		if (btniniciosesion1.isDisplayed()) {
			btniniciosesion1.click();
		}
	
		WebElement pass = driver.findElement(By.id("password"));
		if (pass.isDisplayed()) {
			pass.sendKeys("trello123");
		}
		
		WebElement btniniciosesion = driver.findElement(By.className("css-19r5em7"));
		btniniciosesion.click();
		
//		WebElement pass2 = driver.findElement(By.id("password"));
//		pass2.sendKeys("trello123");
//		btniniciosesion.click();
		
//		Thread.sleep(3000);
//		WebElement tableros = driver.findElement(By.xpath("//a[contains(text(),'Tableros')]"));
//		if (tableros.isDisplayed()) {
//			tableros.click();
//		}
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement nuevoTablero = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath(".//span[contains(text(),'Crear un tablero nuevo')]"));
			}
		});
		//click on the selenium link
		nuevoTablero.click();
		//close~ browser
		//driver.close() ;
		
		
//		Thread.sleep(5000);
//		WebElement nuevoTablero= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/main/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/ul/li/div/p/span"));
//		//driver.close();
//		if (nuevoTablero.isDisplayed()) {
//			nuevoTablero.click();
//		}
		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement tituloTablero = wait2.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath("//input[@placeholder='Añadir título de tablero']"));
			}
		});
		//click on the selenium link
		tituloTablero.click();
		//close~ browser
		
//		WebElement tituloTablero = driver.findElement(By.xpath("//input[@placeholder='Añadir título de tablero']"));
//		tituloTablero.click();
		tituloTablero.sendKeys("Prueba Tablero 1");
//		Thread.sleep(3000);
		
		
		WebElement buttonCrearTablero = driver.findElement(By.xpath(".//button[@data-test-id='create-board-submit-button']"));
		if (buttonCrearTablero.isDisplayed()) {
			buttonCrearTablero.click();
			//"//*[contains(text(),'Crear tablero')]"
			
		}
		
//		WebElement addList = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/main/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div/div[1]/div[1]"));
//		if (addList.isDisplayed()) {
//			addList.click();
//		}
//		
		WebElement nuevaLista = driver.findElement(By.xpath(".//span[contains(text(),'Añada otra lista')]"));
		if (nuevaLista.isDisplayed()) {
			nuevaLista.click();
		}
		
		WebElement textAreaLista = driver.findElement(By.xpath("//input[@placeholder='Introduzca el título de la lista...']"));
		if (textAreaLista.isDisplayed()) {
			textAreaLista.sendKeys("Por Hacer");
		}
		

		WebElement anadir = driver.findElement(By.xpath("//input[@value='Añadir lista']"));
		if (anadir.isDisplayed()) {
			anadir.click();
		}
		
		
		WebElement nuevaTarjeta = driver.findElement(By.xpath("//*[@id=\"board\"]/div[4]/div/div[3]/a/span[1]"));
		if (nuevaTarjeta.isDisplayed()) {
			nuevaTarjeta.click();
		}
		
		WebElement tituloTarjeta = driver.findElement(By.xpath(".//textarea[@placeholder='Introduzca un título para esta tarjeta...']"));
		if (tituloTarjeta.isDisplayed()) {
			tituloTarjeta.sendKeys("Tarjeta de Prueba");
		}
		
		WebElement guardarTarjeta = driver.findElement(By.xpath(".//input[@value='Añadir tarjeta']"));
		if (guardarTarjeta.isDisplayed()) {
			guardarTarjeta.click();
		}
		
		WebElement addPropTarjeta = driver.findElement(By.xpath(".//span[contains(text(),'Tarjeta de Prueba')]"));
		if (addPropTarjeta.isDisplayed()) {
			addPropTarjeta.click();
		}
		
		WebElement tarjDescrip = driver.findElement(By.xpath(".//textarea[@placeholder='Añadir una descripción más detallada...']"));
		if (tarjDescrip.isDisplayed()) {
			tarjDescrip.sendKeys("esto es una descripcion de prueba");
		}
		
		WebElement guardarDesc = driver.findElement(By.xpath("//*[contains(text(),'Añadir una descripción más detallada...')]//following::input"));
		if (guardarDesc.isDisplayed()) {
			guardarDesc.click();
		}
		
		
		WebElement etiquetas = driver.findElement(By.xpath("//a[@title='Etiquetas']"));
		if (etiquetas.isDisplayed()) {
			etiquetas.click();
		}
		
		WebElement color = driver.findElement(By.xpath(".//span[(@data-color='blue')]"));
		if (color.isDisplayed()) {
			color.click();
		}
		
		WebElement cerrarcolor = driver.findElement(By.xpath("//*[@id=\"chrome-container\"]/div[4]/div/div[1]/a"));
		if (cerrarcolor.isDisplayed()) {
			cerrarcolor.click();
		}
		
		WebElement fechas = driver.findElement(By.xpath("//*[contains(text(),'Fechas')]"));
		if (fechas.isDisplayed()) {
			fechas.click();
		}
		
		Wait<WebDriver> wait3 = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement calendario = wait3.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath(".//div[@class='_2rY5DLIOkAg_j2']"));
			}
		});
		calendario.getText();
		
		
		List<WebElement> dias = driver.findElements(By.xpath("/html/body/div[5]/div/section/div/div/form/div[1]/div/div[2]/table/tbody//td/div"));
		int cantidadDIas = dias.size();
		String diaSleccionado = "23";
		for (int i = 0; i < cantidadDIas; i++) {
			String diaCalendario = dias.get(i).getText();
			if (diaCalendario.contains(diaSleccionado)) {
				dias.get(i).click();
				break;
			}
			
		}
		
		
//		WebElement fechaInicioChk = driver.findElement(By.className("_3aiwnKtvjg_Vkq"));
//		if (fechaInicioChk.isDisplayed()) {
//			fechaInicioChk.click();
//		}
		
		WebElement guardarFecha = driver.findElement(By.xpath("//*[@data-test-id='save-date-button']"));
		if (guardarFecha.isDisplayed()) {
			guardarFecha.click();
		}
		
		WebElement adjutarImgagen = driver.findElement(By.xpath("//*[contains(text(),'Adjunto')]"));
		if (adjutarImgagen.isDisplayed()) {
			adjutarImgagen.click();
		}
		
		WebElement addlink = driver.findElement(By.id("addLink"));
		if (addlink.isDisplayed()) {
			addlink.sendKeys("data:image/jpeg;base64,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");
		}
		
		WebElement btnAdjuntar = driver.findElement(By.xpath("//input[@class='js-add-attachment-url']"));
		if (btnAdjuntar.isDisplayed()) {
			btnAdjuntar.click();
		}
		
		WebElement adjutarImgagen2 = driver.findElement(By.xpath("//*[contains(text(),'Adjunto')]"));
		if (adjutarImgagen2.isDisplayed()) {
			adjutarImgagen2.click();
		}
		
		File file = new File("C:\\Users\\alejandro.castro\\OneDrive - TSOFT\\Escritorio\\cv\\upload.pdf");
		String path = file.getAbsolutePath();
		
		WebElement ordenador = driver.findElement(By.xpath("//input[@class='js-attach-file']"));
		if (ordenador.isDisplayed()) {
			ordenador.sendKeys(path);
		}
		

		
		driver.findElement(By.id("submit")).click();
		WebElement from = driver.findElement(By.xpath("//*[contains(text(),'Por Hacer')]"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"board\"]/div[1]"));
//		
		
//		//crear una acccion dentro de la pagina
//		
//		Actions accion = new Actions(driver);
//		accion.dragAndDrop(from, to).build().perform();

//		



//		

//		

//		

		

//		
//		WebElement adjuntar = driver.findElement(By.xpath("//*[contains(text(),'Adjunto')]"));
//		if (etiquetas.isDisplayed()) {
//			etiquetas.click();
//		}
//		

//
//		//Fuente: https://www.iteramos.com/pregunta/72231/como-sube-los-archivos-del-controlador-web-de-selenio-al-navegador
//		WebElement portada = driver.findElement(By.xpath("//*[contains(text(),'Portada')]"));
//		if (portada.isDisplayed()) {
//			portada.click();
//			driver.findElement(By.xpath("//*[@title='Nathan Watson']"));
//		}
//		
//		WebElement comentario = driver.findElement(By.xpath("//*[@aria-label='Escribir un comentario']"));
//		if (comentario.isDisplayed()) {
//			comentario.sendKeys("Eso es un comentario");
//			driver.findElement(By.xpath("//*[@aria-label='Escribir un comentario']//following::input")).click();
//
//		}
//		
//		
//		driver.findElement(By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div[2]/a")).click();
		
		
//		
//		WebElement titulo2 = driver.findElement(By.name("name"));
//		if (addList.isDisplayed()) {
//			titulo2.sendKeys("En Proceso");
//		}
//		WebElement anadir2 = driver.findElement(By.xpath("//*[@type='submit']"));
//		if (anadir2.isDisplayed()) {
//			anadir2.click();
//		}
//		WebElement titulo3 = driver.findElement(By.name("name"));
//		if (addList.isDisplayed()) {
//			titulo3.sendKeys("Finalizado");
//		}
//		WebElement anadir3 = driver.findElement(By.xpath("//*[@type='submit']"));
//		if (anadir3.isDisplayed()) {
//			anadir3.click();
//		}
		

	}



}
