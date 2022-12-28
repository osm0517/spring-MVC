package com.example.servletExam.examProject.domain.repository;

import com.example.servletExam.examProject.domain.dto.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clearStore(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
//        given
        Member member = new Member("member1", 20);

//        when
        Member result = memberRepository.save(member);

//        then
        Member findResult = memberRepository.findById(result.getId());
        assertThat(findResult).isEqualTo(result);
    }

    @Test
    void findAll() {
//        given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

//        when
        List<Member> result = memberRepository.findAll();

//        then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}