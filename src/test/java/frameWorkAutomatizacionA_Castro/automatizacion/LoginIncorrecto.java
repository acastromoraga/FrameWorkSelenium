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
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;


import pageObjects.Login;

import recursos.Base;

public class LoginIncorrecto extends Base {
	
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
	private void BaseNavegacionPag(String user, String pass) throws IOException, InterruptedException {
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
	
	@Test (dependsOnMethods = "BaseNavegacionPag")
	private void obtenerValidacion() {
		Login login = new Login(driver);
		// TODO Auto-generated method stub
		String nombrePag = driver.getTitle().toString();
		String pagTrello = "Tableros | Trello";

		Assert.assertEquals(nombrePag,pagTrello);

	}

	

	@DataProvider
	private Object[][] getCredenciales() {
		// TODO Auto-generated method stub
		Object[][] data = new Object[1][2];
		data[0][0] = "testTrelloTecnova@gmail.com";
		data[0][1] = "trello1234";

		return data;

	}

}
