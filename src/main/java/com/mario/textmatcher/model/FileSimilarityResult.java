package com.mario.textmatcher.model;


import lombok.Getter;

@Getter
public class FileSimilarityResult {
    private String fileName;
    private double score;

    public FileSimilarityResult(String fileName, double score) {
        this.fileName = fileName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "File similarity[" +
                "fileName='" + fileName + '\'' +
                ", score=" + score +
                ']';
    }
}