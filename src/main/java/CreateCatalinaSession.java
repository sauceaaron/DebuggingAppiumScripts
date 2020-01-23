import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateCatalinaSession
{
	public static String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	public static String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("https://ondemand.saucelabs.com/wd/hub");

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", SAUCE_USERNAME);
		sauceOptions.setCapability("accessKey", SAUCE_ACCESS_KEY);
		sauceOptions.setCapability("name", "Create Catalina Test Session");

		SafariOptions browserOptions = new SafariOptions();
		browserOptions.setCapability("platformName", "macOS 10.15");
		browserOptions.setCapability("browserVersion", "latest");

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.merge(browserOptions);
		capabilities.setCapability("sauce:options", sauceOptions);

		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
		driver.get("https://www.saucelabs.com");
		driver.quit();
	}
}
