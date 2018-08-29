package com.sayo.girl.repository;

import com.sayo.girl.config.SystemParams;
import com.sayo.girl.domain.User;
import com.sayo.girl.domain.UserRole;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void testQueryUserOwnedRoleCodes() {

        UserRole userRole1 = new UserRole();
        userRole1.setRoleCode("admin");
        userRole1.setRoleDescription("admin role");
        UserRole userRole2 = new UserRole();
        userRole2.setRoleCode("staff");
        userRole2.setRoleDescription("staff role");
        userRoleRepository.save(userRole1);userRoleRepository.save(userRole2);
        User user1 = new User();
        user1.setUserName("sayo");
        user1.setUserDescription("admin");
        List<UserRole> roles1 = new ArrayList<>(Arrays.asList(userRole1,userRole2));
        user1.setRoles(roles1);
        User user2 = new User();
        user2.setUserName("Ly");
        user2.setUserDescription("staff");
        List<UserRole> roles2 = new ArrayList<>(Arrays.asList(userRole2));
        user2.setRoles(roles2);
        userRepository.save(user1);
        userRepository.save(user2);

        List<String> codeList = userRepository.queryUserOwnedRoleCodes("sayo");
        Assert.assertEquals(codeList.size(), 2);
    }
}
