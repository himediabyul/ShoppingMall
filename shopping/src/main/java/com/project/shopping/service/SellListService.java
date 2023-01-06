package com.project.shopping.service;

import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellListService {

    @Autowired
    private SellRepository sellRepository;

/*    public List<Sell> getList(int page){

        // 한 페이지당 12개의 게시물
        int index = (page-1)*12;
        int count = 12;

        return sellRepository.findAll(index, count);
    }*/

    public Page<Sell> getList(Pageable pageable){

        return sellRepository.findAll(pageable);
    }
}
