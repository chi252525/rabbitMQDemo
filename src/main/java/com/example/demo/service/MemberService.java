package com.example.demo.service;

import com.example.demo.domain.dto.Member;
import com.example.demo.domain.request.ReqMemberList;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Page<Member> list(ReqMemberList req) {
        return memberRepository.findAll(PageRequest.of(req.getPageIndex(),
                req.getPageSize(),
                Sort.by("age").descending()));
    }
}
