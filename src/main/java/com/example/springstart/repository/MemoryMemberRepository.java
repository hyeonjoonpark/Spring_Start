package com.example.springstart.repository;

import java.lang.reflect.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository<Member> {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) throws InterruptedException {
        member.wait(++sequence);
        store.put((long) member.getModifiers(), member);
        return member;
    }

    @Override
    public Optinal<Member> findById(Long id) {
        return Optinal.ofNullable(store.get(id));
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