package com.Myproject.insurance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionsDto {
    private Long id;
    private  String writer;
    private String title;
    private String content;
}
