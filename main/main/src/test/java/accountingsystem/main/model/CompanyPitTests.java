package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyPitTests {

  @Test
  void EmptyConstructor() {
    Company company = new Company();
    Assertions.assertEquals(null, company.getId());
  }

  @Test
  void getAndSetSoldProducts() {

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

    String s = "1223434343";
    Long soldproducts = Long.parseLong(s);
    company.setSoldProducts(soldproducts);
    Long test = company.getSoldProducts();

    Assertions.assertEquals(soldproducts, test);
  }

  @Test
  void getAndSetSoldServices() {
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

    String s = "1223434343";
    Long soldsrvices = Long.parseLong(s);
    company.setSoldServices(soldsrvices);
    Long test = company.getSoldServices();

    Assertions.assertEquals(soldsrvices, test);
  }

  @Test
  void getProducts() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer1,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer2,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> products = new ArrayList<Product>();
    products.add(product);
    products.add(product1);
    products.add(product2);
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    WorkService workService1 = new WorkService("testName1", "testDescription1", 150l);

    WorkService workService2 = new WorkService("testName2", "testDescription2", 150l);

    List<WorkService> workServices = new ArrayList<WorkService>();
    workServices.add(workService1);
    workServices.add(workService2);

    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            products,
            workServices,
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);

    Assertions.assertEquals(products, company.getProducts());
  }

  @Test
  void setProducts() {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer1,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer2,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> products = new ArrayList<Product>();
    products.add(product);
    products.add(product1);
    products.add(product2);
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    WorkService workService1 = new WorkService("testName1", "testDescription1", 150l);

    WorkService workService2 = new WorkService("testName2", "testDescription2", 150l);

    List<WorkService> workServices = new ArrayList<WorkService>();
    workServices.add(workService1);
    workServices.add(workService2);

    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            products,
            workServices,
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    List<Product> products2 = new ArrayList<Product>();
    products2.add(product1);
    company.setProducts(products2);
    Assertions.assertEquals(products2, company.getProducts());
  }

  @Test
  void getWorkServices() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer1,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer2,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> products = new ArrayList<Product>();
    products.add(product);
    products.add(product1);
    products.add(product2);
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    WorkService workService1 = new WorkService("testName1", "testDescription1", 150l);

    WorkService workService2 = new WorkService("testName2", "testDescription2", 150l);

    List<WorkService> workServices = new ArrayList<WorkService>();
    workServices.add(workService1);
    workServices.add(workService2);

    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            products,
            workServices,
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);

    Assertions.assertEquals(workServices, company.getWorkServices());
  }

  @Test
  void setWorkServices() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer1,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer2,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> products = new ArrayList<Product>();
    products.add(product);
    products.add(product1);
    products.add(product2);
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    WorkService workService1 = new WorkService("testName1", "testDescription1", 150l);

    WorkService workService2 = new WorkService("testName2", "testDescription2", 150l);

    List<WorkService> workServices = new ArrayList<WorkService>();
    workServices.add(workService1);
    workServices.add(workService2);

    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            products,
            workServices,
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    List<WorkService> workServices2 = new ArrayList<WorkService>();
    workServices.add(workService1);
    company.setWorkServices(workServices2);
    Assertions.assertEquals(workServices2, company.getWorkServices());
  }

  @Test
  void getUser() {
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
    Assertions.assertEquals(user, company.getUser());
  }

  @Test
  void setUser() {
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
    User user2 = new User("testUsername1", "testPassword1", "TestNam1e", "TestLastname1");
    company.setUser(user2);
    Assertions.assertEquals(user2, company.getUser());
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
    String s = "1223434343";
    Long id = Long.parseLong(s);
    company.setId(id);

    Long test = company.getId();

    Assertions.assertEquals(id, test);
  }

  @Test
  void getName() {
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

    Assertions.assertEquals("TestName", company.getName());
  }

  @Test
  void setName() {
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
    company.setName("TestNam1ewweewe");
    Assertions.assertEquals("TestNam1ewweewe", company.getName());
  }

  @Test
  void getFounder() {
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
    Assertions.assertEquals("TestUser", company.getFounder());
  }

  @Test
  void setFounder() {
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
    company.setFounder("TestNam1ewweewe");
    Assertions.assertEquals("TestNam1ewweewe", company.getFounder());
  }

  @Test
  void getAddress() {
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
    Assertions.assertEquals("Karposh3", company.getAddress());
  }

  @Test
  void setAddress() {
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
    company.setAddress("adresatest");
    Assertions.assertEquals("adresatest", company.getAddress());
  }

  @Test
  void getIncorporationDate() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    LocalDateTime p = LocalDateTime.now();

    Company company =
        new Company(user.getFirstName(), "TestUser", "Karposh3", p, "XYZ", "993-332", user);
    Assertions.assertEquals(p, company.getIncorporationDate());
  }

  @Test
  void setIncorporationDate() {

    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    LocalDateTime p = LocalDateTime.now();

    Company company =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    company.setIncorporationDate(p);
    Assertions.assertEquals(p, company.getIncorporationDate());
  }

  @Test
  void getTaxNumber() {
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
    Assertions.assertEquals("XYZ", company.getTaxNumber());
  }

  @Test
  void setTaxNumber() {
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
    company.setTaxNumber("NewTaxNumber");
    Assertions.assertEquals("NewTaxNumber", company.getTaxNumber());
  }

  @Test
  void getRegisteredNumber() {
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
    Assertions.assertEquals("993-332", company.getRegisteredNumber());
  }

  @Test
  void setRegisteredNumber() {
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
    company.setRegisteredNumber("NewRegNumber");
    Assertions.assertEquals("NewRegNumber", company.getRegisteredNumber());
  }

  @Test
  void getAndSetRevenueFromProducts() {
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
    company.setRevenueFromProducts(100L);

    Assertions.assertEquals(100, company.getRevenueFromProducts());
  }

  @Test
  void getAndSetRevenueFromServices() {
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
    company.setRevenueFromServices(100L);

    Assertions.assertEquals(100, company.getRevenueFromServices());
  }
}
