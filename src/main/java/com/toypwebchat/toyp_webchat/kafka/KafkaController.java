package com.toypwebchat.toyp_webchat.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }


    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {

        this.producer.sendMessage(message);

        return "success";
    }


    @GetMapping(value = "/create-topics")
    public String createTopic() {
        KafkaAdminClient.createTopics("test2");
        return "success createTopic";
    }

    @GetMapping(value = "/delete-topics/{topicName}")
    public String deleteTopic(@PathVariable String topicName) {
        KafkaAdminClient.deleteTopics(topicName);
        return "success deleteTopic";
    }

    @GetMapping(value = "/delete-all-topics")
    public String deleteAllTopic() throws ExecutionException, InterruptedException {
        KafkaAdminClient.deleteAllTopics();
        return "success deleteAllTopic";
    }


    @GetMapping(value = "/get-topics")
    public String getTopic() throws ExecutionException, InterruptedException {
        KafkaAdminClient.getTopics();
        return "success getTopic";
    }

    @GetMapping(value = "/adminclient/close")
    public String close() {
        KafkaAdminClient.close();
        return "success close";
    }

}
