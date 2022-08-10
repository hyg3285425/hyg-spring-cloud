package com.yunnk.springcloudproject.feign;

import com.yunnk.springcloudproject.fallbackfactory.TestFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对应微服务的控制层最好实现这个接口，为了保证接口的统一性
 * @author huangyigang
 */
@FeignClient(value = "service-two", fallbackFactory = TestFeignClientFallbackFactory.class)
public interface TestFeignClient {
    /**
     * test feign
     *
     * @return answer
     */
    @RequestMapping("service-two/test-feign")
    String testFeign();
}
