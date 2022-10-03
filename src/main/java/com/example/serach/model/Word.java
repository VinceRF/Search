package com.example.serach.model;

import com.example.serach.dto.WordRequestDto;
import lombok.*;

import javax.persistence.*;
@Table(name = "word")
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private boolean favorite;

    public void modifyWord(WordRequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
    }
}
