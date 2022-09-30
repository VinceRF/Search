package com.example.serach.repository;

import com.example.serach.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Long> {
    List<Word> findAll();
    Word findWordById(Long id);
}
