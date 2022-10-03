package com.example.serach.controller;

import com.example.serach.dto.WordRequestDto;
import com.example.serach.dto.WordResponseDto;
import com.example.serach.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    // 용어 등록
    @PostMapping("/api/words")
    public ResponseEntity registerWord(@RequestBody WordRequestDto requestDto){
        return wordService.registerWord(requestDto);
    }

    // 용어 조회
    @GetMapping("/api/words")
    public List<WordResponseDto> getWords(){
        return wordService.getWords();
    }

    // 특정 용어 조회
    @GetMapping("/api/word/{id}")
    public WordResponseDto getWord(@PathVariable Long id){
        return wordService.getWord(id);
    }

    // 용어 수정
    @PatchMapping("/api/words/{id}")
    public ResponseEntity modifyWord(@PathVariable Long id,
                                     @RequestBody WordRequestDto requestDto){
        return wordService.modifyWord(id,requestDto);
    }

    // 용어 삭제
    @DeleteMapping("/api/words/{id}")
    public ResponseEntity deleteWord(@PathVariable Long id){
        return wordService.deleteWord(id);
    }

    // 용어 즐겨찾기
    @PatchMapping("/api/favorite/{id}")
    public ResponseEntity favoriteWord(@PathVariable Long id){
        return wordService.favoriteWord(id);
    }

    // 용어 뜻으로 용어 검색
    @GetMapping("/api/search/content")
    public List<WordResponseDto> searchByContent(@RequestBody WordRequestDto requestDto){
        return wordService.searchByContent(requestDto);
    }

    // 용어 이름으로 용어 검색
    @GetMapping("/api/search/name")
    public List<WordResponseDto> searchByName(@RequestBody WordRequestDto requestDto){
        return wordService.searchByName(requestDto);
    }
}
