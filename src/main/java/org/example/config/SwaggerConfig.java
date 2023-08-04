package org.example.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration // 标明是配置类
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试分组")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger-Demo 项目Api接口文档")
                .description("Swagger-Demo 项目Api接口文档，详情说明...")
                .contact(new Contact("cykjshuji","http://www.xxx.com","xxx@163.com"))
                .version("1.0")
                .build();
    }


}
