package com.example.springstart.repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository<Member> {
    Member save(Member member) throws InterruptedException;

    java.lang.reflect.Member save(java.lang.reflect.Member member) throws InterruptedException;

    Optinal<Member> findById(Long id);
    Optional<java.lang.reflect.Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원을 찾음
}
