import com.saucelabs.saucerest.SauceREST;

import java.io.File;
import java.io.IOException;

public class UploadToSauceStorage
{
	static String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	static String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	static String IOS_SIMULATOR_APP = "SauceDemo-IOS-Simulator.zip";

	public static void main(String[] args) throws IOException
	{
		SauceREST api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
		System.out.println(api.getStoredFiles());

		File app = getResourceAsFile(IOS_SIMULATOR_APP);
		System.out.println(app.getAbsolutePath());
		String result = api.uploadFile(app);
		System.out.println(result);
	}

	public static File getResourceAsFile(String path)
	{
		ClassLoader loader = UploadToSauceStorage.class.getClassLoader();
		String file = loader.getResource(path).getFile();
		System.out.println(file);
		return new File(file);
	}
}
