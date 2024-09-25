package com.taibiex.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync

@SpringBootApplication
public class TaibiexTaskServiceApplication {

    public static void main(String[] args) {


            /*System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "7890");
            System.setProperty("https.proxyHost", "127.0.0.1");
            System.setProperty("https.proxyPort", "7890");*/


        SpringApplication.run(TaibiexTaskServiceApplication.class, args);
    }
}
