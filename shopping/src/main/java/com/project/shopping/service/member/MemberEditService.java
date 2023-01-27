package com.project.shopping.service.member;

import com.project.shopping.domain.member.MemberEditRequest;
import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberEditService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder encoder;

    public int edit(MemberEditRequest editRequest){

        // Entity 저장
        Member member = editRequest.toMemberEdit();

        // 패스워드 암호화
        member.setPassword(encoder.encode(editRequest.getPassword()));

        int result = 0;

        result = memberRepository.save(member) != null ? 1 : 0;

        return result;
    }
}
