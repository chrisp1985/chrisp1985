package Methods;

import io.appium.java_client.AppiumSetting;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chrisp on 01/08/2016.
 */
public class CreateDriver {
    private static final String DEVICE__GALAXY_S5 = "Galaxy S5";
    private static final String DEVICE__LITTLE_SAMSUNG = "Samsung CI";

    /**
     * *** SETUP THE DRIVER ***
     *
     * @return The setup driver.
     */
    public static AndroidDriver setupDriver() throws MalformedURLException {
        // Set the apk path
        File projectDirectory = new File(System.getProperty("projectDir"));
        System.out.println(projectDirectory);
        File applicationDirectory = new File(projectDirectory, "app\\build\\outputs\\apk\\app-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", DEVICE__LITTLE_SAMSUNG);
        capabilities.setCapability("app", applicationDirectory.getAbsolutePath());
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformVersion", "4.1");
        capabilities.setCapability("platformName", "Android");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        return driver;
    }
}
