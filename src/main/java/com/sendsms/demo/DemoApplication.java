package com.sendsms.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

//@EnableJpaRepositories(basePackages = "com.sendsms.demo.repository")
@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		//Return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()  //object of the ApiSelectorBuilder
				//.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sendsms.demo"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Send Sms API",
				"Sample API for Send Sms using Twilio",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Gurunath Kumbar", "No Website yet","gurunathskumbar@gmail.com"),
				"API License",
				"no License URL ",
				Collections.emptyList());

	}

}
