package Final_Orange_HRM;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features=".", tags=("@login"))
public class RunTest {
}