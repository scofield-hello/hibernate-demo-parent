package com.chuangdun.hibernate;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author nick
 */
@Log4j2
@SpringBootApplication
public class MyBootApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
