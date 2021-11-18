package frameWorkAutomatizacionA_Castro.automatizacion;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;

import pageObjects.Login;

import recursos.Base;

public class LoginCorrecto extends Base {

	@BeforeTest
	private void iniciatizacio() throws IOException {
		// TODO Auto-generated method stub
		driver = InitDriver();
		driver.get("https://trello.com/es");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "getCredenciales")
	private void Navegacion_Pag_Trello(String user, String pass) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		driver = InitDriver();
//		driver.get("https://trello.com/es");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Login login = new Login(driver);
		login.sesion().click();
		login.usuario().sendKeys(user);
		login.submitUsuario().click();
		Thread.sleep(3000);
		if (login.pass().isDisplayed()) {
			login.pass().sendKeys(pass);
			login.submitPass().click();
		}

	}

	@Test(dependsOnMethods = "Navegacion_Pag_Trello")
	private void crearTablero() throws InterruptedException {
		// TODO Auto-generated method stub
//		driver= InitDriver();
		Login login = new Login(driver);
		login.nuevoTablero().click();
		login.tituloTablero().sendKeys("Prueba Tablero 1");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(login.btnCrearTablero()));
		login.btnCrearTablero().click();
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = { "Navegacion_Pag_Trello", "crearTablero" })
	private void crearlista() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		login.nuevaLista().click();
		Thread.sleep(3000);
		login.textAreaLista().sendKeys("Por Hacer");
		Thread.sleep(3000);
		login.esperarBtnLista();
		if (login.anadirLista().isDisplayed()) {
			login.anadirLista().click();
		}

	}

	@Test(dependsOnMethods = "crearlista")
	private void agregarTarjeta() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		Thread.sleep(3000);
		if (login.nuevaTarjeta().isDisplayed()) {
			login.nuevaTarjeta().click();
		}
		if (login.tituloTarjeta().isDisplayed()) {
			login.tituloTarjeta().sendKeys("Tarjeta de Prueba");
		}

		if (login.guardarTarjeta().isDisplayed()) {
			login.guardarTarjeta().click();
		}

	}

	@Test(dependsOnMethods = "agregarTarjeta")
	private void agregarPropiedades() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		login.esperarTarjeta();
		if (login.addPropTarjeta().isDisplayed()) {
			login.addPropTarjeta().click();
		}
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "agregarPropiedades")
	private void addDescripTarj() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		if (login.tarjDescrip().isDisplayed()) {
			login.tarjDescrip().sendKeys("esto es una descripción de prueba");
			login.guardarDesc().click();
		}

	}

	@Test(dependsOnMethods = "addDescripTarj")
	private void addEtiqueta() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		if (login.etiquetas().isDisplayed()) {
			login.etiquetas().click();
		}
		if (login.color().isDisplayed()) {
			login.color().click();
			login.cerrarcolor().click();
		}

	}

	@Test(dependsOnMethods = "addEtiqueta")
	private void selectdate() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		if (login.fechas().isDisplayed()) {
			login.fechas().click();
			// login.seleccionaDia("25");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(login.fechasCalendario()));
			String tituloCalendario = login.fechasCalendario().getText();
			System.out.println("cantidadDIas: " + tituloCalendario);
			String diaSleccionado = "25";
			List<WebElement> dias = driver.findElements(By.xpath("/html/body/div[4]//td/div"));
			int cantidadDIas = dias.size();
			System.out.println("cantidadDIas: " + cantidadDIas);
			for (int i = 0; i < cantidadDIas; i++) {
				String diaCalendario = dias.get(i).getText();
				if (diaCalendario.equalsIgnoreCase(diaSleccionado)) {
					dias.get(i).click();
					break;
				}
			}
			login.guardarFecha().click();
		}

	}

	@Test(dependsOnMethods = "selectdate")
	private void adjuntarImagen() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);

		if (login.adjutarImgagen().isDisplayed()) {
			login.adjutarImgagen().click();
		}

		if (login.addlink().isDisplayed()) {
			login.addlink().sendKeys(
					"https://images.pexels.com/photos/2246476/pexels-photo-2246476.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
		}

		if (login.btnAdjuntar().isDisplayed()) {
			login.btnAdjuntar().click();
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(login.closeTarjet()));
		if (login.closeTarjet().isDisplayed()) {
			//login.closeTarjet().click();
		}
	}
	
	@Test(dependsOnMethods = "adjuntarImagen")
	private void addComentario() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		if (login.txtComentario().isDisplayed()) {
			login.txtComentario().sendKeys("esto es un comentario");
			login.guarGuardarComentar().click();
			login.closeTarjet().click();
		}

	}

//	@Test(dependsOnMethods = "adjuntarImagen")
//	private void closeTarjet() throws InterruptedException {
//		// TODO Auto-generated method stub
//		Login login = new Login(driver);
//		//deslizarse en un scroll
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		js.executeScript("window.scrollBy(0,0)");
//		Thread.sleep(2000);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(login.closeTarjet()));
//		if (login.closeTarjet().isDisplayed()) {
//			login.closeTarjet().click();
//		}
//
//	}

	@Test(dependsOnMethods = "addComentario")
	private void moverTarjeta() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement tarea = driver.findElement(By.xpath("//*[@id=\"board\"]/div[4]/div/div[2]/a/div[1]"));
		WebElement proceso = driver.findElement(By.xpath("//*[@id=\"board\"]/div[2]"));
		// *[@id="board"]/div[2]
		Actions accion = new Actions(driver);
		accion.dragAndDrop(tarea, proceso).build().perform();
//		Login login = new Login(driver);
//		if (login.addPropTarjeta().isDisplayed()) {
//			login.addPropTarjeta().click();
//		}
//		if (login.btnMoverTarj().isDisplayed()) {
//			login.btnMoverTarj().click();
//		}
//		
//		if (login.cbxLista().isDisplayed()) {
//			login.cbxLista().click();
//			login.option().click();
//		}
//		if (login.btnMover().isDisplayed()) {
//			login.btnMover().click();
//		}
//		login.closeTarjet().click();
	}
	
	

	@Test(dependsOnMethods = "moverTarjeta")
	private void eliminarTablero() throws InterruptedException {
		// TODO Auto-generated method stub
		Login login = new Login(driver);
		if (login.mostrarMenu().isDisplayed()) {
			login.mostrarMenu().click();
		}
		if (login.btnMas().isDisplayed()) {
			login.btnMas().click();
			login.cerrarTablero().click();
		} else {
			login.cerrarTablero().click();
		}

		if (login.btnCerrar().isDisplayed()) {
			login.btnCerrar().click();
		}
		if (login.eliminarTable().isDisplayed()) {
			login.eliminarTable().click();
		}
		if (login.confirEliminar().isDisplayed()) {
			login.confirEliminar().click();
		}

	}

	// metodo pensiente
	// @Test(dependsOnMethods = "adjuntarImagen")
//		private void adjuntarDocument() throws InterruptedException {
//			// TODO Auto-generated method stub
//			Login login = new Login(driver);
//			Thread.sleep(4000);
//			if (login.adjutarImgagen().isDisplayed()) {
//				login.adjutarImgagen().click();
//			}
//			File file = new File("C:\\Users\\alejandro.castro\\OneDrive - TSOFT\\Escritorio\\cv\\upload.pdf");
//			String path = file.getAbsolutePath();
//			
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(login.ordenador()));
//			
//			if (login.ordenador().isDisplayed()) {
//				login.ordenador().sendKeys(path);		
//
//			}
//			
//			
//			if (login.btnAdjuntar().isDisplayed()) {
//				login.btnAdjuntar().click();
//			}
//
//	}

	@DataProvider
	private Object[][] getCredenciales() {
		// TODO Auto-generated method stub
		Object[][] data = new Object[1][2];
		data[0][0] = "testTrelloTecnova@gmail.com";
		data[0][1] = "trello123";

		return data;

	}

}
