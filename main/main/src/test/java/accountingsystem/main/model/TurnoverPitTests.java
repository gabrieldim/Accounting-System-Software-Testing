package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurnoverPitTests {

  @Test
  void EmptyConstructor() {
    Turnover turnover = new Turnover();

    Assertions.assertEquals(null, turnover.getCompany());
  }

  @Test
  void getAndSetWorkServiceList() {

    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setWorkServiceList(workServiceList);
    Assertions.assertEquals(workServiceList, turnover.getWorkServiceList());
  }

  @Test
  void getAndSetProductList() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setProductList(productList);
    Assertions.assertEquals(productList, turnover.getProductList());
  }

  @Test
  void getAndSetCompany() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setCompany(company);
    Assertions.assertEquals(company, turnover.getCompany());
  }

  @Test
  void getAndSetId() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setId(100L);
    Assertions.assertEquals(100, turnover.getId());
  }

  @Test
  void getAndSetDate() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    LocalDateTime p = LocalDateTime.now();
    turnover.setDate(p);
    Assertions.assertEquals(p, turnover.getDate());
  }

  @Test
  void getAndSetNumberProducts() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setNumberProducts(3);
    Assertions.assertEquals(3, turnover.getNumberProducts());
  }

  @Test
  void getAndSetAmount() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    WorkService workService2 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product1);
    Turnover turnover =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList, productList, company);
    turnover.setAmount(300L);
    Assertions.assertEquals(300, turnover.getAmount());
  }
}
