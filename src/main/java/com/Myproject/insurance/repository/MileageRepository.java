package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MileageRepository extends JpaRepository<Mileage, Long> {
    List<Mileage> findByMemberId(Long MemberId);
}
