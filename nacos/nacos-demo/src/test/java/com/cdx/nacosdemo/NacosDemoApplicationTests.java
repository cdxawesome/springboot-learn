package com.cdx.nacosdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NacosDemoApplicationTests {

    /**
     * 获取Nacos配置中心的配置文件中的数据
     */
    @Value("${name}")
    private String name;

    @Test
    public void testNacosConfig() {
        System.out.println("name: " + name);
    }

}
