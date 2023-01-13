package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.SellEditRequest;
import com.project.shopping.service.sell.SellEditService;
import com.project.shopping.service.sell.SellReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/sell/edit")
public class SellEditController {

    @Autowired
    private SellReadService readService;
    @Autowired
    private SellEditService editService;

    @GetMapping
    public void getEditForm(int sidx, Model model){

        model.addAttribute("product", readService.read(sidx));

    }

    @PostMapping
    public String sellEdit(SellEditRequest editRequest,
                           @RequestPart(value="photo",required = false) MultipartFile file,
                           @RequestPart(value="des1",required = false) MultipartFile file1,
                           @RequestPart(value="des2",required = false) MultipartFile file2,
                           RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("sidx", editRequest.getSidx());
        editService.edit(editRequest,file,file1,file2);

        return "redirect:/sell/list";
    }

}
