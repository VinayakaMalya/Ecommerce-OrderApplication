package com.ecommerce.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ecommerce.order.model.Order;

@Service
public class OrderProducerServiceImpl implements OrderProducerService
{
	private static final Logger logger = 
			LoggerFactory.getLogger(OrderProducerServiceImpl.class);
	
	//1. Topic with string Order payload
    @Value(value = "${order.topic.name}")
    private String orderTopicName;
    
    @Autowired
    private KafkaTemplate<String, Order> orderKafkaTemplate;
    
	@Override
	public void saveCreateorUpdateOrder(Order order) 
	{
		ListenableFuture<SendResult<String, Order>> future 
							= this.orderKafkaTemplate.send(orderTopicName, order);
	
			future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() 
			{
		        @Override
		        public void onSuccess(SendResult<String, Order> result) {
		        	logger.info("Order created: " 
		        			+ order + " with offset: " + result.getRecordMetadata().offset());
	        }
	
		        @Override
		        public void onFailure(Throwable ex) {
		        	logger.error("Order created : " + order, ex);
		        }
		});
	}
}
