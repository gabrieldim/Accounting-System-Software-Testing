package accountingsystem.main.service;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.User;
import accountingsystem.main.repository.UserRepository;
import accountingsystem.main.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {

  @Mock UserRepository userRepository;

  @Mock PasswordEncoder passwordEncoder;

  @InjectMocks UserServiceImpl userService;

  @Test
  public void getUserByUsernameTest() {

    String username = "usernameTest";

    User user = new User("usernameTest", "passwordTest", "firstNameTest", "lastNameTest");

    // when
    when(userRepository.findByUsername(username)).thenReturn(java.util.Optional.of(user));

    // then
    User user1 = userService.findByUsername(username);
    Assert.assertEquals("firstNameTest", user1.getFirstName());
    Assert.assertEquals("lastNameTest", user1.getLastName());
    verify(userRepository, times(1)).findByUsername(username);
  }
}
