package com.project.shopping.service;

import com.project.shopping.entity.Photo;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public void photoRep(List<Photo> photoList, Sell sell){

        if(photoList.isEmpty()){
            return;
        }
        for(Photo photo : photoList){
            photo.setSell(sell);
            photoRepository.save(photo);
        }


    }
}
