package com.pilogix.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AuthServerApp {

    static ConfigurableApplicationContext context = null;

    public static void main(String[] args) {

        context = SpringApplication.run(AuthServerApp.class, args);
    }
}