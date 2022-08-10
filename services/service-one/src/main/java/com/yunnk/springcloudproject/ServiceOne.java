package com.yunnk.springcloudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangyigang
 * springboot启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.yunnk"})
public class ServiceOne {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOne.class, args);
    }
}
