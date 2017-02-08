import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.goldendict.pages.RegisterPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by kostya on 2/5/17.
 */
public class TestClass {

    AppiumDriver driver;
    WebDriverWait waitForCondition ;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "testDevice");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, "Android");
        desiredCapabilities.setCapability("platformVersion", "5");

        //File file = new File("/home/kostya/apk", "GoldenDict Free_mobi.goldendict.android.free.apk");
        File file = new File("C:\\apk", "Markets.com_com.markets.android.apk");
        desiredCapabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        waitForCondition = new WebDriverWait (driver, 5 );
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverRunner.setWebDriver(driver);
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        //waitForCondition.until(ExpectedConditions.presenceOfElementLocated(By.id("com.markets.android:id/login_login_name")));
        Thread.sleep(20000);
        RegisterPage.accountExistsLink.click();
        //$(By.xpath(".//*[@text='Already have an account?']")).click();
        //MobileElement accountExistsLink = (MobileElement) driver.findElement(By.id("com.markets.android:id/short_registration_account_exists"));
        //accountExistsLink.click();
        MobileElement loginField = (MobileElement) driver.findElement(By.id("com.markets.android:id/login_login_name"));
        loginField.click();
        loginField.sendKeys("kostya@kstt.com");
        MobileElement passwordField = (MobileElement) driver.findElement(By.id("com.markets.android:id/login_password"));
        passwordField.sendKeys("www");
        driver.hideKeyboard();
        MobileElement loginButton = (MobileElement) driver.findElement(By.id("com.markets.android:id/login_authbutton"));
        loginButton.click();
        //Thread.sleep(20000);
        //MobileElement popularLink = (MobileElement) driver.findElement(By.id("com.markets.android:id/popular"));
        //Assert.assertTrue(popularLink.isDisplayed());
        Assert.assertTrue($(By.xpath(".//*[@text='Popular']")).isDisplayed());
        //loginButton.is

    }


}
