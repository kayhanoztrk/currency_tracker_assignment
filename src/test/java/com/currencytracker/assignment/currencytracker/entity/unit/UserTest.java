package com.currencytracker.assignment.currencytracker.entity.unit;

import com.currencytracker.assignment.currencytracker.entity.Role;
import com.currencytracker.assignment.currencytracker.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for {@link User}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class UserTest {

    private User user;
    private Role role;

    @Before
    public void setUp(){
        user = new User();
        role = new Role();

        role.setId(1L);
        role.setRole_name("USER");

        user.setId(1L);
        user.setUsername("user");
        user.setPassword("user");
        user.setRole(Arrays.asList(role));
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getUsername());
        Assert.assertNotNull(user.getPassword());
        Assert.assertNotNull(user.getRole());
    }

    @Test
    public void testAllArgsConstructor(){
        User allArgsUser = new User(1L,"user", "user",
                Arrays.asList(role));

        Assert.assertNotNull(allArgsUser);
    }
}
