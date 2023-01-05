package com.example.springstart.repository;


import com.example.springstart.domain.Member;

import java.util.*;
import java.util.Optional;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member){
        member.setId(++sequence);
        store.put((long) member.getId(), member);
        return member;
    }


    public Object save(Object o) {
        return null;
    }

    @Override
    public Optinal<Member> findById(Long id) {
        return Optinal.ofNullable((java.lang.reflect.Member) store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
