package com.ustc.train.member.controller;

import com.ustc.train.common.resp.CommonResp;
import com.ustc.train.member.req.MemberLoginReq;
import com.ustc.train.member.req.MemberRegisterReq;
import com.ustc.train.member.req.MemberSendCodeReq;
import com.ustc.train.member.resp.MemberLoginResp;
import com.ustc.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@RestController
@RequestMapping("member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @RequestMapping("/count")
    @ResponseBody
    public int count(){
        return memberService.count();
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq memberRegisterReq){
        long register = memberService.register(memberRegisterReq);
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }
}