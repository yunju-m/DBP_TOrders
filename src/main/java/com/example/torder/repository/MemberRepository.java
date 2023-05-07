package com.example.torder.repository;

import java.util.Optional;

import com.example.torder.domain.Member;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findByNickname(String nickname);
}
