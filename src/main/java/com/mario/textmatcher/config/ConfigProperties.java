package com.mario.textmatcher.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component("configProperties")
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {
    private String referenceFilePath;
    private String poolDirectoryPath;
}

