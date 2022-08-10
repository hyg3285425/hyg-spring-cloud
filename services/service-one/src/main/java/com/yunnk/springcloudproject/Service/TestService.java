package com.yunnk.springcloudproject.Service;

import com.yunnk.springcloudproject.dao.TestDao;
import com.yunnk.springcloudproject.entity.SpringDataTest;
import com.yunnk.springcloudproject.feign.TestFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.domain.Example;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author huangyigang
 */
@Service
@Slf4j
public class TestService {
    @Resource
    private StreamBridge streamBridge;

    @Resource
    private TestFeignClient testFeignClient;

    @Resource
    private TestDao testDao;

    public void ask(String question) {
        Message<String> message = MessageBuilder
                .withPayload(question)
                .build();
        if (streamBridge.send("ask-out-0", message)){
            log.info("问题成功放入消息队列topic-ask中");
        }
        if (streamBridge.send("test-out-1", message)){
            log.info("问题成功放入消息队列topic-test中");
        }
    }

    public String testFeign() {
        return testFeignClient.testFeign();
    }
}
