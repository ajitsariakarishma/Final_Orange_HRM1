package Final_Orange_HRM;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Final_Orange_HRM.Utils.randomDate;
import static com.sun.deploy.cache.Cache.copyFile;

public class Hooks extends BasePage{
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperties props = new LoadProperties();



    @Before
    public void setUpBrowser() {

        browserSelector.setUpBrowser();

        //maximise the browser window screen

        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("[.,:;!?]","")+randomDate()+".png";
            System.out.println(screenshotName);
            try{
                File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File destinationPath= new File(System.getProperty("user.dir")+"/target/Destinations/Screenshots" + screenshotName);
                copyFile(sourcePath,destinationPath);
                scenario.write("!!!!!!!!!!........Scenario Failed......!!!!!!!!!!!! Please see attached screenshots for the error/issue");
                final byte []screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image/png");
            }
            catch(IOException e){

            }

        }
        driver.quit();


    }


}
