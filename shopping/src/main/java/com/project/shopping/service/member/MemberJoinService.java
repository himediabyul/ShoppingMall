package com.project.shopping.service.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        int result = 0;

        result = memberRepository.save(member) != null ? 1 : 0;

        return result;
    }

/*    @Transactional
    public void checkIdDuplication(MemberJoinRequest joinRequest) {

        boolean idDuplicate = memberRepository.existsByUid(joinRequest.toMemberEntity().getUid());

        if (idDuplicate) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }*/


    @Transactional
    public int isDupicateId(String uid){

        return memberRepository.existsByUid(uid) ? 1 : 0;
    }
}

/*
package com.project.shopping.service.member;

import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberJoinService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByUid(member.getUid());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {

        Member member = memberRepository.findByUid(uid);

        if(member == null){
            throw new UsernameNotFoundException(uid);
        }

        return User.builder()
                .username(member.getUid())
                .password(member.getPw())
//                .roles(member.getRole().toString())
                .build();
    }

}*/
