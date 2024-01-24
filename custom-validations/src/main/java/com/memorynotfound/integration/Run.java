package com.memorynotfound.integration;

import com.memorynotfound.integration.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.memorynotfound.integration.OrderSender;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Run implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(Run.class);

    @Autowired
    private OrderSender orderSender;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring JMS ActiveMQ Validate Messages using @Valid Example");

        orderSender.sendQueue(new Order("Ahmad", "ahmad10",  new BigDecimal(99)));
        orderSender.sendQueue(new Order("Syed", "SYED11",  new BigDecimal(48)));
        orderSender.sendQueue(new Order("Chris", "Chris17",  new BigDecimal(73)));
        orderSender.sendQueue(new Order("Ankit", "Ankit_12", new BigDecimal(2)));

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
