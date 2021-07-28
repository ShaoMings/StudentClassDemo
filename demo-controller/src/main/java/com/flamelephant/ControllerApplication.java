package com.flamelephant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description TODO
 *
 * @author shaoming
 * @date 2021/7/27 16:29
 * @since 1.0
 **/
@MapperScan(basePackages = {"com.flamelephant.mapper"})
@SpringBootApplication(scanBasePackages = {"com.flamelephant.service",
        "com.flamelephant.mapper","com.flamelephant.controller",
        "com.flamelephant.config","com.flamelephant.handle"})
public class ControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class,args);
    }
}
