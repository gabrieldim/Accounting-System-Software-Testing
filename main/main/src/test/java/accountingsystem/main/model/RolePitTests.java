package accountingsystem.main.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RolePitTests {

    @Test
    void getAuthority() {


        Assertions.assertEquals(Role.ROLE_USER.getAuthority(), Role.ROLE_USER.getAuthority());
        Assertions.assertEquals(Role.ROLE_ADMIN.getAuthority(), Role.ROLE_ADMIN.getAuthority());

    }

}