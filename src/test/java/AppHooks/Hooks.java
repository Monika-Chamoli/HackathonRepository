package AppHooks;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import utils.configReader;
import utils.commonutilities;
import java.io.File;
import java.util.Properties;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;

public class Hooks {
    commonutilities commonUtilities=new commonutilities();
    private driverFactory myFactory;
    private WebDriver driver;
    private configReader FileReader;
    Properties props;



    @Before
    public void launchBrowser() {
        FileReader = new configReader();
        props = FileReader.init_prop();
        String browser = props.getProperty("browser");
        myFactory = new driverFactory();
        driver = myFactory.init_driver(browser);
        driver.get(props.getProperty("baseURL"));

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot scrShot=(TakesScreenshot)driver;
        byte[] data= scrShot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(data, "image/png", "screenshot");
        }
        driver.quit();

    }

//    @AfterStep
//    public void cleanUp(Scenario scenario)
//    {
//        TakesScreenshot scrShot=(TakesScreenshot)driver;
//        byte[] data= scrShot.getScreenshotAs(OutputType.BYTES);
//        scenario.attach(data, "image/png", "screenshot");
//
//    }

}
