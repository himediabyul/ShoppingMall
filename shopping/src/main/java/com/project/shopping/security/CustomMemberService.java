package com.project.shopping.security;

import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomMemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info(" >>>>> loadUserByUsername => " + username);

        Optional<Member> rs = memberRepository.findByUid(username); // 이름으로 id 받기

        if(rs.isEmpty()) {

            throw new UsernameNotFoundException("아이디 또는 비밀번호를 확인 해주세요");
        }

        // 회원의 정보, 권한 정보 => CustomUser 인스턴스 생성 반환
        Member member = rs.get();

        // 권한 데이터 처리
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));

        CustomMember user = new CustomMember(
                member.getUid(),
                member.getPassword(),
                authorities,
                member
        );

        return user;
    }

}
