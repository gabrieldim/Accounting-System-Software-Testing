package accountingsystem.main.repository;

import accountingsystem.main.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {
    //String username, String password, String firstName, String lastName

    @Autowired
    public UserRepository userRepository;

    @Test
    public void saveUserTest(){
        User user = new User("usernameTest","passwordTest","firstNameTest","lastNameTest");
        Long userId = this.userRepository.save(user).getId();
        User user1 = this.userRepository.findById(userId).get();

        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(),user1.getId());
        Assert.assertEquals(user.getUsername(),user1.getUsername());
        Assert.assertEquals(user.getPassword(),user1.getPassword());
        Assert.assertEquals(user.getFirstName(),user1.getFirstName());
        Assert.assertEquals(user.getLastName(),user1.getLastName());

    }

    @Test
    public void deleteUserTest(){
        User user = new User("usernameTest","passwordTest","firstNameTest","lastNameTest");
        Long userId = this.userRepository.save(user).getId();
        this.userRepository.deleteById(userId);

        Assert.assertThrows(NoSuchElementException.class, () -> {
            this.userRepository.findById(userId).get();
        });
    }

    @Test
    public void findAllUsersTest(){
        User user = new User("usernameTest","passwordTest","firstNameTest","lastNameTest");
        User user1 = new User("usernameTest1","passwordTest1","firstNameTest1","lastNameTest1");
        User user2 = new User("usernameTest2","passwordTest2","firstNameTest2","lastNameTest2");

        this.userRepository.save(user);
        this.userRepository.save(user1);
        this.userRepository.save(user2);

        Assert.assertNotNull(this.userRepository.findAll());
        Assert.assertEquals(3,this.userRepository.findAll().stream().count());
    }




}
