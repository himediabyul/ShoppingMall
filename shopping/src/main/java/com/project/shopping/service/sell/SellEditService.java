package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.SellEditRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class SellEditService {

    @Autowired
    private SellRepository sellRepository;

    public int edit(SellEditRequest editRequest,MultipartFile file,MultipartFile file1,MultipartFile file2) {

        file = editRequest.getNewphoto();
        file1 = editRequest.getNewdes1();
        file2 = editRequest.getNewdes2();

        File saveDir = null;
        String newFileName = null;
        String newFileName1 = null;
        String newFileName2 = null;

        if((file != null && !file.isEmpty()) || (file1 != null && !file1.isEmpty()) || (file2 != null && !file2.isEmpty())) {

            // 저장 경로
            String absolutePath = new File("").getAbsolutePath();
            String path = "photo";
            saveDir = new File(absolutePath, path);


            // 파일이름이 중복되지 않도록 밀리초를 붙여줌
            newFileName = System.currentTimeMillis() + file.getOriginalFilename();  // 대표이미지
            newFileName1 = System.currentTimeMillis() + file1.getOriginalFilename();  // 상세이미지
            newFileName2 = System.currentTimeMillis() + file2.getOriginalFilename();  // 상세이미지2

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
        }
        // entity 에 저장
        Sell sell = editRequest.toSellEntity();

        if (newFileName != null || newFileName1 !=null || newFileName2 !=null) {
            sell.setPhoto(newFileName);
            sell.setDes1(newFileName1);
            sell.setDes2(newFileName2);
        }else {
            sell.setPhoto(null);
            sell.setDes1(null);
            sell.setDes2(null);
        }

        int result=0;

        try {

            sellRepository.save(sell);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = editRequest.getOldFile();
            String oldDes1Name = editRequest.getOlddes1();
            String oldDes2Name = editRequest.getOlddes2();

            if (newFileName != null && oldFileName != null && !oldFileName.isEmpty()) {
                File delOldFile = new File(saveDir, oldFileName);
                if (delOldFile.exists()) {
                    delOldFile.delete();
                }
            } else if (newFileName1 != null && oldDes1Name != null && oldDes1Name.isEmpty()) {
                File delOldDes1 = new File(saveDir, oldDes1Name);
                if (delOldDes1.exists()) {
                    delOldDes1.delete();
                }
            } else {
                File delOldDes2 = new File(saveDir, oldDes2Name);
                if (delOldDes2.exists()) {
                    delOldDes2.delete();
                }
            }

        } catch (Exception e) {

            if (newFileName != null) {
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()) {
                    delFile.delete();
                } else if (newFileName1 != null) {
                    File delFile1 = new File(saveDir, newFileName1);
                    if (delFile1.exists()) {
                        delFile1.delete();
                    } else {
                        File delFile2 = new File(saveDir, newFileName2);
                        if (delFile2.exists()) {
                            delFile2.delete();
                        }
                    }
                }
            }
        }
        return result;
    }
}



