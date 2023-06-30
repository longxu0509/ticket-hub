package com.ustc.train.member.controller;

import com.ustc.train.common.resp.CommonResp;
import com.ustc.train.member.req.PassengerSaveReq;
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

}
