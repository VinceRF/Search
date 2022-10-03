package com.example.serach.repository;

import com.example.serach.controller.WordController;
import com.example.serach.dto.WordRequestDto;
import com.example.serach.model.QWord;
import com.example.serach.model.Word;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordRepositoryImpl implements WordRepositoryCustom{
    private final JPAQueryFactory queryFactory;


    QWord word = QWord.word;

    public WordRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Word> getWordList(String req) {
        return queryFactory
                .selectFrom(word)
                .where(word.content.contains(req))
                .fetch();
    }

    @Override
    public List<Word> getWordNameList(String req) {
        return queryFactory
                .selectFrom(word)
                .where(word.name.contains(req))
                .fetch();
    }


}
