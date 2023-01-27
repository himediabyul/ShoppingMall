package com.project.shopping.service.member;

import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getInfo(int uidx){

        return memberRepository.findByUidx(uidx).get();
    }
}
