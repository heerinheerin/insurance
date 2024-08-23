package com.Myproject.insurance.dto;


import com.Myproject.insurance.constant.Category;
import com.Myproject.insurance.constant.ItemSellStatus;
import com.Myproject.insurance.constant.Nature;
import com.Myproject.insurance.constant.Region;
import com.Myproject.insurance.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class ItemFormDto {
    private Long id;


    @NotBlank(message = "상호 명은 필수 입력 값입니다.")
    private String itemNm;

    @NotNull(message = "급여는 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "상세설명은 필수 입력 값입니다.")
    private String itemDetail;
// 인원 수

    @NotNull(message = "인원은 필수 입력 값입니다.")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;

    private Nature nature;

    private Category category;

    private Region region;

    @NotNull(message = "시작날짜는 필수 입력 값입니다.")
    private LocalDate startDate;

    @NotNull(message = "마감날짜는 필수 입력 값입니다.")
    private LocalDate endDate;
    // -------------------------------------------------------
    // ItemImg
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); // 상품 이미지 정보

    private List<Long> itemImgIds = new ArrayList<>(); // 상품 이미지 아이디

    // -------------------------------------------------------
    // ModelMapper
    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem() {
        // ItemFormDto -> Item 연결
        return modelMapper.map(this,Item.class);
    }
    public static ItemFormDto of(Item item) {
        // Item -> ItemFormDto 연결
        return modelMapper.map(item, ItemFormDto.class);
    }
}



