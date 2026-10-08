package org.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@MapperScan("org.example.demo1.mapper")
public class Demo1Application {

    public static void main(String[] args) {
        System.out.println(new Date() + "测试服务demo1启动开始。");
        SpringApplication.run(Demo1Application.class, args);
        System.out.println(new Date() + "测试服务demo1启动完成。");
    }

}
