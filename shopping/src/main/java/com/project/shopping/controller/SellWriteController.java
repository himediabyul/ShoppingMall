package com.project.shopping.controller;

import com.project.shopping.domain.SellWriteRequest;
import com.project.shopping.entity.Sell;
import com.project.shopping.service.PhotoHandler;
import com.project.shopping.service.PhotoService;
import com.project.shopping.service.SellWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/sell/write")
public class SellWriteController {

    @Autowired
    private SellWriteService writeService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoHandler photohandler;

    @GetMapping
    public void getWriteForm(){
    }

    @PostMapping
    public String sellWrite(@ModelAttribute Sell sell, @RequestParam(value = "photo",required = false) List<MultipartFile> files) throws IOException {

        writeService.write(sell);
        photoService.photoRep(photohandler.photoUpload(files, sell.getSidx()),sell);

        return "redirect:/sell/list";
    }

/*    @PostMapping
    public String writeSell(SellWriteRequest writeRequest){

        writeService.write(writeRequest);

        return "redirect:/sell/list";
    }*/

}
