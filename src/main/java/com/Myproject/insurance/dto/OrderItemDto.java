package com.Myproject.insurance.dto;

import com.Myproject.insurance.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    ////////order item/////////////////
    private String itemNm;
    private int count;
    private int orderPrice;
    private String imgUrl;
    private String itemDetail; // 상품상세설명



    public OrderItemDto(OrderItem orderItem, String imgUrl){
        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();

        this.imgUrl = imgUrl;
    }
}
