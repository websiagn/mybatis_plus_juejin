package com.example.mybatis_plus_juejin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.mybatis_plus_juejin.mapper")
@SpringBootApplication
public class MybatisPlusJuejinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusJuejinApplication.class, args);
    }

}
