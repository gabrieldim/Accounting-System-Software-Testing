package accountingsystem.main.controllers;

import accountingsystem.main.model.WorkService;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
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
public class RestWorkServicesControllerTests {
  Gson gson;

  @BeforeSuite
  public void setup() {
    baseURI = "http://localhost";
    port = 8080;
    basePath = "api/workServices";
    gson = new Gson();
  }

  @Test
  void testGET_statusCode() {
    given().when().get().then().statusCode(200);
  }

  @Test
  void testGET_attributeCheck() {
    given().when().get("/getAllWorkServices").then().statusCode(200);
  }

  @Test
  void testGET_getAllWorkServicesCount() {
    given().when().get("/getAllWorkServicesCount").then().statusCode(200);
  }

  @Test
  void testGET_getAllWorkServicesForCompany() {
    given().when().get("/getAllWorkServicesForCompany").then().statusCode(200);
  }

  @Test
  void measureResponseTime() {
    //        Response response = get();
    //        long timeInMS = response.time();
    //        long timeInS = response.timeIn(TimeUnit.SECONDS);
    //        assertTrue(600 > timeInMS);
    given().when().get().then().time(lessThan(600L));
  }

  @Test
  void testGET_logResponse() {
    given().when().get().then().log().body().statusCode(200);
  }

  @Test
  void testPOST() {

    String json = gson.toJson(new WorkService("testName", "testDescription", 150l));
    given()
        .contentType(ContentType.JSON)
        .body(json)
        .post()
        .then()
        .statusCode(302)
        .extract()
        .response();
  }

  @Test
  void testUpdate() {

    String json = gson.toJson(new WorkService("testName", "testDescription", 150l));
    given()
        .contentType(ContentType.JSON)
        .body(json)
        .patch("/1")
        .then()
        .statusCode(302)
        .extract()
        .response();
  }

  @Test
  void testDELETE() {
    given().delete("/1").then().statusCode(302);
  }
}
