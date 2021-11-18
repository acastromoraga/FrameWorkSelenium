package recursos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {

	// Variable local webdriver;
	public WebDriver driver;

	public WebDriver InitDriver() throws IOException {
		// TODO Auto-generated method stub
		Properties propiedades = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\alejandro.castro\\eclipse-workspace\\automatizacion\\src\\main\\java\\recursos\\data.properties");
		propiedades.load(file);
		String browserName = propiedades.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

			driver = new ChromeDriver();

		}
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");

			WebDriver driver = new FirefoxDriver();

		}
		if (browserName.equalsIgnoreCase("IE")) {

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
	

	
	public void getScreenShotPath(String nameTest,WebDriver driver) {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		String destinoFile = System.getProperty("user.dir" + "\\report\\" + nameTest+".png");
		
	}
}
