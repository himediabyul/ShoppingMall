package com.project.shopping.service.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


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
        member.setPassword(encoder.encode(joinRequest.getPassword()));

        // 가입일
        member.setJoindate(LocalDate.now());

        int result = 0;

        result = memberRepository.save(member) != null ? 1 : 0;

        return result;
    }

    @Transactional
    public int isDupicateId(String uid){

        return memberRepository.existsByUid(uid) ? 1 : 0;
    }

    @Transactional
    public int isDupicatePhone(String phone){

        return memberRepository.existsByPhone(phone) ? 1 : 0;
    }
}
