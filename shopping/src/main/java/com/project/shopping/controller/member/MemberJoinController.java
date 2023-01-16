package com.project.shopping.controller.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.service.member.MemberJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberJoinController {

    @Autowired
    private MemberJoinService joinService;

    @GetMapping
    public void getJoinForm(){
    }
    @PostMapping
    public String joinMember(MemberJoinRequest joinRequest){

        joinService.join(joinRequest);

        return "redirect:/";
    }
}
