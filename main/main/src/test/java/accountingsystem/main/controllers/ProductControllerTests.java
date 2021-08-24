package accountingsystem.main.controllers;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductControllerTests {
    Gson gson;

    @BeforeSuite
    public void setup(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "api/products";
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
    void testGET_attributeCheck(){
        given().when()
                .get("/getAllProducts")
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

    /*@Test
    void testGET_oneProduct(){


        ValidatableResponse id = given().when()
                .get("/getProductById/1")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id", equalTo(1));
    }*/
    @Test
    void testPOST(){
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");

        String json = gson.toJson(new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now()));
        given()
                .contentType(ContentType.JSON)
                .body(json).post().then()
                .statusCode(302)
                .extract()
                .response();
    }

    @Test
    void testUpdate(){

        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");

        String json = gson.toJson(new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now()));
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
    void testDELETE(){
        given()
                .delete("/1")
                .then()
                .statusCode(302);
    }

}