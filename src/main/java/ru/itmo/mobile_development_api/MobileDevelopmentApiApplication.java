package ru.itmo.mobile_development_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MobileDevelopmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileDevelopmentApiApplication.class, args);
    }

}
