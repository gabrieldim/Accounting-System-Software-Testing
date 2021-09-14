package accountingsystem.main.repository;

import accountingsystem.main.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TurnoverRepositoryTests {
  @Autowired public TurnoverRepository turnoverRepository;

  @Test
  public void saveTurnoverTest() {
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
    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
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
    Long turnoverId = this.turnoverRepository.save(turnover).getId();
    Turnover turnover1 = this.turnoverRepository.findById(turnoverId).get();

    Assert.assertNotNull(turnover);
    Assert.assertEquals(turnover.getId(), turnover.getId());
    Assert.assertEquals(turnover.getAmount(), turnover.getAmount());
    Assert.assertEquals(turnover.getCompany(), turnover.getCompany());
    Assert.assertEquals(turnover.getDate(), turnover.getDate());
    Assert.assertEquals(turnover.getNumberProducts(), turnover.getNumberProducts());
    Assert.assertEquals(turnover.getProductList(), turnover.getProductList());
    Assert.assertEquals(turnover.getWorkServiceList(), turnover.getWorkServiceList());
  }

  @Test
  public void deleteTurnoverTest() {
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
    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
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
    Long turnoverId = this.turnoverRepository.save(turnover).getId();
    this.turnoverRepository.deleteById(turnoverId);
    Assert.assertThrows(
        NoSuchElementException.class,
        () -> {
          this.turnoverRepository.findById(turnoverId).get();
        });
  }

  @Test
  public void findAllTurnoversTest() {
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
    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
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

    User user2 = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company2 =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService4 = new WorkService("testName", "testDescription", 150l);
    WorkService workService5 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList1 = new ArrayList<>();
    workServiceList.add(workService4);
    workServiceList.add(workService5);
    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product3 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Manufacturer manufacturer3 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList1 = new ArrayList<>();
    productList.add(product3);
    productList.add(product2);
    Turnover turnover1 =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList1, productList1, company2);

    User user3 = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Company company3 =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);
    WorkService workService6 = new WorkService("testName", "testDescription", 150l);
    WorkService workService7 = new WorkService("testName", "testDescription", 150l);
    List<WorkService> workServiceList3 = new ArrayList<>();
    workServiceList.add(workService);
    workServiceList.add(workService2);
    Manufacturer manufacturer4 = new Manufacturer("TestUser", "MKD");
    Product product5 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Manufacturer manufacturer5 = new Manufacturer("TestUser", "MKD");
    Product product6 =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    List<Product> productList3 = new ArrayList<>();
    productList.add(product5);
    productList.add(product6);
    Turnover turnover2 =
        new Turnover(LocalDateTime.now(), 100, 30l, workServiceList3, productList3, company3);

    this.turnoverRepository.save(turnover);
    this.turnoverRepository.save(turnover1);
    this.turnoverRepository.save(turnover2);

    Assert.assertNotNull(this.turnoverRepository.findAll());
    Assert.assertEquals(3, this.turnoverRepository.findAll().stream().count());
  }
}
