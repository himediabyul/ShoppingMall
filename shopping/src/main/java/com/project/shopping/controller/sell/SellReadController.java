package com.project.shopping.controller.sell;

import com.project.shopping.service.sell.SellReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellReadController {

    @Autowired
    private SellReadService readService;

    @GetMapping("/sell/read")
    public void readProduct(int sidx, Model model){

        model.addAttribute("product", readService.read(sidx));
    }
}
