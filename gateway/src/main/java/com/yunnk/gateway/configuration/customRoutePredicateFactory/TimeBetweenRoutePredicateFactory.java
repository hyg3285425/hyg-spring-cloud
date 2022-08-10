package com.yunnk.gateway.configuration.customRoutePredicateFactory;

import com.yunnk.gateway.entity.TimeBetween;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由谓词工厂
 * 开头与yml中一致
 * 结尾必须是RoutePredicateFactory
 *
 * @author huangyigang
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetween> {
    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetween.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBetween config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    /**
     * 按顺序赋值给配置类
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start", "end");
    }
}
