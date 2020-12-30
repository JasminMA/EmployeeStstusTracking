package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@PropertySources(value = {
        @PropertySource(ignoreResourceNotFound = true, value = "classpath:properties/application.properties")})
public class EmployeeTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeTrackingApplication.class, args);
    }

}
