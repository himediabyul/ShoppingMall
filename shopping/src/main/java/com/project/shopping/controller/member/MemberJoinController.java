package com.project.shopping.controller.member;

import com.project.shopping.domain.member.MemberJoinRequest;
import com.project.shopping.service.member.MemberJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/member")
public class MemberJoinController {

    @Autowired
    private MemberJoinService joinService;


    @GetMapping(value = "/join")
    public void getJoinForm() {
    }

    @PostMapping(value = "/join")
    public String joinMember(MemberJoinRequest joinRequest) {


        joinService.join(joinRequest);

        return "redirect:/";
    }

    // 아이디 중복체크
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    @ResponseBody
    public String idCheck(String uid) {

        int result = joinService.isDupicateId(uid);

        if (result != 0) {
            return "fail";
        } else {
            return "success";
        }
    }
    // 전화번호 중복체크
    @RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
    @ResponseBody
    public String phoneCheck(String phone) {

        int result = joinService.isDupicatePhone(phone);

        if (result != 0) {
            return "fail";
        } else {
            return "success";
        }
    }

    //로그인 페이지 이동
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public void getLogin() {
    }

}