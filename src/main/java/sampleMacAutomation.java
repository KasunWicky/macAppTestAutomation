import io.appium.java_client.mac.Mac2Driver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class sampleMacAutomation {
    Mac2Driver driver;

    @Test
    public void launchApplication() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Mac");
        capabilities.setCapability("automationName", "Mac2");// /System/Applications
        capabilities.setCapability("bundleId", "us.zoom.xos");
        capabilities.setCapability("newCommandTimeout", 300);
        try {
            driver = new Mac2Driver(
                    new URL("http://127.0.0.1:4723"), capabilities) {
            };
            System.out.println("Zoom is launched");
        } catch (MalformedURLException malformedEx) {
           throw new RuntimeException("Zoom is not launched.\t" + malformedEx.getMessage());
        } catch (Exception exception) {
            throw new RuntimeException  ("Zoom is not launched.\t" + exception.getMessage());
        }
    }
}
