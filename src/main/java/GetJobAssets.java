import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetJobAssets
{
   public static String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
   public static String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

   public static void main(String[] args) throws IOException {
      URL url = new URL("https://ondemand.saucelabs.com/wd/hub");
      DesiredCapabilities capabilities = new DesiredCapabilities();

      RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

      String sessionId = driver.getSessionId().toString();
      SauceREST sauce = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
      sauce.downloadVideo(sessionId);
   }
}
