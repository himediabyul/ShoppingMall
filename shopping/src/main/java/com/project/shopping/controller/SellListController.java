package com.project.shopping.controller;

import com.project.shopping.service.SellListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellListController {

    @Autowired
    private SellListService listService;


/*    @GetMapping
    public void getSellList(SellListPage listPage, Model model){

        model.addAttribute(listService.getList(listPage.getPage()));

    }*/
    @GetMapping("/sell/list")
    public void getSellList(@PageableDefault(size = 10, sort = "sidx", direction = Sort.Direction.DESC) Pageable pageable, Model model){

        model.addAttribute(listService.getList(pageable));
    }
}
