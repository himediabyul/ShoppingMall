package com.project.shopping.service;

import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SellListService {

    @Autowired
    private SellRepository sellRepository;

    public Page<Sell> getList(Pageable pageable){

        return sellRepository.findAll(pageable);
    }
}
