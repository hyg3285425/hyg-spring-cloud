package com.yunnk.springcloudproject.configuration.feign;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 自定义feign异常解析器
 * @author huangyigang
 */
@Slf4j
@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = null;
        try {
            exception = new RuntimeException(Util.toString(response.body().asReader(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return exception;
    }
}
