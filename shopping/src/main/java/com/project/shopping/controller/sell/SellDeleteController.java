package com.project.shopping.controller.sell;

import com.project.shopping.service.sell.SellDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellDeleteController {

    @Autowired
    private SellDeleteService deleteService;

    @GetMapping("/sell/delete")
    public String deleteProduct(int sidx){

        deleteService.delete(sidx);

        return "redirect:/sell/list";
    }
}
