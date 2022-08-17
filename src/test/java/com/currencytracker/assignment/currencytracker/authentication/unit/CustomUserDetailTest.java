package com.currencytracker.assignment.currencytracker.authentication.unit;

import com.currencytracker.assignment.currencytracker.authentication.CustomUserDetail;
import com.currencytracker.assignment.currencytracker.entity.Role;
import com.currencytracker.assignment.currencytracker.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

/**
 * Unit test for {@link CustomUserDetail}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class CustomUserDetailTest {

    private CustomUserDetail customUserDetail;
    private User user;
    private Role role;

    @Before
    public void setUp() {

        role = new Role();
        role.setId(1L);
        role.setRole_name("USER");

        user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setPassword("user");
        user.setRole(Arrays.asList());

        customUserDetail = new CustomUserDetail(user);
    }

    @Test
    public void testGetAuthorities() {
        Collection<? extends GrantedAuthority> collection = customUserDetail.getAuthorities();
        Assert.assertNotNull(collection);
    }

    @Test
    public void testGetPassword() {
        String password = customUserDetail.getPassword();
        Assert.assertNotNull(password);
    }

    @Test
    public void testGetUsername() {
        String username = customUserDetail.getUsername();
        Assert.assertNotNull(username);
    }

    @Test
    public void testIsAccountNonExpired() {
        boolean isAccountNonExpired = customUserDetail.isAccountNonExpired();
        Assert.assertNotNull(isAccountNonExpired);
    }

    @Test
    public void testIsAccountNonLocked() {
        boolean isAccountNonLocked = customUserDetail.isAccountNonLocked();
        Assert.assertNotNull(isAccountNonLocked);
    }

    @Test
    public void testIsCredentialsNonExpired() {
        boolean isCredentialsNonExpired = customUserDetail.isCredentialsNonExpired();
        Assert.assertNotNull(isCredentialsNonExpired);
    }

    @Test
    public void testIsEnabled() {
        boolean isEnabled = customUserDetail.isEnabled();
        Assert.assertNotNull(isEnabled);
    }
}
