package com.ustc.train.member.controller;

import com.ustc.train.common.context.LoginMemberContext;
import com.ustc.train.common.resp.CommonResp;
import com.ustc.train.common.resp.PageResp;
import com.ustc.train.member.req.PassengerQueryReq;
import com.ustc.train.member.req.PassengerSaveReq;
import com.ustc.train.member.resp.PassengerQueryResp;
import com.ustc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */

@RestController
@RequestMapping("passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());  // 通过线程本地变量设置memberId 前端可以不用传递
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        passengerService.delete(id);
        return new CommonResp<>();
    }

}
