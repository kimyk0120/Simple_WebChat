package com.toypwebchat.toyp_webchat.kafka.controller;


import com.toypwebchat.toyp_webchat.kafka.admiinClient.KafkaAdminClient;
import com.toypwebchat.toyp_webchat.kafka.producer.KafkaProducer;
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
    public String sendMessage(@RequestParam("topicname") String topicname , @RequestParam("message") String message) {

        this.producer.sendMessage(topicname, message);

        return "success";
    }


    @GetMapping(value = "/create-topic/{topicNm}")
    public String createTopic(@PathVariable String topicNm) {
        KafkaAdminClient.createTopics(topicNm);
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

    @GetMapping(value = "/dynamic-comsumer")
    public String dynamicComsumer() {
        KafkaAdminClient.dynamicComsumer();
        return "dynamicComsumer";
    }

}
