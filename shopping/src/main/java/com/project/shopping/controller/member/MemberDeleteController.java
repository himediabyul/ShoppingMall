package com.project.shopping.controller.member;

import com.project.shopping.service.member.MemberDeleteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberDeleteController {

    @Autowired
    private MemberDeleteService deleteService;

    @GetMapping("/member/delete")
    public String deleteMember(@Param("uidx") int uidx) {

        deleteService.delete(uidx);

        return "redirect:/auth/logout";
    }

}
