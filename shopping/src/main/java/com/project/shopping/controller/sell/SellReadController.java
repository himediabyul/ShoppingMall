package com.project.shopping.controller.sell;

import com.project.shopping.security.CustomMember;
import com.project.shopping.service.sell.SellReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellReadController {

    @Autowired
    private SellReadService readService;

    @GetMapping("/sell/read")
    public void readProduct(int sidx, Model model, @AuthenticationPrincipal CustomMember customMember){

        model.addAttribute("product", readService.read(sidx));

        // 현재 로그인 한 사용자의 정보를 가지고 있는 객체
        model.addAttribute("midx", customMember.getMember().getUidx());
    }
}
