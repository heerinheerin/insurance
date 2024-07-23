package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.eventImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventImgReposotory extends JpaRepository<eventImg, Long> {

    List<eventImg> findByeventIdOrderByIdAsc(Long eventId);
}
