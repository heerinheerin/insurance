package com.trip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private  Long id;
    private  String orderprice;
    private  int count;
}
