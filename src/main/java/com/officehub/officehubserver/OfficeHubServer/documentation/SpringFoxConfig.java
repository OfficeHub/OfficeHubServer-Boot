package com.officehub.officehubserver.OfficeHubServer.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger-ui 사용을 설정하기 위한 클래스입니다.
 * base-url/swagger-ui/ 로 접속하면 api 들에 대한 문서 확인 가능.
 */
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
