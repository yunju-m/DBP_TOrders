package com.example.torder.service;

import java.util.Optional;

import com.example.torder.domain.Member;
import com.example.torder.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 회원가입 중복확인 */
    public void join(Member member) {
        System.out.println();
        System.out.println("** MemberService join 동작 **");
        System.out.println("member.id=" + member.getId());
        System.out.println("member.passward= " + member.getPassword());
        System.out.println("member.nickname= " + member.getNickname());
        validateDuplicateMember(member);
    }

    /* 회원가입 db저장 */
    public String save(Member member) {
        System.out.println("db에 회원정보 저장합니다!!");
        memberRepository.save(member);
        return member.getId();
    }

    /* 회원 중복 검증 */
    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findById(member.getId());
        result.ifPresent(m -> {
            System.out.println("이미 존재하는 ID 입니다.");
        });
        result = memberRepository.findByNickname(member.getNickname());
        result.ifPresent(m -> {
            System.out.println("이미 존재하는 닉네임입니다.");
        });
    }
}
