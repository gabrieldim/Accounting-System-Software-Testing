package accountingsystem.main.repository;

import accountingsystem.main.model.Company;
import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import accountingsystem.main.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/** Tests for the Company Repository. */
@DataJpaTest
@RunWith(SpringRunner.class)
public class CompanyRepositoryTests {

  @Autowired private CompanyRepository companyRepository;
  /** Tests if a company is saved correctly in the database. */
  @Test
  public void saveCompanyTest() {
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
    //        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
    //        Product product = new
    // Product("testProduct","testName",manufacturer,50l,LocalDateTime.now(),LocalDateTime.now());
    //        Product product1 = new
    // Product("testProduct2","testName2",manufacturer,50l,LocalDateTime.now(),LocalDateTime.now());
    //        company.getProducts().add(product);
    //        company.getProducts().add(product1);
    Long companyId = this.companyRepository.save(company).getId();
    Company company1 = this.companyRepository.findById(companyId).get();

    Assert.assertNotNull(company);
    Assert.assertEquals(company.getId(), company1.getId());
    Assert.assertEquals(company.getSoldServices(), company1.getSoldServices());
    Assert.assertEquals(company.getProducts(), company1.getProducts());
    //        IntStream.of(company.getProducts().size()).forEach(i -> {
    //            Assert.assertEquals(company.getProducts().get(i),company1.getProducts().get(i));
    //        });
    Assert.assertEquals(company.getRevenueFromProducts(), company1.getRevenueFromProducts());
    Assert.assertEquals(company.getRevenueFromServices(), company1.getRevenueFromServices());
    Assert.assertEquals(company.getRegisteredNumber(), company1.getRegisteredNumber());
    Assert.assertEquals(company.getIncorporationDate(), company1.getIncorporationDate());
    Assert.assertEquals(company.getFounder(), company1.getFounder());
    Assert.assertEquals(company.getAddress(), company1.getAddress());
    Assert.assertEquals(company.getWorkServices(), company1.getWorkServices());
    Assert.assertEquals(company.getSoldProducts(), company1.getSoldProducts());
    Assert.assertEquals(company.getTaxNumber(), company1.getTaxNumber());
    Assert.assertEquals(company.getUser(), company1.getUser());
  }

  /** Tests if a company is deleted correctly in the database. */
  @Test
  public void deleteCompanyTest() {
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
    Long companyId = this.companyRepository.save(company).getId();
    this.companyRepository.deleteById(companyId);

    Assert.assertThrows(
        NoSuchElementException.class,
        () -> {
          this.companyRepository.findById(companyId).get();
        });
  }

  /** Tests the find all companies method. */
  @Test
  public void findAllCompaniesTest() {
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

    User user1 = new User("testUsername1", "testPassword1", "TestName1", "TestLastname1");
    Company company1 =
        new Company(
            user1.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ2",
            "993-3322",
            user1);

    User user2 = new User("testUsername2", "testPassword2", "TestName2", "TestLastname2");
    Company company2 =
        new Company(
            user2.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ3",
            "993-3323",
            user2);

    this.companyRepository.save(company);
    this.companyRepository.save(company1);
    this.companyRepository.save(company2);

    Assert.assertNotNull(this.companyRepository.findAll());
    Assert.assertEquals(3, this.companyRepository.findAll().stream().count());
  }
}
