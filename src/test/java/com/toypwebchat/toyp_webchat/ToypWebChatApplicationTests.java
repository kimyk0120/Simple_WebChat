package com.toypwebchat.toyp_webchat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class ToypWebChatApplicationTests {


    @Value("${test}")
    private String testString;

    @Test
    void test() throws Exception{

        log.info("test");
        log.info(testString);
    }

}
