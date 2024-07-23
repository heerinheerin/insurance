package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem findByItemId(Long itemId);

    OrderItem findByOrderId(Long orderId);


}
