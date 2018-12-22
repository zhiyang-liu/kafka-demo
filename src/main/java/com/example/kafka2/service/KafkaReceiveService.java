package com.example.kafka2.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiveService {

    //@KafkaListener(topics = {"myTopic"})//不指定分区就是从全部分区读取
    @KafkaListener(id = "myContainer1",
            topicPartitions =
                    {
                            //@TopicPartition(topic = "topic1", partitions = { "0", "2" }),//指定多个主题及分区，不指定偏移量默认是0，分区编号从0开始
                            @TopicPartition(topic = "myTopic", //partitions = { "1" },//指定监听多个分区
                                    partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))//指定特定分区及偏移量
                    })
    public void receive(ConsumerRecord<?, ?> cr){
        System.out.println(cr.value().toString());
    }
}
