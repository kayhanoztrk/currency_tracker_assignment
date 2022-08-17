package com.currencytracker.assignment.currencytracker.authentication.unit;

import com.currencytracker.assignment.currencytracker.authentication.CustomUserDetailsService;
import com.currencytracker.assignment.currencytracker.entity.Role;
import com.currencytracker.assignment.currencytracker.entity.User;
import com.currencytracker.assignment.currencytracker.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link CustomUserDetailsService}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class CustomUserDetailsServiceTest {

    private CustomUserDetailsService customUserDetailsService;
    private UserRepository userRepository;
    private User user;
    private Role role;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        customUserDetailsService = new CustomUserDetailsService(userRepository);

        role = new Role();
        role.setId(1L);
        role.setRole_name("USER");

        user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setPassword("user");
        user.setRole(Arrays.asList(role));

        when(userRepository.findByUsername(anyString())).thenReturn(user);
    }

    @Test
    public void testLoadUserByUsername() {
        UserDetails userDetails =customUserDetailsService.loadUserByUsername("user");
        Assert.assertNotNull(userDetails);
    }
}
