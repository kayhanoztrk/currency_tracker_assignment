package com.currencytracker.assignment.currencytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencytrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencytrackerApplication.class, args);
    }
}
