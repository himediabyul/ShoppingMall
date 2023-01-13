package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.SellWriteRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class SellWriteService {

    @Autowired
    private SellRepository sellRepository;

    public void write(SellWriteRequest writeRequest, MultipartFile file,
                      MultipartFile file1, MultipartFile file2) {

        // 저장 경로
        String absolutePath = new File("").getAbsolutePath();
        String path = "photo";
        File saveDir = new File(absolutePath, path);

        // 폴더가 존재하지 않으면 생성
        if (!saveDir.exists()){
            saveDir.mkdir();
        }
        // 파일이름이 중복되지 않도록 밀리초를 붙여줌
        String newFileName = System.currentTimeMillis()+file.getOriginalFilename();  // 대표이미지
        String newFileName1 = System.currentTimeMillis()+file1.getOriginalFilename();  // 상세이미지
        String newFileName2 = System.currentTimeMillis()+file2.getOriginalFilename();  // 상세이미지2

        File newFile = new File(saveDir, newFileName);
        File newFile1 = new File(saveDir, newFileName1);
        File newFile2 = new File(saveDir, newFileName2);

        try {
            file.transferTo(newFile);
            file1.transferTo(newFile1);
            file2.transferTo(newFile2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // entity 에 저장
        Sell sell = writeRequest.toSellEntity();


        if(newFileName != null || newFileName1 != null || newFileName2 != null) {
            sell.setPhoto(newFileName);
            sell.setDes1(newFileName1);
            sell.setDes2(newFileName2);
        } else {
            sell.setPhoto(null);
            sell.setDes1(null);
            sell.setDes2(null);
        }

        sellRepository.save(sell);
    }

}



