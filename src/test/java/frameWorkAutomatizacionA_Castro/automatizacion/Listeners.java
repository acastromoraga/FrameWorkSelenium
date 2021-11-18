package frameWorkAutomatizacionA_Castro.automatizacion;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import recursos.Base;
import recursos.ReporteNG;

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ReporteNG.getReport();
//	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		String testMethosName = result.getMethod().getMethodName();
		// ExtentTest test= extent.createTest(testMethosName);
		test = extent.createTest(testMethosName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		String testMethosName = result.getMethod().getMethodName();
		test.log(Status.PASS, testMethosName);
		WebDriver driver = null;

//		try {
//			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch(Exception e)
//		{
//			e.getStackTrace();
//		}
////		extentTest.get().addScreenCaptureFromPath(result.getMethod().getMethodName());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			getScreenShotPath(testMethosName, driver);
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		extent.flush();
		// driver.close();
	}

}
