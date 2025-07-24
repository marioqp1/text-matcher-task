package com.mario.textmatcher.service;


import com.mario.textmatcher.model.FileSimilarityResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SimilarityService {

    public Set<String> extractWords(Path filePath) throws IOException {
        String content = Files.readString(filePath);
        return Arrays.stream(content.split("\\W+"))
                .filter(word -> word.matches("[a-zA-Z]+"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<FileSimilarityResult> calculateScores(Path fileAPath, Path poolDirPath) throws IOException {
        Set<String> wordsA = extractWords(fileAPath);
        List<FileSimilarityResult> scores = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(poolDirPath)) {
            for (Path path : stream) {
                if (Files.isRegularFile(path)) {
                    Set<String> wordsB = extractWords(path);

                    long matchedWords = wordsB.stream().filter(wordsA::contains).count();
                    double score = (wordsA.isEmpty()) ? 0 : (matchedWords * 100.0) / wordsA.size();

                    scores.add(new FileSimilarityResult(path.getFileName().toString(), score));
                }
            }
        }

        return scores;
    }
}
