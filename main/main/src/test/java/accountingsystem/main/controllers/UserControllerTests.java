package accountingsystem.main.controllers;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserControllerTests {
    Gson gson;

    @BeforeSuite
    public void setup(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "api/user";
        gson = new Gson();
    }

    @Test
    void testGET_statusCode(){
        given().when()
                .get()
                .then()
                .statusCode(200);
    }



    @Test
    void measureResponseTime(){
//        Response response = get();
//        long timeInMS = response.time();
//        long timeInS = response.timeIn(TimeUnit.SECONDS);
//        assertTrue(600 > timeInMS);
        given().when()
                .get()
                .then()
                .time(lessThan(600L));
    }

    @Test
    void testGET_logResponse(){
        given().when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200);
    }


}