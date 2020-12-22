package com.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 方法需要有ApiOperation注解才能生存接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                // 如何保护我们的Api，有三种验证（ApiKey, BasicAuth, OAuth）
                .securitySchemes(security())
                // 接口文档的基本信息
                .apiInfo(apiInfo());
    }

    /**
     * 接口文档详细信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TMovie API Documentation")
                .description("TMovie 电影API接口")
                .termsOfServiceUrl("http://www.localhost:4000")
                .contact(new Contact("TanHaooo", "http://www.localhost:4000", "514787498@qq.com"))
                .version("1.0.0")
                .build();
    }

    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<ApiKey>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;
    }
}
