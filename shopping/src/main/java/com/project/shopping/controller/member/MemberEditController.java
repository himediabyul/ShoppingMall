package com.project.shopping.controller.member;

import com.project.shopping.domain.member.MemberEditRequest;
import com.project.shopping.service.member.MemberEditService;
import com.project.shopping.service.member.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/edit")
public class MemberEditController {

    @Autowired
    private MemberInfoService infoService;

    @Autowired
    private MemberEditService editService;

    @GetMapping
    public void getEdit(@RequestParam("uidx") int uidx, Model model){

        model.addAttribute("member", infoService.getInfo(uidx));

    }

    @PostMapping
    public String editMember(MemberEditRequest editRequest, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("uidx", editRequest.getUidx());
        editService.edit(editRequest);

        return "redirect:/member/info";
    }

}
