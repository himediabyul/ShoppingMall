package com.project.shopping;

import com.project.shopping.domain.SellWriteRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
public class SellRepositoryTest {

    @Autowired
    private SellRepository sellRepository;

    // 판매글 등록 테스트
    @Test
    public void writeTest () {

        SellWriteRequest writeRequest = SellWriteRequest.builder()
                .product("롱원피스")
                .price("40,000")
                .qty(100)
                .build();

        Sell sell = writeRequest.toSellEntity();

        Sell insert = sellRepository.save(sell);

        log.info("테스트 >> " + insert);
    }

    @Test
    public void listTest(){

        Page<Sell> page = sellRepository.findAll(PageRequest.of(0,10, Sort.by("sidx").descending()));

        long total = page.getTotalElements();

        log.info("리스트 테스트 >>> " + total);

        for(Sell sell : page.getContent()){
            log.info(sell);
        }
    }

}
