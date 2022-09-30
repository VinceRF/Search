package com.example.serach.service;

import com.example.serach.dto.WordRequestDto;
import com.example.serach.dto.WordResponseDto;
import com.example.serach.model.Word;
import com.example.serach.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    // 용어 등록
    @Transactional
    public ResponseEntity registerWord(WordRequestDto requestDto){
        String name = requestDto.getName();
        String content = requestDto.getContent();

        Word word = Word.builder()
                .name(name)
                .content(content)
                .favorite(false)
                .build();
        wordRepository.save(word);

        return ResponseEntity.ok("용어 등록 완료");
    }

    // 용어 조회
    public List<WordResponseDto> getWords(){
        List<Word> words = wordRepository.findAll();
        List<WordResponseDto> wordResponseDtos = new ArrayList<>();
        for (Word word : words){
            WordResponseDto wordResponseDto = new WordResponseDto(word);
            wordResponseDtos.add(wordResponseDto);
        }
        return wordResponseDtos;
    }

    // 특정 용어 조회
    public WordResponseDto getWord(Long id){
        Word word = wordRepository.findWordById(id);
        WordResponseDto wordResponseDto = new WordResponseDto(word);
        return wordResponseDto;
    }

    // 용어 수정
    public ResponseEntity modifyWord(Long id,
                                     WordRequestDto requestDto){
        Word word = wordRepository.findWordById(id);

        word.modifyWord(requestDto);
        wordRepository.save(word);
        return ResponseEntity.ok("용어 수정 완료");
    }

    // 용어 즐겨찾기
    public ResponseEntity favoriteWord(Long id){
        Word word = wordRepository.findWordById(id);
        if (word.isFavorite() == false){
            word.setFavorite(true);
            wordRepository.save(word);
            return ResponseEntity.ok("즐겨찾기 등록 완료");
        } else if (word.isFavorite() == true){
            word.setFavorite(false);
            wordRepository.save(word);
            return ResponseEntity.ok("즐겨찾기 해제 완료");
        }
        return ResponseEntity.ok("즐겨찾기 등록/해제 완료");
    }

    // 용어 삭제
    public ResponseEntity deleteWord(Long id){
        Word word = wordRepository.findWordById(id);

        wordRepository.delete(word);

        return ResponseEntity.ok("용어 삭제 완료");
    }

}
