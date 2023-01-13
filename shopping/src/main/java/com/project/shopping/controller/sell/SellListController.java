package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.SearchType;
import com.project.shopping.entity.Sell;
import com.project.shopping.service.sell.SellListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SellListController {

    @Autowired
    private SellListService listService;


    @GetMapping("/sell/list")
    public void getSellList(@PageableDefault(size = 10, sort = "sidx", direction = Sort.Direction.DESC) Pageable pageable, Model model){

        Page<Sell> sells = listService.getList(pageable);

        int startPage = Math.max(0, sells.getPageable().getPageNumber()-9);

        int endPage = Math.min(sells.getTotalPages(), sells.getPageable().getPageNumber()+9);

        model.addAttribute("sellList", sells);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

    }

    public String search(SearchType searchType, Model model){

        List<Sell> searchList = listService.searchProduct(searchType);

        model.addAttribute("searchList", searchList);

        return "/todo/searchList";
    }
}
