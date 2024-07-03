package com.trip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@EntityListeners(value = {AutoCloseable.class})
@MappedSuperclass
@Getter
public abstract class BaseEntity extends BaseTimeEntity { // 등록일 수정일 상속
    @CreatedBy
    @Column(updatable = false)
    private String createdBy; // 등록자

    @LastModifiedBy
    private String modifiedBy; // 수정자
}
