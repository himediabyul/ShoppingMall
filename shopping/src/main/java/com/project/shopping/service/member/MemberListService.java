package com.project.shopping.service.member;

import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberListService {

    @Autowired
    private MemberRepository memberRepository;


    public List<Member> memberList() {

        return memberRepository.findAll();
    }

}
