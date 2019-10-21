package Final_Orange_HRM;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features=".", tags=("@login"),plugin={"pretty","html:target/Destinations"})
public class RunTest {
}