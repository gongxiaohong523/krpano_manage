package com.example.krpano;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Slf4j
//@EnableTransactionManagement//开启事务支持,默认为开启状态,可以不用标明
public class ExampleKrpanoApplication {

    public static void main(String[] args) throws  InterruptedException{
        ConfigurableApplicationContext context = SpringApplication.run(ExampleKrpanoApplication.class, args);
        // 避免服务直接exit
        CountDownLatch closeDown = context.getBean(CountDownLatch.class);
        log.info("===============服务启动完成=================");
        closeDown.await();
    }
}
