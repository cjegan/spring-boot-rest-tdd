package uk.co.hotmail.connorjohnegan.springbootresttdd;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.TodoEntity;
import uk.co.hotmail.connorjohnegan.springbootresttdd.repositories.TodosRepository;

import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodosIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TodosRepository todosRepository;

    private String taskName = "Washing";
    private Instant timeNow = Instant.now();
    private boolean taskComplete = false;
    private TodoEntity todoEntity = new TodoEntity(taskName, timeNow, taskComplete);

    @Test
    public void createTodo() {
        given()
                .baseUri("http://localhost:" + port)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(todoEntity)
                .post("/todos")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", notNullValue())
                .body("task", equalTo(taskName))
                .body("creationDate", equalTo(timeNow.toString()))
                .body("complete", equalTo(taskComplete));
    }

    @Test
    public void readTodo() {
        Long id = todosRepository.save(todoEntity).getId();

        Response response = given()
                .baseUri("http://localhost:" + port)
                .get("/todos/" + id);

        assertThat(response.getStatusCode(), equalTo(200));

        TodoEntity actual = response.as(TodoEntity.class);

        assertThat(actual.getId(), equalTo(id));
        assertThat(actual.getTask(), equalTo(taskName));
        assertThat(actual.getCreationDate().toEpochMilli(), equalTo(timeNow.toEpochMilli()));
        assertThat(actual.isComplete(), equalTo(taskComplete));
    }
}
