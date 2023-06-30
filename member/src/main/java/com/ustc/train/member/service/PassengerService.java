package com.ustc.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.ustc.train.common.context.LoginMemberContext;
import com.ustc.train.common.util.SnowUtil;
import com.ustc.train.member.domain.Passenger;
import com.ustc.train.member.mapper.PassengerMapper;
import com.ustc.train.member.req.PassengerSaveReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

}
