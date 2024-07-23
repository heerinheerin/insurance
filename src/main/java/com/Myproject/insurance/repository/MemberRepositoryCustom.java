package com.Myproject.insurance.repository;

import com.Myproject.insurance.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> memberSearch(Long id, String name);
}
