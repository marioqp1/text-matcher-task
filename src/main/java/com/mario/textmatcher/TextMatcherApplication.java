package com.mario.textmatcher;

import com.mario.textmatcher.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class TextMatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextMatcherApplication.class, args);
	}

}
