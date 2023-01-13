package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.SellWriteRequest;
import com.project.shopping.service.sell.SellWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/sell/write")
public class SellWriteController {

    @Autowired
    private SellWriteService writeService;

    @GetMapping
    public void getWriteForm(){
    }

    @PostMapping
    public String sellWrite(@RequestPart(value="photo",required = false) MultipartFile file,
                            @RequestPart(value="des1",required = false) MultipartFile file1,
                            @RequestPart(value="des2",required = false) MultipartFile file2,
                            SellWriteRequest writeRequest){

        writeService.write(writeRequest,file,file1,file2);

        return "redirect:/sell/list";
    }

}
