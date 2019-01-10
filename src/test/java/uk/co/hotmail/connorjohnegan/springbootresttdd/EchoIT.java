package uk.co.hotmail.connorjohnegan.springbootresttdd;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class EchoIT {

    @Test
    public void firstEchoTest() {
        get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
    }
}
