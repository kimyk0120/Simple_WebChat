package com.toypwebchat.toyp_webchat.kafka.controller;


import com.toypwebchat.toyp_webchat.kafka.admiinClient.KafkaAdminClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping(value = "/kafka")
public class KafkaAdminController {


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


}
