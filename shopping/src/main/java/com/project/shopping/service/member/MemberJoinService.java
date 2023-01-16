package com.project.shopping.service.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder encoder;

    public int join(MemberJoinRequest joinRequest){

        // Entity 저장
        Member member = joinRequest.toMemberEntity();

        // 패스워드 암호화
        member.setPw(encoder.encode(joinRequest.getPw()));

        int result = 0;

        result = memberRepository.save(member) != null ? 1 : 0;

        return result;
    }
}
