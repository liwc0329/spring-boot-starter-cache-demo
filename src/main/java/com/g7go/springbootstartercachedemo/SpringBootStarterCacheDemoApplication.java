package com.g7go.springbootstartercachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author lwc
 */
@EnableCaching
@SpringBootApplication
public class SpringBootStarterCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterCacheDemoApplication.class, args);
    }

}
