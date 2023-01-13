package com.project.shopping.service.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {

    @Autowired
    private MemberRepository memberRepository;


    public int join(MemberJoinRequest joinRequest){

        return 0;
    }
}
