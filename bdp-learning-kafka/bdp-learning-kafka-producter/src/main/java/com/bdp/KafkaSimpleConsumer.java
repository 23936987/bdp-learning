package com.bdp;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class KafkaSimpleConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafKaCustomrProducer.class);
    // 简单消费者
    @KafkaListener(topics = "test01")
    public void consumer1_1(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        logger.info("time:" + df.format(new Date()));
        logger.info("消费者收到消息:" + record.value() + "; topic:" + topic);
        /*
         * 如果需要手工提交异步 consumer.commitSync();
         * 手工同步提交 consumer.commitAsync()
         */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        consumer.commitAsync();
    }
}