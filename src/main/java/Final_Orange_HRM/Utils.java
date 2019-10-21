package Final_Orange_HRM;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.deploy.cache.Cache.copyFile;

public class Utils extends BasePage {


      //enter text at location
        public static void enterText(By by, String text) {
            clickElement(by);
            driver.findElement(by).sendKeys(text);

        }
        public static String validateUrl(String expectedUrl){
            String currentUrl =driver.getCurrentUrl();
            Assert.assertEquals(currentUrl,expectedUrl,"Url doesnot match");
            return currentUrl;

        }

        // get text from  location
        public static String getTextFromElement(By by) {
            return driver.findElement(by).getText();

        }

        // click on web element
        public static void clickElement(By by) {
            driver.findElement(by).click();

        }

        // wait for element to be visiable
        public static void waitForElementVisible(By by, long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

        }
        public static void waitForElementInVisible(By by, long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

        }

        //wait for element to clickable
        public static void waitUntilElementLoadsAndIsClickable(By by, long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        //wait for alert to display
        public static void forAlterPresent(long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());

        }

        //to generate unique number everytime it runs
        public static String randomDate() {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("ddMMyyHHmmss");
            return simpledateformat.format(new Date());


        }

        //mouse hover movement
        public static void movedriverToWebElement(By by) {
            Actions actions = new Actions(driver);

            //storing location of dropdown in webelement variable
            WebElement menuList = driver.findElement(by);
            actions.moveToElement(menuList).perform();

        }




        //Handling dropdown by visible text
        public static void handlingDropdownByVisibleText(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);

        }

        //handling dropdown by value
        public static void handlingDropdownByValue(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByValue(text);
        }

        //handling dropdown by index number
        public static void handlingDropdownByIndex(By by, int index_num) {
            Select select = new Select(driver.findElement(by));
            select.selectByIndex(index_num);
        }


        public static void clearTextFromInputBoxArea(By by) {

            driver.findElement(by).clear();
        }

        public static void clearAndEnterText(By by, String text) {

            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);

        }

        public static boolean isElementVisible(By by) {
            return driver.findElement(by).isDisplayed();

        }

        public static boolean isElementEnabled(By by) {
            boolean result= driver.findElement(by).isEnabled();
            return result;
        }

        public static boolean isElementSelected(By by) {
            boolean result= driver.findElement(by).isSelected();
            return result;

        }

        public static String gettingTextOfSelectedOptionFromDropdownByvisibleText(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);
            WebElement option = select.getFirstSelectedOption();
            String selected_option = option.getText();
            System.out.println("Option seleted from dropdown is :  " + selected_option);
            return selected_option;

        }

        public static String gettingTextOfSelectedOptionFromDropdownByValue(By by, String text) {
            Select select = new Select(driver.findElement(by));
            select.selectByValue(text);
            WebElement option = select.getFirstSelectedOption();
            String selected_option = option.getText();
            System.out.println("Option seleted from dropdown is :  " + selected_option);
            return selected_option;
        }


        public static String gettingTextOfSelectedOptionFromDropdownByIndexNumber(By by, int index_num) {
            Select select = new Select(driver.findElement(by));
            select.selectByIndex(index_num);
            WebElement option = select.getFirstSelectedOption();
            String selected_option = option.getText();
            System.out.println("Option seleted from dropdown is :  " + selected_option);
            return selected_option;
        }

        public static String gettingAttributeofWebElement(By by, String value) {
            WebElement ele = driver.findElement(by);
            String atrribute = ele.getAttribute(value);
            //System.out.println("Attribute of the " +value+"  given is : "+atrribute);
            return atrribute;
        }

        public static String getCssPropertyOfWebElement(By by, String text) {
            WebElement ele = driver.findElement(by);
            String cssProperty = ele.getCssValue(text);
            //System.out.println("Css value of the  "+text+" is : "+cssProperty);
            return cssProperty;
        }

        //to verify and get the tittle of web page
        public static String verifytittle(String expected_tittle) {
            String tittle = driver.getTitle();
            Assert.assertEquals(tittle,expected_tittle,"Tittle doenot match");
            // System.out.println("Tittle of the active Webpage is:  " + tittle);
            return tittle;

        }

        //to navigate to any other url
        public static void toNavigatetoAnotherUrl(String url) {

            driver.navigate().to(url);
        }

        // to navigate backwards
        public static void toNavigateBackwards() {
            driver.navigate().back();
        }

        //to navigate forward
        public static void toNavigateForward() {
            driver.navigate().forward();

        }

        //to refreash webpage
        public static void toRefreashWebPage() {
            driver.navigate().refresh();
        }

        //handling bootstrap dropdown
        public static String bootStarpDropDown(By by, String text) {
            List<WebElement> list = driver.findElements(by);
            String actual = null;
            for (WebElement element : list) {
                actual = (element.getText());


                if (actual.equals(text)) {
                    element.click();
                    System.out.println("actual text is :" + actual);

                    break;
                }

            }
            return actual;
        }

        public static void closeDriver() {
            driver.quit();
        }

        public static boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
        }

        public static void scrollDown(By by) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,1500)");
        }

        public static void takeScreenShot(WebDriver webdriver, String filename)  {

            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File("src\\test\\Screenshots"+filename+randomDate()+".png");

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void autoSuggestiveDropdown(By by, String searchKeyWord){
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(by)).sendKeys(searchKeyWord).perform();

        }

        public static void rightClickOnElement(By by){
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(by);
            actions.moveToElement(element).contextClick().perform();

        }

        public static void scrollInVeiw(By by){
            WebElement element = driver.findElement(by);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",element);

        }
        public void takescreenshotBDDAndCloseBroser(Scenario scenario) throws IOException {
            if (scenario.isFailed()) {
                String screenshotName = scenario.getName().replaceAll("[.,:;!?]",""+randomDate()+".png");
                try{
                    File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    File destinationPath= new File(System.getProperty("user.dir")+"/target/Destinations/Screenshots"+screenshotName);
                    copyFile(sourcePath,destinationPath);
                    scenario.write("!!!!!!!!!!........Scenario Failed......!!!!!!!!!!!! Please see attached screenshots for the error/issue");
                    scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
                }
                catch(IOException e){

                }

            }
            driver.quit();
        }

    }



