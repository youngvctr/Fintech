package com.zerobase.kafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.zerobase.kafka.dto.ProductRequestDto
import com.zerobase.kafka.enum.KafkaTopic
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductRequestSender(
        private val kafkaTemplate: KafkaTemplate<String, String>,
        private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, productRequestDto: ProductRequestDto) {
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(productRequestDto))
    }
}