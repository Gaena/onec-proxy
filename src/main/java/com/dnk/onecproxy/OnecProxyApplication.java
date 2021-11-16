package com.dnk.onecproxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OnecProxyApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(OnecProxyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
