package com.project.shopping.service;

import com.project.shopping.entity.Photo;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.PhotoRepository;
import com.project.shopping.repository.SellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PhotoHandler {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private SellRepository sellRepository;

    public List<Photo> photoUpload(List<MultipartFile> files, Integer sidx) throws IOException {

        List<Photo> photoList = new ArrayList<>();
        Sell sell = (Sell) sellRepository.findBySidx(sidx);



        if(!CollectionUtils.isEmpty(files)){

            for(MultipartFile multipartFile : files){

                String absolutePath = new File("").getAbsolutePath();
                String path = "photo";
                String newFileName = System.currentTimeMillis()+multipartFile.getOriginalFilename();
                File saveDir = new File(absolutePath, path);

                if(!saveDir.exists()){
                    saveDir.mkdir();
                }
                File newFile = new File(saveDir, newFileName);
                Photo photo = new Photo();

                photo.setSell(sell);
                photo.setFilePath(path+newFileName);
                photo.setFileSize(multipartFile.getSize());
                photo.setOrigFileName(multipartFile.getOriginalFilename());
                photo.setSavedName(newFileName);

                photoList.add(photo);

                multipartFile.transferTo(newFile);

                newFile.setWritable(true);
                newFile.setReadable(true);

            }
            return photoList;
        }
        return null;
    }

}
