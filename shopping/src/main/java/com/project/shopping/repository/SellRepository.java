package com.project.shopping.repository;


import com.project.shopping.entity.Sell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellRepository extends JpaRepository<Sell, Integer> {

    Page<Sell> findAll(Pageable pageable);

    Page <Sell> findBySidx(Integer sidx);



}
