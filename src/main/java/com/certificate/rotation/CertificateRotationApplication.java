package com.certificate.rotation;

import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class CertificateRotationApplication {

	static {
		SpringDocUtils.getConfig().addHiddenRestControllers(BasicErrorController.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(CertificateRotationApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("Certificate API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
