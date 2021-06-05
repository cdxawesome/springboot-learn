package com.cdx.nacosdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NacosDemoApplicationTests {

    @Value("${name}")
    private String name;

    @Test
    public void testNacosConfig() {
        System.out.println("name: " + name);
    }

}
