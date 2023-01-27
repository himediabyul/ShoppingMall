package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.SearchType;
import com.project.shopping.entity.Sell;
import com.project.shopping.repository.SellRepository;
import com.project.shopping.service.sell.SellListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellListController {
    @Autowired
    private SellListService listService;

    @GetMapping("/sell/list")
    public void getSellList(@PageableDefault(size = 8, sort = "sidx", direction = Sort.Direction.DESC) Pageable pageable, Model model){

        Page<Sell> sells = listService.getList(pageable);

        int startPage = Math.max(1, sells.getPageable().getPageNumber()-5);

        int endPage = Math.min(sells.getTotalPages(), sells.getPageable().getPageNumber()+5);

        model.addAttribute("sellList", sells);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

    }

    @GetMapping("/sell/search")
    public String search(@PageableDefault(size = 8, sort = "sidx", direction = Sort.Direction.DESC) Pageable pageable, SearchType searchType, Model model, @RequestParam(value = "page", defaultValue = "0") int pagenum){

        Page<Sell> searchList = listService.searchProduct(searchType,pageable,pagenum);

        int startPage = Math.max(1, searchList.getPageable().getPageNumber()-5);

        int endPage = Math.min(searchList.getTotalPages(), searchList.getPageable().getPageNumber()+5);

        model.addAttribute("keyword", searchType.getKeyword());
        model.addAttribute("searchOption", searchType.getSearchOption());
        model.addAttribute("searchList", searchList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/sell/searchList";
    }
  /*@GetMapping("/sell/list")
  public String sellList(Model model,SearchType searchType, @PageableDefault(size = 8, sort = "sidx", direction = Sort.Direction.DESC) Pageable pageable){

      Page<Sell> list = null;

      if(searchType.getKeyword() == null){
          list = listService.getList(pageable);
      } else {
          list = listService.searchProduct(searchType,pageable);
      }

      int nowPage = list.getPageable().getPageNumber()+1;
      int startPage = Math.max(1, list.getPageable().getPageNumber()-4);
      int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber()+4);


      model.addAttribute("sellList", list);
      model.addAttribute("keyword", searchType.getKeyword());
      model.addAttribute("nowPage", nowPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);

      return "/sell/list";

  }*/

}
