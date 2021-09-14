package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static accountingsystem.main.model.Role.ROLE_ADMIN;
import static org.junit.jupiter.api.Assertions.*;

class UserPitTests {

  @Test
  void EmptyConstructor() {
    User user = new User();
    Assertions.assertEquals(null, user.getId());
  }

  @Test
  void getAndSetId() {

    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    String s = "1223434343";
    Long id = Long.parseLong(s);
    user.setId(id);

    Long test = user.getId();

    Assertions.assertEquals(id, test);
  }

  @Test
  void getUsername() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Assertions.assertEquals("testUsername", user.getUsername());
  }

  @Test
  void isAccountNonExpired() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    boolean accountNonExpired = user.isAccountNonExpired();
    user.setAccountNonExpired(true);
    Assertions.assertEquals(true, accountNonExpired);
  }

  @Test
  void isAccountNonLocked() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    boolean accountNonLocked = user.isAccountNonLocked();
    user.setAccountNonLocked(true);
    Assertions.assertEquals(true, accountNonLocked);
  }

  @Test
  void isCredentialsNonExpired() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    boolean credentialsNonExpired = user.isCredentialsNonExpired();
    user.setCredentialsNonExpired(true);
    Assertions.assertEquals(true, credentialsNonExpired);
  }

  @Test
  void isEnabled() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    boolean enabled = user.isEnabled();
    user.setEnabled(true);
    Assertions.assertEquals(true, enabled);
  }

  @Test
  void setUsername() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    user.setUsername("NewUsername");

    Assertions.assertEquals("NewUsername", user.getUsername());
  }

  @Test
  void getAuthorities() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Assertions.assertEquals(
        user.getAuthorities().toString(), "[" + Role.ROLE_USER.getAuthority().toString() + "]");
  }

  @Test
  void getPassword() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Assertions.assertEquals("testPassword", user.getPassword());
  }

  @Test
  void setPassword() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    user.setPassword("Newpassword");
    Assertions.assertEquals("Newpassword", user.getPassword());
  }

  @Test
  void getFirstName() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Assertions.assertEquals("TestName", user.getFirstName());
  }

  @Test
  void setFirstName() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    user.setFirstName("NewFirstName");
    Assertions.assertEquals("NewFirstName", user.getFirstName());
  }

  @Test
  void getLastName() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    Assertions.assertEquals("TestLastname", user.getLastName());
  }

  @Test
  void setLastName() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    user.setLastName("NewLastName");
    Assertions.assertEquals("NewLastName", user.getLastName());
  }

  @Test
  void getAndSetCompanies() {
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

    Company company1 =
        new Company(
            user.getFirstName(),
            "TestUser",
            "Karposh3",
            LocalDateTime.now(),
            "XYZ",
            "993-332",
            user);

    List<Company> companies = new ArrayList<Company>();
    companies.add(company);
    companies.add(company1);
    user.setCompanies(companies);
    Assertions.assertEquals(companies, user.getCompanies());
  }

  @Test
  void getAndSetRole() {
    User user = new User("testUsername", "testPassword", "TestName", "TestLastname");
    user.setRole(ROLE_ADMIN);
    Assertions.assertEquals(ROLE_ADMIN, user.getRole());
  }

  @Test
  void setRole() {}
}
