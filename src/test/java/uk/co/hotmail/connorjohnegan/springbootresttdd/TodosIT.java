package uk.co.hotmail.connorjohnegan.springbootresttdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.TodoEntity;

import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodosIT {

    @LocalServerPort
    private int port;

    private String taskName = "Washing";
    private Instant timeNow = Instant.now();
    private boolean taskComplete = false;
    private TodoEntity todoEntity = new TodoEntity(taskName, timeNow, taskComplete);

    @Test
    public void createTodos() {
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
}
