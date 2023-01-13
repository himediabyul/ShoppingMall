package com.project.shopping;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @GetMapping(value = "/upload/photo/{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImg(@PathVariable("filename") String filename) throws IOException {

        byte[] imgArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        File saveFile = new File(new File("").getAbsolutePath(),"photo\\"+filename);

        if(saveFile.exists()){
            InputStream stream = new FileInputStream(saveFile);
            imgArray = stream.readAllBytes();
            stream.close();
            status = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imgArray, status);
    }

}
