package com.example.serach.dto;

import com.example.serach.model.Word;
import lombok.Getter;

@Getter
public class WordResponseDto {


    private String name;
    private String content;

    private boolean favorite;

    public WordResponseDto(Word word) {
        this.name = word.getName();
        this.content = word.getContent();
        this.favorite = word.isFavorite();
    }
}
