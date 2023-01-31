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

    // 전체 리스트
    public Page<Sell> getList(Pageable pageable){

        return sellRepository.findAll(pageable);
    }

    // 검색 결과 리스트
    @Transactional
    public Page<Sell> searchProduct(SearchType searchType,Pageable pageable){

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


    // 카테고리 별 리스트
    public Page<Sell> cateList(String category, Pageable pageable){

        return sellRepository.findByCategory(category,pageable);
    }
}
