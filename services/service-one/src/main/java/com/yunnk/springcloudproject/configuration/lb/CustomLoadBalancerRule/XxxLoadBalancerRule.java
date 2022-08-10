package com.yunnk.springcloudproject.configuration.lb.CustomLoadBalancerRule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import reactor.core.publisher.Mono;

/**
 * @author huangyigang
 * 自定义的负载均衡规则
 */
public class XxxLoadBalancerRule implements ReactorServiceInstanceLoadBalancer {
    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        /**
         * 实现具体的负载均衡逻辑
         */
        return null;
    }
}
