package com.project.shopping.service.sell;


import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class SellDeleteService {

    @Autowired
    private SellRepository sellRepository;

    public int delete(int sidx){

        Sell sell = sellRepository.findBySidx(sidx).get();

        int result = sellRepository.deleteBySidx(sidx);


        // 해당 게시물이 DB에서 삭제되고, 해당 게시물의 사진 이름을 가지고 있다면 파일을 삭제
        if(result>0 && sell.getPhoto()!=null){
            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+sell.getPhoto());
            log.info(delFile.getAbsolutePath());
            if(delFile.exists()){
                delFile.delete();
            }
        } else if(result>0 && sell.getDes1()!=null){
            File delFile1 = new File(new File("").getAbsolutePath(), "photo"+File.separator+sell.getDes1());
            log.info(delFile1.getAbsolutePath());
            if(delFile1.exists()){
                delFile1.delete();
            }
        }

        return result;
    }
}
