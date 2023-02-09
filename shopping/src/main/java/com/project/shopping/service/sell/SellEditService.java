package com.project.shopping.service.sell;

import com.project.shopping.domain.sell.SellEditRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


@Service
public class SellEditService {

    @Autowired
    private SellRepository sellRepository;

    public int edit(SellEditRequest editRequest,MultipartFile file,MultipartFile file1) {

        file = editRequest.getNewphoto();
        file1 = editRequest.getNewdes1();

        File saveDir = null;
        String newFileName = null;
        String newFileName1 = null;


        if((file != null && !file.isEmpty()) || (file1 != null && !file1.isEmpty())){


                // 새로운 파일 저장
                String absolutePath = new File("").getAbsolutePath();
                String path = "photo";
                saveDir = new File(absolutePath, path);

              if(file!= null && !file.isEmpty()) {
                    // 파일이름이 중복되지 않도록 밀리초를 붙여줌
                    newFileName = System.currentTimeMillis() + file.getOriginalFilename();  // 대표이미지

                    File newFile = new File(saveDir, newFileName);

                    try {
                        file.transferTo(newFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

            if(file1 != null && !file1.isEmpty()){

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
        Sell sell = editRequest.toSellEntity();

        // 새로운 파일이 존재한다면 저장
        if (newFileName != null) {
            sell.setPhoto(newFileName);
            if(newFileName1 !=null){
                sell.setDes1(newFileName1);
            }
        } else if(newFileName1 != null){
            sell.setDes1(newFileName1);
        }

        int result=0;

        try {

            // 수정 시간 설정
            sell.setUpdatedate(LocalDate.now());
            sellRepository.save(sell);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = editRequest.getOldFile();
            String oldDes1Name = editRequest.getOlddes1();

            if (newFileName != null && oldFileName != null && !oldFileName.isEmpty()) {
                File delOldFile = new File(saveDir, oldFileName);
                if (delOldFile.exists()) {
                    delOldFile.delete();
                }
                else if (newFileName1 != null && oldDes1Name != null && oldDes1Name.isEmpty()) {
                    File delOldDes1 = new File(saveDir, oldDes1Name);
                    if (delOldDes1.exists()) {
                    }
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
                    }
                }
            }
        }
        return result;
    }
}



