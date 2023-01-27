package com.project.shopping.controller.member;

import com.project.shopping.service.member.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberInfoController {

    @Autowired
    private MemberInfoService infoService;

    @GetMapping("/member/info")
    public void memberInfo(){

    }


}
