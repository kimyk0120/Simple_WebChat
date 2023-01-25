package com.toypwebchat.toyp_webchat.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class KafkaAdminClient {

    private static String BOOTSTRAP_SERVER;

    private static AdminClient client;

    @Value("${spring.kafka.bootstrap-servers}")
    public void setBootstrapServer(String bootstrapServer) {
        BOOTSTRAP_SERVER = bootstrapServer;
    }

    @PostConstruct
    public void KafkaAdminClient() {
        if (client == null) {
            Properties properties = new Properties();
            properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
            client = AdminClient.create(properties);
        }
    }

    public static void close() {
        if (client != null) {
            client.close();
            client = null;
        }
    }

    public static void createTopics(String topicName) {
        NewTopic newTopic = TopicBuilder.name(topicName).partitions(1).replicas(1).build();
        client.createTopics(new ArrayList<>() {{
            add(newTopic);
        }});
    }

    public static void deleteTopics(String topicName) {
        client.deleteTopics(new ArrayList<>() {{
            add(topicName);
        }});
    }


    public static void getTopics() throws ExecutionException, InterruptedException {
        ListTopicsResult listTopicsResult = client.listTopics();
        KafkaFuture<Map<String, TopicListing>> mapKafkaFuture = listTopicsResult.namesToListings();
        Map<String, TopicListing> stringTopicListingMap = mapKafkaFuture.get();
        stringTopicListingMap.forEach((k, v) -> {
            log.info("k : " + k);
            log.info("v : " + v);
        });
    }

}
