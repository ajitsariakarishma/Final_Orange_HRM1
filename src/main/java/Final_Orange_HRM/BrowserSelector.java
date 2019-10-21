package Final_Orange_HRM;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSelector extends Utils{
    public static LoadProperties props = new LoadProperties();
    public static final String USERNAME = props.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = props.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

    public void setUpBrowser() {
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        // If sauce lab is true...............................................
        if (SAUCE_LAB) {
            System.out.println("running in SauceLab ........ with browser : " + browser);
            if (browser.equalsIgnoreCase("Safari")) {
                MutableCapabilities sauceOptions = new  MutableCapabilities();

                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setCapability("platformName", "macOS 10.14");
                browserOptions.setCapability("browserVersion", "12.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Chrome")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "77.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Firefox")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "69.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("edge")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "18.17763");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("IE")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "11.285");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //Storing the value of browser from config file in a String Variable
            String browser = props.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {

                //setting system properties to launch chrome browser
                System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Resources\\Webdrivers\\chromedriver.exe");

                //open the browser

                ChromeOptions options = new ChromeOptions();
                // options.addArguments("disable-infobars");
                // options.addArguments("--disable-extensions");
                //options.addArguments("--disable-setUpBrowser-side-navigation");
                //options.addArguments("--incognito");
                // options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
                // driver = new ChromeDriver(options);
                driver = new ChromeDriver();


            } else if (browser.equalsIgnoreCase("firefox")) {
                //DesiredCapabilities ff = DesiredCapabilities.firefox();
                // ff.acceptInsecureCerts();
                //ff.setAcceptInsecureCerts(true);
                // FirefoxOptions options = new FirefoxOptions();
                // options.merge(ff);
                System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Resources\\Webdrivers\\geckodriver.exe");
                driver = new FirefoxDriver();//tried to merge ff here but didn't work
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\java\\Resources\\Webdrivers\\IEDriverServer.exe");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(internetExplorerOptions);
            }
            else {

                System.out.println("Browser name is either empty or typed wrong :" + browser);
            }

        }
    }

}
