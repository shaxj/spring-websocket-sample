package com.xiaojie.sample.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author xiaojie.sha
 * @date 2018/9/5
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        MongoAutoConfiguration.class})
public class WSMarbleMain {

    private static final Logger logger = LoggerFactory.getLogger(WSMarbleMain.class);

    public static String PROJECT_NAME = "ws-marble";

    public static void main(String[] args) {
        SpringApplication.run(WSMarbleMain.class, args);
    }
}
