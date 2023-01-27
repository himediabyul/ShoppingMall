package com.project.shopping;

import com.project.shopping.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MemberReapositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void checkId(){

        String id = "admin";
        String id2 = "test12";

        log.info(memberRepository.existsByUid(id));
        log.info(memberRepository.existsByUid(id2));
    }
}
