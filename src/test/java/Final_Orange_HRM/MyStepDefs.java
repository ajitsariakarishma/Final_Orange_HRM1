package Final_Orange_HRM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDefs extends Utils {
    Homepage homePage=new Homepage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Given("^is on homepage$")
    public void is_on_homepage() {
        homePage.launchAndValidateHomePage();

    }

    @When("^User enters valid username and  valid password$")
    public void user_enters_valid_username_and_valid_password() {
        homePage.enterValidcredentials();
    }

    @When("^Clicks on login button$")
    public void clicks_on_login_button()   {
        homePage.clickOnLoginButton();
    }

    @Then("^User is navigated to dashboard page$")
    public void user_is_navigated_to_dashboard_page() {
        dashBoardPage.validateurl();
    }

    @When("^User enters inavlid \"([^\"]*)\" and invalid \"([^\"]*)\"$")
    public void user_enters_inavlid_and_invalid(String username, String password) {
        homePage.enterInvalidCredentials(username,password);
    }

    @Then("^Sees and \"([^\"]*)\" display$")
    public void sees_and_display(String error_message) {
        homePage.validateErrorMessage(error_message);
    }
}


