package com.project.shopping.controller.sell;

import com.project.shopping.domain.sell.SellWriteRequest;
import com.project.shopping.security.CustomMember;
import com.project.shopping.service.sell.SellWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/sell/write")
public class SellWriteController {

    @Autowired
    private SellWriteService writeService;

    @GetMapping
    public void getWriteForm(@AuthenticationPrincipal CustomMember customMember, Model model){

        // CustomUser => 현재 로그인 한 사용자의 정보를 가지고 있는 객체
        model.addAttribute("sidx", customMember.getMember().getUidx());
    }

    @PostMapping
    public String sellWrite(@RequestPart(value="photos",required = false) MultipartFile file,
                            @RequestPart(value="des1",required = false) MultipartFile file1,
                            SellWriteRequest writeRequest){

        writeService.write(writeRequest,file,file1);

        return "redirect:/sell/list";
    }

}


