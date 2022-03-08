package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@SpringBootApplication
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\jagadeeshm\\IdeaProjects\\Examroom_Cucumber\\Features\\Candidate.feature",
        glue = "stepDefinitions",
        dryRun =false,
        monochrome =false,
        plugin = {"pretty","html:test-output"},
        tags={"@Application or @AppApprove or @RegisterForExam"}
        //tags="@Application or @AppApprove"
        //tags="@RegisterForExam"
       //tags="@ClearDB or @Application or @AppApprove or @RegisterForExam"
        //tags={"@AppApprove"}
)
public class TestRunner
{
}



