package com.Myproject.insurance.repository;

import com.Myproject.insurance.dto.CartDetailDto;
import com.Myproject.insurance.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndItemId(Long cartId, Long itemId);

    @Query("select new com.Myproject.insurance.dto.CartDetailDto(ci.id, i.itemNm, i.startDate, ci.count, i.price)" +
            "from CartItem ci " +
            "join ci.item i " +
            "where ci.cart.id = :cartId " +
            "order by ci.regTime desc")
    List<CartDetailDto> findCartDetailDtoList(Long cartId);

    CartItem findByCartId(Long cartId);
}