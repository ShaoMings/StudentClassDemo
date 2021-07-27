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
@SpringBootApplication
@MapperScan(basePackages = {"com.flamelephant.mapper"})
public class ControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class,args);
    }
}
