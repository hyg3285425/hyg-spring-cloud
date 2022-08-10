package com.yunnk.springcloudproject.Service.Test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author huangyigang
 */
@Configuration
@Slf4j
public class TestService {
    /**
     * 此处的方法名一定要和对应的binding的方法名一致，比如此处的answer对应answer-in-0
     * @return 返回一个binding以answer开头的消费者
     */
    @Bean
    public Consumer<Message<String>> answer() {
        return message -> {
            log.info("问题是:{}", message.getPayload());
            log.info("我回答了问题");
        };
    }
    @Bean
    public Consumer<Message<String>> test() {
        return message -> {
            log.info("测试同一个服务消费不同主题的消息成功");

        };
    }
}
