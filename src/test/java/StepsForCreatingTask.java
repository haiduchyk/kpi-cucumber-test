import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class StepsForCreatingTask
{
    String name;
    int amount;

    @Given("With name {string}")
    public void setTasName(String str)
    {
        name = str;
    }

    @When("I want to create task")
    public void getProjectPage()
    {
        amount = GetTasksAmount();

        new TodoistEndPoint().createTask(name)
                .then()
                .assertThat()
                .body(Matchers.notNullValue())
                .and().statusCode(404);
    }

    private int GetTasksAmount()
    {
        var endPoint = new TodoistEndPoint();
        var tasks = endPoint.getActiveTasks();
        List<String> jsonResponse = tasks.jsonPath().getList("$");
        return jsonResponse.size();
    }

    @Then("I should get new task")
    public void viewNewTask(String name)
    {
        new TodoistEndPoint()
                .getProject(this.name)
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo(name));
    }
}
