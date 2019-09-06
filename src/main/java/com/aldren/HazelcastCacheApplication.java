package com.aldren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@EnableEurekaClient
/**
 * Never do this in Production.
 * Always make sure that your application is secure, and
 * enable security where possible.
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HazelcastCacheApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HazelcastCacheApplication.class, args);
    }
}
