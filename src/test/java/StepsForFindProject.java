import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;

public class StepsForFindProject
{
    String id;
    @Given("Project {string}")
    public void setProjectName(String str) {
        id = str;
    }

    @When("I want to find project")
    public void getProjectPage(){
        new TodoistEndPoint().getProject(id)
                .then()
                .assertThat()
                .body(Matchers.notNullValue())
                .and().statusCode(200);
    }

    @Then("I should get project {string}")
    public void viewAboutPage(String name){
        new TodoistEndPoint()
                .getProject(id)
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo(name));
    }
}
