package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = {
        @PropertySource(ignoreResourceNotFound = true, value = "classpath:properties/application.properties")})
public class EmployeeTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeTrackingApplication.class, args);
    }

}
