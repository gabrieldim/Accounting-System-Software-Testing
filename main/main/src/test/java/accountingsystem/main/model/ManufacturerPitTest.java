package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerPitTest {

    @Test
    void EmptyConstructor() {
        Manufacturer manufacturer = new Manufacturer();

        Assertions.assertEquals(null, manufacturer.getName());

    }


    @Test
    void getAndSetId() {

        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        String s = "1223434343";
        Long id = Long.parseLong(s);
        manufacturer.setId(id);

        Long test = manufacturer.getId();

        Assertions.assertEquals(id, test);
    }



    @Test
    void getName() {
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Assertions.assertEquals("TestUser", manufacturer.getName());

    }

    @Test
    void setName() {

        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");


        String test = "testname";
        manufacturer.setName(test);
        Assertions.assertEquals("testname", manufacturer.getName());
    }

    @Test
    void getCountry() {

        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Assertions.assertEquals("MKD", manufacturer.getCountry());
    }

    @Test
    void setCountry() {


        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");


        String test = "testname";
        manufacturer.setCountry(test);
        Assertions.assertEquals("testname", manufacturer.getCountry());
    }
}