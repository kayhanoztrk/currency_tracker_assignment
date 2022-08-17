package com.currencytracker.assignment.currencytracker.entity.unit;

import com.currencytracker.assignment.currencytracker.entity.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Role}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class RoleTest {

    private Role role;
    @Before
    public void setUp(){
        role = new Role();
        role.setId(1L);
        role.setRole_name("ADMIN");
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(role);
        Assert.assertNotNull(role.getId());
        Assert.assertNotNull(role.getRole_name());
    }

    @Test
    public void testAllArgsConstructor(){
        Role allArgsRole = new Role(1L, "USER");
        Assert.assertNotNull(allArgsRole);
    }
}
