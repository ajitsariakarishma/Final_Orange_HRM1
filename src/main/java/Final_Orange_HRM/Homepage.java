package Final_Orange_HRM;


import org.openqa.selenium.By;
import org.testng.Assert;


public class Homepage extends Utils {

    LoadProperties props = new LoadProperties();
    private By _username=By.id("txtUsername");
    private By _password=By.id("txtPassword");
    private By _loginButton=By.id("btnLogin");
    private By _error_msg=By.id("spanMessage");

    public void launchAndValidateHomePage() {
        driver.get(props.getProperty("url"));
        validateUrl(props.getProperty("url"));
    }
    public void enterValidcredentials(){
        enterText(_username,props.getProperty("username"));
        enterText(_password,props.getProperty("password"));

    }
    public void clickOnLoginButton()  {
        clickElement(_loginButton);
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public void enterInvalidCredentials(String username,String password){
        enterText(_username,username);
        enterText(_password,password);
    }
    public void validateErrorMessage(String error_message){
        String actual_msg =getTextFromElement(_error_msg);
        Assert.assertEquals(actual_msg,error_message,"Error message doesn't match");

    }



}
