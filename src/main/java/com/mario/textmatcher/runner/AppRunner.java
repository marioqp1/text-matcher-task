package com.mario.textmatcher.runner;


import com.mario.textmatcher.config.ConfigProperties;
import com.mario.textmatcher.model.FileSimilarityResult;
import com.mario.textmatcher.service.SimilarityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private final ConfigProperties properties;
    private final SimilarityService similarityService;

    public AppRunner(@Qualifier("configProperties") ConfigProperties configProperties, SimilarityService similarityService) {
        this.properties = configProperties;
        this.similarityService = similarityService;
    }

    @Override
    public void run(String... args) throws Exception {
        Path fileA = Path.of(properties.getReferenceFilePath());
        Path poolDir = Path.of(properties.getPoolDirectoryPath());

        List<FileSimilarityResult> scores = similarityService.calculateScores(fileA, poolDir);

        scores.stream()
                .sorted(Comparator.comparingDouble(FileSimilarityResult::getScore).reversed())
                .forEach(System.out::println);
    }
}

