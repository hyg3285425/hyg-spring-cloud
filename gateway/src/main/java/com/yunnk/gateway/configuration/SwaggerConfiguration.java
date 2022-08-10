package com.yunnk.gateway.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyigang
 */
@Configuration
public class SwaggerConfiguration {
//    @Bean
//    @Lazy(false)
//    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters, RouteDefinitionLocator locator) {
//        List<GroupedOpenApi> groups = new ArrayList<>();
//        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//        assert definitions != null;
//        definitions.forEach(routeDefinition -> {
//            String name = routeDefinition.getId().replaceAll("ReactiveCompositeDiscoveryClient_", "");
//            swaggerUiConfigParameters.addGroup(name);
//            GroupedOpenApi groupedOpenApi = GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
//            groups.add(groupedOpenApi);
//        });
//        return groups;
//    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("集中API管理").description("集中API管理").version("v1.0.0"));
    }
}
