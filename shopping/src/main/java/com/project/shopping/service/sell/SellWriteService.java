package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.SellWriteRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


@Service
public class SellWriteService {

    @Autowired
    private SellRepository sellRepository;

    public void write(SellWriteRequest writeRequest, MultipartFile file,
                      MultipartFile file1) {

        file = writeRequest.getPhoto();
        file1 = writeRequest.getDes1();

        File saveDir = null;
        String newFileName = null;
        String newFileName1 = null;

        if(file != null && !file.isEmpty()) {

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName = System.currentTimeMillis() + file.getOriginalFilename();  // 대표이미지

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(file1 !=null && !file1.isEmpty()){

                newFileName1 = System.currentTimeMillis() + file1.getOriginalFilename();  // 상세이미지

                File newFile1 = new File(saveDir, newFileName1);

                try {
                    file1.transferTo(newFile1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // entity 에 저장
        Sell sell = writeRequest.toSellEntity();


        if(newFileName != null) {
            sell.setPhoto(newFileName);
            if(newFileName1 != null){
                sell.setDes1(newFileName1);
            }
        }

        sellRepository.save(sell);
    }

}


