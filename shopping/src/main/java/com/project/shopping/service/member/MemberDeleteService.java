package com.project.shopping.service.member;

import com.project.shopping.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberDeleteService {

    @Autowired
    private MemberRepository memberRepository;


    public int delete(int uidx) {

        int result = memberRepository.deleteByUidx(uidx);

        return result;

    }
}
