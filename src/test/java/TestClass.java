import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kostya on 2/5/17.
 */
public class TestClass {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "testDevice");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, "Android");
        desiredCapabilities.setCapability("platformVersion", "5");

        File file = new File("/home/kostya/apk", "GoldenDict Free_mobi.goldendict.android.free.apk");
        desiredCapabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void skipFirstScreen(){
        MobileElement skipLink = (MobileElement) driver.findElement(By.id("mobi.goldendict.android.free:id/skip"));
        skipLink.click();
    }


}
