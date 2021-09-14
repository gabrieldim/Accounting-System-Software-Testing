package accountingsystem.main.service;

import accountingsystem.main.model.Company;
import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.User;
import accountingsystem.main.repository.CompanyRepository;
import accountingsystem.main.service.impl.CompanyServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTests {

  @Mock CompanyRepository companyRepository;

  @InjectMocks CompanyServiceImpl companyService;

  @Test
  public void getCompanyByIdTest() {
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
    Long id = company.getId();

    // when
    Mockito.when(companyRepository.findById(id)).thenReturn(java.util.Optional.of(company));

    Company resultCompany = companyService.findById(id).orElseThrow(NoSuchElementException::new);

    // test
    Assert.assertEquals(resultCompany, company);
    Assert.assertEquals("TestUser", resultCompany.getFounder());
    Assert.assertEquals("Karposh3", resultCompany.getAddress());
  }

  @Test
  public void findByNameLikeTest2() {
    // given
    // we define some companies and we add them to a list
    List<Company> list = new ArrayList<Company>();

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

    list.add(company);
    list.add(company1);
    list.add(company2);

    String name = "TestN";

    // when
    Mockito.when(companyRepository.findAllByNameLike(name)).thenReturn(list);

    // then
    List<Company> expectedCompanies = companyService.findByNameLike(name);

    // test
    Assert.assertEquals(3, expectedCompanies.size());
    verify(companyRepository, times(1)).findAllByNameLike(name);
  }

  @Test
  public void getAllCompaniesTest() {
    List<Company> list = new ArrayList<Company>();
    // given
    // we define some companies
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
    // we add them in the predefined list
    list.add(company);
    list.add(company1);
    list.add(company2);

    // when
    Mockito.when(companyRepository.findAll()).thenReturn(list);

    // test
    List<Company> comList = companyService.findAll();
    Assert.assertEquals(3, comList.size());
    verify(companyRepository, times(1)).findAll();
  }

  @Test
  public void findByUserTest() {
    // given
    // we define some companies and we add them to a list
    List<Company> list = new ArrayList<Company>();

    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");

    Company company =
        new Company("Apple", "Steve Jobs", "Atinska", LocalDateTime.now(), "XYZ", "993-332", user);
    Company company1 =
        new Company(
            "Amazon.com", "Jeff Bezos", "Praska", LocalDateTime.now(), "XYZ2", "993-3322", user);
    Company company2 =
        new Company(
            "BMW",
            "Franz Josel Popp",
            "Njudelhiska",
            LocalDateTime.now(),
            "XYZ3",
            "993-3323",
            user);

    list.add(company);
    list.add(company1);
    list.add(company2);

    // when
    Mockito.when(companyRepository.findAllByUser(user)).thenReturn(list);

    // then
    List<Company> expectedCompanies = companyService.findByUser(user);

    // test
    Assert.assertEquals(3, expectedCompanies.size());
    verify(companyRepository, times(1)).findAllByUser(user);
  }

  @Test
  public void createCompanyTest() {
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

    // when
    when(companyRepository.save(any(Company.class))).thenReturn(company);

    Company createdCompany = companyService.save(company);

    // test
    Assert.assertFalse(createdCompany.getName().isEmpty());

    Assert.assertEquals(user, createdCompany.getUser());
    Assert.assertEquals("XYZ", createdCompany.getTaxNumber());
    Assert.assertEquals("993-332", createdCompany.getRegisteredNumber());
    Assert.assertEquals("TestUser", createdCompany.getFounder());
    Assert.assertEquals("Karposh3", createdCompany.getAddress());
  }

  //    @Test
  //    public void deleteCompanyByIdTest() {
  //        //given
  //        User user = new User("testUsername","testPassword","TestName","TestLastname");
  //        Company company = new Company(user.getFirstName(),"TestUser","Karposh3",
  // LocalDateTime.now(),"XYZ","993-332",user);
  //        Long companyId = this.companyRepository.save(company).getId();
  //
  //        //when
  //        when(companyRepository.findById(companyId))
  //       //then
  //                .thenReturn(java.util.Optional.of(company))
  //                .thenReturn(null);
  //
  //        companyService.deleteById(companyId);
  //
  //        //test
  //        verify(companyRepository).deleteById(companyId);
  //
  //
  //
  //    }

}
