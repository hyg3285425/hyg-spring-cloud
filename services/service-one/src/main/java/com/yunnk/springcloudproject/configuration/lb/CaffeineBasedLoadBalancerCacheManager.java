package com.yunnk.springcloudproject.configuration.lb;

import com.alibaba.nacos.common.utils.StringUtils;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cloud.loadbalancer.cache.LoadBalancerCacheManager;
import org.springframework.cloud.loadbalancer.cache.LoadBalancerCacheProperties;
import org.springframework.cloud.loadbalancer.core.CachingServiceInstanceListSupplier;
import org.springframework.stereotype.Component;

/**
 * @author huangyigang
 */
@Component
public class CaffeineBasedLoadBalancerCacheManager extends CaffeineCacheManager implements LoadBalancerCacheManager {
    public CaffeineBasedLoadBalancerCacheManager(String cacheName, LoadBalancerCacheProperties properties) {
        super(cacheName);
        if (StringUtils.isNotEmpty(properties.getCaffeine().getSpec())) {
            this.setCacheSpecification(properties.getCaffeine().getSpec());
        } else {
            this.setCaffeine(Caffeine.newBuilder().initialCapacity(properties.getCapacity()).expireAfterWrite(properties.getTtl()).softValues());
        }

    }

    public CaffeineBasedLoadBalancerCacheManager(){}

    public CaffeineBasedLoadBalancerCacheManager(LoadBalancerCacheProperties properties) {
        this(CachingServiceInstanceListSupplier.SERVICE_INSTANCE_CACHE_NAME, properties);
    }
}
