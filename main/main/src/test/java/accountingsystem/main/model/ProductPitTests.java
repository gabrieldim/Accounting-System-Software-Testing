package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductPitTests {

  @Test
  void EmptyConstructor() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product = new Product();

    Assertions.assertEquals(null, product.getManufacturer());
  }

  @Test
  void getAndSetProcurementPrice() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    String s = "1223434343";
    Long ProcurementPrice = Long.parseLong(s);
    product.setProcurementPrice(ProcurementPrice);
    Long test = product.getProcurementPrice();

    Assertions.assertEquals(ProcurementPrice, test);
  }

  @Test
  void getAndSetProfit() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    String s = "1223434343";
    Long profit = Long.parseLong(s);
    product.setProfit(profit);
    Long test = product.getProfit();

    Assertions.assertEquals(profit, test);
  }

  @Test
  void getAndSetId() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    String s = "1223434343";
    Long id = Long.parseLong(s);
    product.setId(id);

    Long test = product.getId();

    Assertions.assertEquals(id, test);
  }

  @Test
  void getDescription() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    String description = "productDescription";
    String test = product.getDescription();

    Assertions.assertEquals(description, test);
  }

  @Test
  void setDescription() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    String description = "productDescription test";
    product.setDescription(description);
    Assertions.assertEquals(description, product.getDescription());
  }

  @Test
  void getName() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    /*String test = "testname";*/
    Assertions.assertEquals("productName", product.getName());
  }

  @Test
  void setName() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    String test = "testname";
    product.setName(test);
    Assertions.assertEquals("testname", product.getName());
  }

  @Test
  void getPrice() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    long p = 150L;
    Assertions.assertEquals(150L, product.getPrice());
  }

  @Test
  void setPrice() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    long p = 150L;

    product.setPrice(p);
    Assertions.assertEquals(150L, product.getPrice());
  }

  @Test
  void getDate() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    LocalDateTime p = LocalDateTime.now();
    Assertions.assertEquals(p, product.getDate());
  }

  @Test
  void setDate() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    LocalDateTime p = LocalDateTime.now();
    product.setDate(p);
    Assertions.assertEquals(p, product.getDate());
  }

  @Test
  void getExpirationDate() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    LocalDateTime p = LocalDateTime.now();
    Assertions.assertEquals(p, product.getExpirationDate());
  }

  @Test
  void setExpirationDate() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());

    LocalDateTime p = LocalDateTime.now();
    product.setExpirationDate(p);
    Assertions.assertEquals(p, product.getExpirationDate());
  }

  @Test
  void getManufacturer() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    Assertions.assertEquals(manufacturer, product.getManufacturer());
  }

  @Test
  void setManufacturer() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150L,
            LocalDateTime.now(),
            LocalDateTime.now());
    Manufacturer manufacturer2 = new Manufacturer("TestUser1", "MKD1");
    product.setManufacturer(manufacturer2);

    Assertions.assertEquals(manufacturer2, product.getManufacturer());
  }
}
