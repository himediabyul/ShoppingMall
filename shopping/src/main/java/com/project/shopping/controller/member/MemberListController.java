package com.project.shopping.controller.member;

import com.project.shopping.service.member.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberListController {

    @Autowired
    private MemberListService listService;

    @GetMapping("/member/list")
    public void getMemberList(Model model){

        model.addAttribute("mlist", listService.memberList());
    }

}
