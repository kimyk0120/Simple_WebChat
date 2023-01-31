package com.toypwebchat.toyp_webchat.kafka.admiinClient;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@SuppressWarnings("DuplicatedCode")
@Slf4j
@Component
public class KafkaAdminClient {

    private static String BOOTSTRAP_SERVER;

    private static AdminClient client;

    public static DescribeTopicsResult describeTopics(String topicName) {
        return client.describeTopics(Collections.singleton(topicName));
    }


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

    public static CreateTopicsResult createTopics(String topicName) {
        NewTopic newTopic = TopicBuilder.name(topicName).partitions(1).replicas(1).build();
        CreateTopicsResult topicsResult = client.createTopics(Collections.singleton(newTopic));
        topicsResult.all().whenComplete((result, exception) -> {
            if (exception != null) {
                log.error("createTopics error", exception);
            } else {
                log.info("createTopics success");
            }
        });
        return topicsResult;
    }

    public static void deleteTopics(String topicName) {
        client.deleteTopics(Collections.singleton(topicName));
    }


    public static Collection<TopicListing> getTopics() throws ExecutionException, InterruptedException {
        Collection<TopicListing> topicListings = client.listTopics().listings().get();
        if (topicListings == null || topicListings.isEmpty()) {
            log.info("No topics found");
        }else {
            for (TopicListing topicListing : topicListings) {
                log.info(String.valueOf(topicListing));
            }
        }

        return topicListings;
    }

    public static void deleteAllTopics() throws ExecutionException, InterruptedException {
        Collection<TopicListing> topics = getTopics();
        Collection<String> topicNames = new ArrayList<>();
        topics.stream().map(TopicListing::name).forEach(topicNames::add);
        DeleteTopicsResult deleteTopicsResult = client.deleteTopics(topicNames);
    }


    public static void dynamicComsumer() {
        KafkaListenerEndpointRegistry registry = new KafkaListenerEndpointRegistry();

    }

}
