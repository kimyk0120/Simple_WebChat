package com.toypwebchat.toyp_webchat.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    private final KafkaAdminClient kafkaAdminClient;

    public KafkaController(KafkaProducer producer, KafkaAdminClient kafkaAdminClient) {
        this.producer = producer;
        this.kafkaAdminClient = kafkaAdminClient;
    }


    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {

        this.producer.sendMessage(message);

        return "success";
    }


    @GetMapping(value = "/create-topics")
    public String createTopic() {
        KafkaAdminClient.createTopics("test3");
        return "success";
    }

    @GetMapping(value = "/delete-topics")
    public String deleteTopic() {
        KafkaAdminClient.deleteTopics("test3");
        return "success";
    }

    @GetMapping(value = "/get-topics")
    public String getTopic() throws ExecutionException, InterruptedException {
        KafkaAdminClient.getTopics();
        return "success";
    }
}
