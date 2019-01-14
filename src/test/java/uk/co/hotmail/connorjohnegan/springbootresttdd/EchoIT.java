package uk.co.hotmail.connorjohnegan.springbootresttdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EchoIT {

    @LocalServerPort
    private int port;

    @Test
    public void firstEchoTest() {
        given()
                .baseUri("http://localhost:" + port)
                .get("/echo/hello")
                .then()
                .assertThat()
                .body("message", equalTo("hello"));
    }
}
