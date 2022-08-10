package com.yunnk.gateway.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器,都所有请求生效
 * @author huangyigang
 */
@Slf4j
@Configuration
public class GlobalFilterConfiguration {
    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            //log.info("global filter");
        }));
    }
}
