package com.currencytracker.assignment.currencytracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String API_URL = "/api/v1/currencyTracker";
    private final UserDetailsService userDetailsService;
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.formLogin();
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers(API_URL + "/currency/create").hasAnyRole("ADMIN")
                .antMatchers(API_URL + "/currency/update").hasAnyRole("ADMIN")
                .antMatchers(API_URL + "/currency/delete/**").hasAnyRole("ADMIN")
                .antMatchers(API_URL + "/currency/list").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/list").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/create/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/update").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/delete/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/close/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(API_URL + "/alert/cancel/**").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeHttpRequests()
                .antMatchers(API_URL + "/alert/list")
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
