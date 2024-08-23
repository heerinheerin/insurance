package com.Myproject.insurance.repository;

import com.Myproject.insurance.dto.ItemSearchDto;
import com.Myproject.insurance.dto.MainItemDto;
import com.Myproject.insurance.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
    Page<MainItemDto> searchItemPage(Pageable pageable, String search);

}
