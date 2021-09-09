package accountingsystem.main.model.views;

import accountingsystem.main.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurnoverByMonthViewPitTests {

    @Test
    void EmptyConstructor() {
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView();
        Assertions.assertEquals(null, turnoverByMonthView.getMonth());

    }

    @Test
    void getAndSetProductList() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setProductList(productList);
        Assertions.assertEquals(productList,turnoverByMonthView.getProductList());
    }

    @Test
    void getAndSetWorkServicesList() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setWorkServicesList(workServiceList);
        Assertions.assertEquals(workServiceList,turnoverByMonthView.getWorkServicesList());
    }



    @Test
    void getAndSetCompanyId() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setCompanyId(3l);
        Assertions.assertEquals(3l,turnoverByMonthView.getCompanyId());
    }


    @Test
    void getAndSetMonth() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setMonth(4l);
        Assertions.assertEquals(4l,turnoverByMonthView.getMonth());
    }


    @Test
    void getAndSetYear() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setYear(2000l);
        Assertions.assertEquals(2000l,turnoverByMonthView.getYear());
    }


    @Test
    void getAndSetAmount() {
        User user = new User("testUsername","testPassword","TestName","TestLastname");
        Company company = new Company(user.getFirstName(),"TestUser","Karposh3", LocalDateTime.now(),"XYZ","993-332",user);
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);
        List<WorkService> workServiceList = new ArrayList<>();
        workServiceList.add(workService);
        workServiceList.add(workService2);
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Product product = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        Product product1 = new Product("productDescription","productName",manufacturer,150l, LocalDateTime.now(),LocalDateTime.now());
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        TurnoverByMonthView turnoverByMonthView = new TurnoverByMonthView(productList,workServiceList,3L,1999L,123456L);
        turnoverByMonthView.setAmount(98765432l);
        Assertions.assertEquals(98765432l,turnoverByMonthView.getAmount());
    }


}