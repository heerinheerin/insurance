package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByEmail(String email);
    Member findByTel(String tel);

}
