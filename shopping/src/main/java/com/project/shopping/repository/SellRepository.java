package com.project.shopping.repository;


import com.project.shopping.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Integer> {
}
