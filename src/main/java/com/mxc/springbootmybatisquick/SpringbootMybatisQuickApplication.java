package com.mxc.springbootmybatisquick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringbootMybatisQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisQuickApplication.class, args);
    }

}
