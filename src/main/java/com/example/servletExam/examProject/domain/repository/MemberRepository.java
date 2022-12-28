package com.example.servletExam.examProject.domain.repository;

import com.example.servletExam.examProject.domain.dto.Member;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();

    private static final MemberRepository instance = new MemberRepository();

    private Long sequence = 0L;

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member){
        sequence++;
        member.setId(sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
