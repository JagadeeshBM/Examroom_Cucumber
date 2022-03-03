package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\jagadeeshm\\IdeaProjects\\Examroom_Cucumber\\Features\\Candidate.feature",
        glue = "stepDefinitions",
        dryRun =false,
        monochrome =false,
        plugin = {"pretty","html:test-output"},
       tags="@ClearDB or @Application or @AppApprove"
        //tags={"@AppApprove"}
)
public class TestRunner
{
}



