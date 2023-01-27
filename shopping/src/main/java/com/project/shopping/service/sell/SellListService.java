package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.SearchType;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SellListService {

    @Autowired
    private SellRepository sellRepository;

    public Page<Sell> getList(Pageable pageable){

        return sellRepository.findAll(pageable);
    }

    @Transactional
    public Page<Sell> searchProduct(SearchType searchType,Pageable pageable, int pagenum){

        Page<Sell> sellList = null;

        switch (searchType.getSearchOption()){
            case "product":
                sellList = sellRepository.findByProductContaining(searchType.getKeyword(), pageable);
                break;
            case "price":
                sellList = sellRepository.findByPriceContaining(searchType.getKeyword(), pageable);
                break;
        }

        return sellList;
    }



}
