package com.tzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author TangZongHua
 * @date 2020/10/14
 * @description: spring boot 入口程序
 */
@EnableSwagger2
@SpringBootApplication
public class AppManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppManagerApplication.class, args);
    }

}
