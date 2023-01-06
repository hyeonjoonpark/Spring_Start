package com.example.springstart.repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository<Member> {
    com.example.springstart.domain.Member save(com.example.springstart.domain.Member member);

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<com.example.springstart.domain.Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원을 찾음
}
