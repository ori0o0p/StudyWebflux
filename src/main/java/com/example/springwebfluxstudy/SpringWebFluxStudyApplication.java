package com.example.springwebfluxstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringWebFluxStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxStudyApplication.class, args);
    }

}
