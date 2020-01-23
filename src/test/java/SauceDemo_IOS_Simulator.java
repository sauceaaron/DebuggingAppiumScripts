import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SauceDemo_IOS_Simulator
{
	static final String SAUCE_URL = "https://ondemand.saucelabs.com/wd/hub";
	static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	String sessionId;
	String testName;

	Logger log;

	@BeforeMethod
	public void setup(Method method) throws MalformedURLException
	{
		testName = this.getClass().getSimpleName() + " " + method.getName();
		log = Logger.getLogger(testName);

		URL url = new URL(SAUCE_URL);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", SAUCE_USERNAME);
		capabilities.setCapability("accessKey", SAUCE_ACCESS_KEY);
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "13.0");
		capabilities.setCapability("deviceName", "iPhone X Simulator");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("name", testName);

		capabilities.setCapability("app", "sauce-storage:SauceDemo-IOS.zip");

		driver = new IOSDriver<MobileElement>(url, capabilities);
		wait = new WebDriverWait(driver, 30);
		sessionId = driver.getSessionId().toString();

		log.info("started new test session: " + sessionId);
	}

	@Test
	public void checkProducts()
	{
		driver.findElementByAccessibilityId("test-Username").setValue("standard_user");
		driver.findElementByAccessibilityId("test-Password").setValue("secret_sauce");
		driver.findElementByAccessibilityId("test-LOGIN").click();

		MobileElement products = (MobileElement) wait.until(presenceOfElementLocated(MobileBy.name("PRODUCTS")));
		assertThat(products).isNotNull();

		List<MobileElement> productList = driver.findElements(By.xpath("//XCUIElementTypeOther[@name='test-Item']"));
		log.info("productList: " + productList.size());
		productList.forEach(element -> { log.info(element.getText()); } );
		assertThat(productList.size()).isBetween(3, 5);
	}

	@AfterMethod
	public void cleanup(ITestResult result)
	{
		String status = (result.getStatus() == 1) ? "passed" : "failed";

//		driver.executeScript("sauce:job-result=" + status);
		driver.quit();

		SauceREST sauce = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
		sauce.jobPassed(sessionId);
	}
}
