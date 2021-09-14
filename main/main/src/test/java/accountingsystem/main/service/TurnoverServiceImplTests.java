package accountingsystem.main.service;

import accountingsystem.main.model.*;
import accountingsystem.main.repository.TurnoverRepository;
import accountingsystem.main.service.impl.TurnoverServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TurnoverServiceImplTests {

  @Mock TurnoverRepository turnoverRepository;

  @InjectMocks TurnoverServiceImpl turnoverService;

  @Test
  public void getAllTurnoversTest() {

    List<Turnover> turnovers = new ArrayList<Turnover>();

    // given
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

    turnovers.add(turnover);
    turnovers.add(turnover1);
    turnovers.add(turnover2);

    // when
    when(turnoverRepository.findAll()).thenReturn(turnovers);

    // test
    List<Turnover> turnList = turnoverService.findAll();
    Assert.assertEquals(3, turnList.size());
    verify(turnoverRepository, times(1)).findAll();
  }

  @Test
  public void getTurnoverById() {

    // given
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

    Long turnoverId = turnover.getId();

    // when
    when(turnoverRepository.findById(turnoverId)).thenReturn(java.util.Optional.of(turnover));

    Turnover turnover1 = turnoverService.findById(turnoverId);

    // test
    Assert.assertEquals(100, turnover1.getNumberProducts().intValue());
    Assert.assertEquals(30l, turnover1.getAmount().longValue());
    Assert.assertEquals(company, turnover1.getCompany());
    Assert.assertEquals(workServiceList, turnover1.getWorkServiceList());
    Assert.assertEquals(productList, turnover1.getProductList());
  }

  @Test
  public void createTurnoverTest() {

    // given
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

    // when
    when(turnoverRepository.save(any(Turnover.class))).thenReturn(turnover);

    Turnover createdTurnover =
        turnoverService.save(
            turnover.getDate(),
            turnover.getNumberProducts(),
            turnover.getAmount(),
            turnover.getWorkServiceList(),
            turnover.getProductList(),
            turnover.getCompany());

    Assert.assertNotNull(createdTurnover.getNumberProducts());

    Assert.assertEquals(100, createdTurnover.getNumberProducts().intValue());

    Assert.assertEquals(30l, createdTurnover.getAmount().longValue());
  }

  @Test
  public void deleteTurnoverById() {

    // given
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

    Long turnoverId = turnover.getId();

    when(turnoverRepository.findById(turnoverId))
        .thenReturn(java.util.Optional.of(turnover))
        .thenReturn(null);

    turnoverService.deleteById(turnoverId);

    // test
    verify(turnoverRepository).deleteById(turnoverId);
  }

  //    @Test
  //    public void getTotalTurnoverTest() {
  //        List<Turnover> turnovers = new ArrayList<Turnover>();
  //
  //        //given
  //        User user = new User("testUsername","testPassword","TestName","TestLastname");
  //        Company company = new Company(user.getFirstName(),"TestUser","Karposh3",
  // LocalDateTime.now(),"XYZ","993-332",user);
  //        WorkService workService = new WorkService("testName","testDescription",150l);
  //        WorkService workService2 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList = new ArrayList<>();
  //        workServiceList.add(workService);
  //        workServiceList.add(workService2);
  //        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
  //        Product product = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer1 = new Manufacturer("TestUser","MKD");
  //        Product product1 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList = new ArrayList<>();
  //        productList.add(product);
  //        productList.add(product1);
  //        Turnover turnover = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList,productList,company);
  //
  //        User user2 = new User("testUsername","testPassword","TestName","TestLastname");
  //        WorkService workService4 = new WorkService("testName","testDescription",150l);
  //        WorkService workService5 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList1 = new ArrayList<>();
  //        workServiceList.add(workService4);
  //        workServiceList.add(workService5);
  //        Manufacturer manufacturer2 = new Manufacturer("TestUser","MKD");
  //        Product product3 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer3 = new Manufacturer("TestUser","MKD");
  //        Product product2 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList1 = new ArrayList<>();
  //        productList.add(product3);
  //        productList.add(product2);
  //        Turnover turnover1 = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList1,productList1,company);
  //
  //
  //        User user3 = new User("testUsername","testPassword","TestName","TestLastname");
  //        WorkService workService6 = new WorkService("testName","testDescription",150l);
  //        WorkService workService7 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList3 = new ArrayList<>();
  //        workServiceList.add(workService);
  //        workServiceList.add(workService2);
  //        Manufacturer manufacturer4 = new Manufacturer("TestUser","MKD");
  //        Product product5 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer5 = new Manufacturer("TestUser","MKD");
  //        Product product6 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList3 = new ArrayList<>();
  //        productList.add(product5);
  //        productList.add(product6);
  //        Turnover turnover2 = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList3,productList3,company);
  //
  //
  //         turnovers.add(turnover);
  //         turnovers.add(turnover1);
  //         turnovers.add(turnover2);
  //
  //        Double sum = Double.valueOf(turnover.getAmount() + turnover1.getAmount()  +
  // turnover2.getAmount());
  //
  //         //when
  //         when(turnoverRepository.calculateTotalTurnover(company)).thenReturn(sum);
  //
  //         //test
  //        Assert.assertEquals(sum,turnoverService.getTotalTurnover(company.getId()));
  //    }

  //    @Test
  //    public void findByCompanyAndMonthTest() {
  //
  //        String name = "product";
  //
  //        List<Turnover> turnovers = new ArrayList<Turnover>();
  //
  //        //given
  //        User user = new User("testUsername","testPassword","TestName","TestLastname");
  //        Company company = new Company(user.getFirstName(),"TestUser","Karposh3",
  // LocalDateTime.now(),"XYZ","993-332",user);
  //        WorkService workService = new WorkService("testName","testDescription",150l);
  //        WorkService workService2 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList = new ArrayList<>();
  //        workServiceList.add(workService);
  //        workServiceList.add(workService2);
  //        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
  //        Product product = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer1 = new Manufacturer("TestUser","MKD");
  //        Product product1 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList = new ArrayList<>();
  //        productList.add(product);
  //        productList.add(product1);
  //        Turnover turnover = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList,productList,company);
  //
  //        User user2 = new User("testUsername","testPassword","TestName","TestLastname");
  //        WorkService workService4 = new WorkService("testName","testDescription",150l);
  //        WorkService workService5 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList1 = new ArrayList<>();
  //        workServiceList.add(workService4);
  //        workServiceList.add(workService5);
  //        Manufacturer manufacturer2 = new Manufacturer("TestUser","MKD");
  //        Product product3 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer3 = new Manufacturer("TestUser","MKD");
  //        Product product2 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList1 = new ArrayList<>();
  //        productList.add(product3);
  //        productList.add(product2);
  //        Turnover turnover1 = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList1,productList1,company);
  //
  //
  //        User user3 = new User("testUsername","testPassword","TestName","TestLastname");
  //        WorkService workService6 = new WorkService("testName","testDescription",150l);
  //        WorkService workService7 = new WorkService("testName","testDescription",150l);
  //        List<WorkService> workServiceList3 = new ArrayList<>();
  //        workServiceList.add(workService);
  //        workServiceList.add(workService2);
  //        Manufacturer manufacturer4 = new Manufacturer("TestUser","MKD");
  //        Product product5 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        Manufacturer manufacturer5 = new Manufacturer("TestUser","MKD");
  //        Product product6 = new Product("productDescription","productName",manufacturer,150l,
  // LocalDateTime.now(),LocalDateTime.now());
  //        List<Product> productList3 = new ArrayList<>();
  //        productList.add(product5);
  //        productList.add(product6);
  //        Turnover turnover2 = new
  // Turnover(LocalDateTime.now(),100,30l,workServiceList3,productList3,company);
  //
  //
  //         turnovers.add(turnover);
  //         turnovers.add(turnover1);
  //         turnovers.add(turnover2);
  //
  //         Long companyId = company.getId();
  //
  //        //when
  //
  // when(turnoverRepository.getAllByCompanyAndDateIsContaining(company,LocalDateTime.now())).thenReturn(turnovers);
  //
  //        List<Turnover> expectedTurnovers = turnoverService.getAllByCompanyAndMonth(companyId,
  // LocalDateTime.now());
  //
  //        //test
  //        Assert.assertEquals(3, expectedTurnovers.size());
  //        verify(turnoverRepository, times(1)).getAllByCompanyAndDateIsContaining(company,
  //                LocalDateTime.now());
  //
  //
  //    }

}
