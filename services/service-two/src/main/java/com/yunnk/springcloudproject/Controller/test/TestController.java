package com.yunnk.springcloudproject.Controller.test;

import com.yunnk.springcloudproject.feign.TestFeignClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyigang
 */
@Tag(name = "服务二的测试控制器")
@RestController
@RequestMapping("service-two")
public class TestController implements TestFeignClient {
    @Operation(summary = "回答问题")
    @RequestMapping("test-feign")
    @Override
    public String testFeign(){
        return "answer";
    }
}
