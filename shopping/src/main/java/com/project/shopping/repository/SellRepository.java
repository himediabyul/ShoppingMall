package com.project.shopping.repository;


import com.project.shopping.entity.Sell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Integer> {

/*    @Query("select s from Sell s")
    List<Sell> findAll(int index, int count);*/

    Page<Sell> findAll(Pageable pageable);


}
