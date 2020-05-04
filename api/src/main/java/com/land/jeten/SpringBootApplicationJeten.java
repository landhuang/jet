package com.land.jeten;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * java -jar service01-1.0-SNAPSHOT.jar --spring.profiles.active=pro --server.port=8080
 * java -Dserver.port=8080 -Dspring.profiles.active=pro -jar service01-1.0-SNAPSHOT1.jar
 *
 *
 */
@SpringBootApplication
@MapperScan("com.land.jeten.*.mapper")
public class SpringBootApplicationJeten {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationJeten.class, args);
  }
}
