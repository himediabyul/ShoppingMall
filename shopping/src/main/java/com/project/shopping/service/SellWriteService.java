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

        // 상품 상세이미지 1
        MultipartFile file1 = writeRequest.getDes1();

        File saveDir1 = null;
        String newFileName1 = null;

        // 파일이 없는걸 판별
        if (file1.isEmpty() && file1 != null && file1.getSize() > 0){

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir1 = new File(absolutePath, path);

            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName1 = System.currentTimeMillis()+file1.getOriginalFilename();

            File newFile = new File(saveDir1, newFileName1);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 상품 상세이미지 2
        MultipartFile file2 = writeRequest.getDes2();

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

        // 상품 상세이미지 3
        MultipartFile file3 = writeRequest.getDes3();

        File saveDir3 = null;
        String newFileName3 = null;

        // 파일이 없는걸 판별
        if (file3.isEmpty() && file3 != null && file3.getSize() > 0){

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir3 = new File(absolutePath, path);

            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName3 = System.currentTimeMillis()+file3.getOriginalFilename();

            File newFile = new File(saveDir3, newFileName3);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 상품 상세이미지 4
        MultipartFile file4 = writeRequest.getDes4();

        File saveDir4 = null;
        String newFileName4 = null;

        // 파일이 없는걸 판별
        if (file4.isEmpty() && file4 != null && file4.getSize() > 0){

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir4 = new File(absolutePath, path);

            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName4 = System.currentTimeMillis()+file4.getOriginalFilename();

            File newFile = new File(saveDir4, newFileName4);

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

        if(newFileName1 != null) {
            sell.setDes1(newFileName1);
        } else {
            sell.setDes1(null);
        }

        if(newFileName2 != null) {
            sell.setDes2(newFileName2);
        } else {
            sell.setDes2(null);
        }

        if(newFileName3 != null) {
            sell.setDes3(newFileName3);
        } else {
            sell.setDes3(null);
        }

        if(newFileName4 != null) {
            sell.setDes4(newFileName4);
        } else {
            sell.setDes4(null);
        }

        int result = 0;

        sellRepository.save(sell);

        return result;
    }
}
