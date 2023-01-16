package com.project.shopping.security;

import com.project.shopping.entity.Member;
import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomMemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Member> rs = memberRepository.findByName(name);

        if(rs.isEmpty()) {

            throw new UsernameNotFoundException("아이디 또는 비밀번호를 확인 해주세요");
        }

        Member member = rs.get();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));

        CustomMember user = new CustomMember(
                member.getUid(),
                member.getPw(),
                authorities,
                member
        );

        return user;
    }

}
