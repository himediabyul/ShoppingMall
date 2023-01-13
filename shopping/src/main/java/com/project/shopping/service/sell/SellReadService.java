package com.project.shopping.service.sell;

import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellReadService {

    @Autowired
    private SellRepository sellRepository;

    public Sell read(int sidx){

        return sellRepository.findBySidx(sidx).get();
    }
}
