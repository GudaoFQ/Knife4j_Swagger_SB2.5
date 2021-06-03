package com.gudao.knife4jproject.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import com.fasterxml.classmate.TypeResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Auther: Gudao
 * @Date: 2021/06/03
 * @Description:
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    private final TypeResolver typeResolver;
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfig(TypeResolver typeResolver, OpenApiExtensionResolver openApiExtensionResolver) {
        this.typeResolver = typeResolver;
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Gudao Demo")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gudao.knife4jproject.controller"))//扫描包
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//扫描在API注解的contorller
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描带ApiOperation注解的方法
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("2.X版本"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gudao接口开放平台")
                .description("Gudao接口")
                .version("v1.0")
                .contact(new Contact("Gudao", "www.gudao.ink", "2873908996@qq.com"))
                .build();
    }
}