package com.ustc.train.member.config;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@SpringBootApplication
@ComponentScan("com.ustc")
public class MemberApplication {
    private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MemberApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！");
        LOG.info("地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
