package com.yash.yota.config;
/**
 * This Swagger Configuration will provide you API Documentation on the go swagger-ui.html link.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	//TODO : This method basically scans all api's under specified packages for documentation
	@Bean
	Docket apiDocumentation()
	{
		return new Docket(DocumentationType.SWAGGER_2).
					select().
					apis(RequestHandlerSelectors.basePackage("com.yash")).
					build();
	}
	
}
