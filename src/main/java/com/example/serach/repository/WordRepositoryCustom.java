package com.example.serach.repository;

import com.example.serach.model.Word;

import java.util.List;

public interface WordRepositoryCustom {

    List<Word> getWordList(String req);

    List<Word> getWordNameList(String req);

}
