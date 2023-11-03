package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){
        Map<String,String> config = new HashMap<>();
        config.put(TopicConfig.CLEANUP_POLICY_CONFIG,TopicConfig.CLEANUP_POLICY_DELETE);
        config.put(TopicConfig.RETENTION_MS_CONFIG,"86400000");
        config.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824"); // Tamaño max segmento
        config.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1048576"); // Tamaño max mensaje
        return TopicBuilder
                .name("test")
                .partitions(2)
                .replicas(2)
                .configs(config)
                .build();
    }
}
