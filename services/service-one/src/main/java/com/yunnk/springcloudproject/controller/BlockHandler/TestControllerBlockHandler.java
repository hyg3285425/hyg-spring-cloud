package com.yunnk.springcloudproject.controller.BlockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangyigang
 */
@Slf4j
public class TestControllerBlockHandler {
    /**
     * 必须是 public static
     * 返回类型与原方法一致
     * 参数类型需要和原方法相匹配，并在最后加 BlockException 类型的参数
     */
    public static String askBlock(String word, BlockException blockException) {
        log.warn("此接口被流控降级了:{}", blockException.getRule().getResource());
        return "此接口被流控降级了";
    }
}
