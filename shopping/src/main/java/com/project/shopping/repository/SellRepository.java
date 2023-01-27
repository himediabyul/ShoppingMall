package com.project.shopping.repository;


import com.project.shopping.entity.Sell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface SellRepository extends JpaRepository<Sell, Integer> {

    Page<Sell> findAll(Pageable pageable);  // list paging

    Optional<Sell> findBySidx(Integer sidx);  // sidx로 선택

    @Transactional
    @Modifying
    @Query("delete from Sell s where s.sidx = :sidx")  // 삭제
    int deleteBySidx(Integer sidx);

    Page<Sell> findByProductContaining(String keyword, Pageable pageable);  // 상품명 으로 검색

    Page<Sell> findByPriceContaining(String keyword, Pageable pageable);  // 가격 으로 검색

}
