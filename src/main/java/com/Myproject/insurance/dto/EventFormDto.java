package com.Myproject.insurance.dto;


import com.Myproject.insurance.entity.event;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
public class EventFormDto {
    private Long id;
    private String content;
    private String content1;
    private String content2;
    private String content3;

    private List<EventImgDto> eventImgDtoList = new ArrayList<>(); // 상품 이미지 정보

    private List<Long> eventImgIds = new ArrayList<>(); // 상품 이미지 아이디

    private static ModelMapper modelMapper = new ModelMapper();

    public event createEventTem(){
        // ItemFormDto -> Item 연결
        return modelMapper.map(this,event.class);
    }

    public static EventFormDto of(event event) {
        // Item -> ItemFormDto 연결
        return modelMapper.map(event, EventFormDto.class);
    }



}
