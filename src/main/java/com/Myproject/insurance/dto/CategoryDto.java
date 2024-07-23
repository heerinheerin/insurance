package com.Myproject.insurance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String itemNm;
    private Integer price;
    private String itemDetail;
    private String sellStatCd;
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
