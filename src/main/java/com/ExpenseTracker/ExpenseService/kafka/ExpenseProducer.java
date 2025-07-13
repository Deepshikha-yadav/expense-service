package com.ExpenseTracker.ExpenseService.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ExpenseTracker.ExpenseService.dto.ExpenseEvent;

@Component
public class ExpenseProducer {

	@Value("${kafka.topic.expense}")
    private String topic;

    private final KafkaTemplate<String, ExpenseEvent> kafkaTemplate;

    public ExpenseProducer(KafkaTemplate<String, ExpenseEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishExpense(ExpenseEvent event) {
        kafkaTemplate.send(topic, event);
    }
    
}
