package com.ustc.train.member.controller;

import com.ustc.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@Controller
@RequestMapping("member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @RequestMapping("/count")
    @ResponseBody
    public int count(){
        return memberService.count();
    }
}