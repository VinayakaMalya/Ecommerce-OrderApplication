package com.ecommerce.order.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig 
{
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${order.topic.name}")
	private String orderTopicName;

	@Bean
	public NewTopic orderTopic() {
		return TopicBuilder.name(orderTopicName)
			      .partitions(1)
			      .replicas(1)
			      .build();
	}
}
