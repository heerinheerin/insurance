package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends  JpaRepository<event, Long> {
}
