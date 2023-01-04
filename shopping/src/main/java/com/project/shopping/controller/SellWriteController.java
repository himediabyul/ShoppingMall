package com.project.shopping.controller;

import com.project.shopping.domain.SellWriteRequest;
import com.project.shopping.service.SellWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sell/write")
public class SellWriteController {

    @Autowired
    private SellWriteService writeService;

    @GetMapping
    public void getWriteForm(){
    }
    @PostMapping
    public String writeSell(SellWriteRequest writeRequest){

        writeService.write(writeRequest);

        return "redirect:/sell/list";
    }
}
