package com.atguigu.mybatisplus.config;



import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
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

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

        /**
         * 创建API应用
         * apiInfo() 增加API相关信息
         * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
         * 本例采用指定扫描的包路径来定义指定要建立API的目录。
         *
         * @return
         */
        @Value("${swagger.enable}")
        private boolean enable;

        @Bean
        public Docket restApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("标准接口")
                    //绑定swagger-ui的展示内容
                    .enable(enable)
                    .apiInfo(apiInfo("Spring Boot中使用Swagger2构建RESTful APIs", "1.0"))
                    .select()
                    //绑定扫描的类
                    //原：RequestHandlerSelectors.basePackage("com.atguigu.mybatisplus")
                    //Predicates.not(RequestHandlerSelectors.basePackage("com.atguigu.mybatisplus"))
                    .apis(RequestHandlerSelectors.basePackage("com.atguigu.mybatisplus"))
                    /**
                     * PathSelectors方法说明:
                     * any()  任何请求都扫描
                     * none()  任何请求都不扫描
                     * regex(final String pathRegex)  通过正则表达式控制
                     * ant(final String antPattern)  通过ant()控制
                     */
                    .paths(PathSelectors.ant("/user/**"))
                    .build();
        }

        /**
         * 创建该API的基本信息（这些基本信息会展现在文档页面中）
         * 2.x访问地址：http://ip:port/swagger-ui.html http://localhost:8080/swagger-ui.html
         * 3.x访问地址：http://ip:port/swagger-ui/index.html
         * 导入swagger-bootstrap-ui的访问路径： http://ip:port/doc.html
         *
         * @return
         */
        //指定swagger2 ui显示的格式
        private ApiInfo apiInfo(String title, String version) {
            return new ApiInfoBuilder()
                    .title(title)
                    .description("swagger和springboot整合演示! swagger的API文档演示效果 ")
                    .termsOfServiceUrl("https://blog.csdn.net/xqnode")
                    .version(version)
                    .build();
        }



}
