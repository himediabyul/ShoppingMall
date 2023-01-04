package com.project.shopping.service;

import com.project.shopping.domain.SellWriteRequest;
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

    public int write (SellWriteRequest writeRequest){

        // 상품 대표이미지
        MultipartFile file = writeRequest.getSimage();

        File saveDir = null;
        String newFileName = null;

        // 파일이 없는걸 판별
        if (file.isEmpty() && file != null && file.getSize() > 0){

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if (!saveDir.exists()){
                saveDir.mkdir();
            }
            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName = System.currentTimeMillis()+file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 상품 상세이미지
        MultipartFile file2 = writeRequest.getDescription();

        File saveDir2 = null;
        String newFileName2 = null;

        // 파일이 없는걸 판별
        if (file2.isEmpty() && file2 != null && file2.getSize() > 0){

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir2 = new File(absolutePath, path);

            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName2 = System.currentTimeMillis()+file2.getOriginalFilename();

            File newFile = new File(saveDir2, newFileName2);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // entity 에 저장
        Sell sell = writeRequest.toSellEntity();

        if(newFileName != null) {
            sell.setSimage(newFileName);
        } else {
            sell.setSimage(null);
        }
        if(newFileName2 != null) {
            sell.setDescription(newFileName2);
        } else {
            sell.setDescription(null);
        }

        int result = 0;

        sellRepository.save(sell);

        return result;
    }
}
