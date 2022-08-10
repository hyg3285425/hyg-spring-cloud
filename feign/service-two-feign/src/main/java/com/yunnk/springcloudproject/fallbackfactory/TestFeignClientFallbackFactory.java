package com.yunnk.springcloudproject.fallbackfactory;

import com.yunnk.springcloudproject.feign.TestFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * feign的回调，一般用于流控或者是降级处理
 * 这里的异常是被Feign封装过的异常，不能直接在异常信息中看出原始方法抛出的异常
 *
 * @author huangyigang
 */
@Component
@Slf4j
public class TestFeignClientFallbackFactory implements FallbackFactory<TestFeignClient> {
    /**
     * 回调处理
     * 对cause分类处理，公共的异常处理可提出封装，比如：流控异常处理
     * log需包含详细详细，方便排查问题
     * throw友好提示
     *
     * @param cause 回调异常
     * @return 一般情况下给友好提示
     */
    @Override
    public TestFeignClient create(Throwable cause) {
        return () -> {
            dealGenericException(cause);
            throw new RuntimeException("服务异常，请联系管理员");
        };
    }

    private void dealGenericException(Throwable cause) {
        log.error("服务提供者出问题了");
//        if (cause instanceof FlowException flowException) {
//            String resource = flowException.getRule().getResource();
//            log.error("微服务端点被流控了，端点是：{}", resource);
//            throw new RuntimeException("服务器正忙，请稍后再试");
//        }
//        if (cause instanceof DegradeException degradeException) {
//            String resource = degradeException.getRule().getResource();
//            log.error("微服务端点被熔断了，端点是：{}", resource);
//            throw new RuntimeException("服务器熔断，请稍后再试");
//        }
//        if (cause instanceof RuntimeException runtimeException){
//            throw runtimeException;
//        }
    }
}
