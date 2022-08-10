package com.yunnk.springcloudproject.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yunnk.springcloudproject.Service.TestService;
import com.yunnk.springcloudproject.controller.BlockHandler.TestControllerBlockHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangyigang
 */
@Tag(name = "服务一的测试控制器")
@RestController
@RequestMapping("service-one")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * 用于sentinel对spring mvc节点的流控降级回调处理
     * 注意：sentinel的流控降级异常并不会进入全局异常捕获
     * blockHandler只处理BlockException，fallback会处理所有异常（所以我觉得fallback没啥用）
     */
    @Operation(summary = "问问题")
    @GetMapping("ask")
    @SentinelResource(value = "test/ask", blockHandler = "askBlock", blockHandlerClass = TestControllerBlockHandler.class)
    public void ask(@Parameter(name = "question",description = "问题") String question) {
        testService.ask(question);
    }

    @Operation(summary = "测试feign")
    @GetMapping("test-feign")
    public String testFeign() {
        return testService.testFeign();
    }
}
