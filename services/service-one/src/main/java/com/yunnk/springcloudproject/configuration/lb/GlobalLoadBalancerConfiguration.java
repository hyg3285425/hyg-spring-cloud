package com.yunnk.springcloudproject.configuration.lb;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangyigang
 * 指定LoadBalancer的全局配置
 * 细粒度配置统一使用配置文件的方式进行配置
 */
@Configuration
@LoadBalancerClients(defaultConfiguration = LoadBalancerConfiguration.class)
public class GlobalLoadBalancerConfiguration {
}
