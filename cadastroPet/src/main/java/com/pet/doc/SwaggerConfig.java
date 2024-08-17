package com.pet.doc;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public GroupedOpenApi documentacaoApiPet() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**") 
                .build();
    }

}
