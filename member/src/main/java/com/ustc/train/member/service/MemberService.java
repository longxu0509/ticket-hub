package com.ustc.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.ustc.train.common.exception.BusinessException;
import com.ustc.train.common.exception.BusinessExceptionEnum;
import com.ustc.train.common.util.SnowUtil;
import com.ustc.train.member.domain.Member;
import com.ustc.train.member.domain.MemberExample;
import com.ustc.train.member.mapper.MemberMapper;
import com.ustc.train.member.req.MemberLoginReq;
import com.ustc.train.member.req.MemberRegisterReq;
import com.ustc.train.member.req.MemberSendCodeReq;
import com.ustc.train.member.resp.MemberLoginResp;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@Slf4j
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return (int) memberMapper.countByExample(null);
    }

    public long register(MemberRegisterReq memberRegisterReq) {
        String mobile = memberRegisterReq.getMobile();
        Member memberDB = selectByMobile(mobile);

        // 不为空说明该手机号已注册 抛出我们自定义的异常
        if (ObjectUtil.isNotNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

    /**
     * 发送短信验证码
     * @param memberSendCodeReq
     */
    public void sendCode(MemberSendCodeReq memberSendCodeReq) {
        // 1. 获取手机号
        String mobile = memberSendCodeReq.getMobile();
        Member memberDB = selectByMobile(mobile);  // 查询数据库是否存在这个手机号

        // 如果手机不存在，说明是新用户 直接注册插入一条新的记录
        if (ObjectUtil.isNull((memberDB))) {
            log.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        } else {
            log.info("手机号已存在");
        }

        // 生成验证码
//        String code = RandomUtil.randomNumbers(6);
        String code = "8888";
        log.info("生成的短语验证码：{}", code);
    }

    /**
     * 登录方法
     * @param memberLoginReq
     */
    public MemberLoginResp login(MemberLoginReq memberLoginReq) {
        String mobile = memberLoginReq.getMobile();
        String code = memberLoginReq.getCode();
        Member memberDB = selectByMobile(mobile);

        // 如果提交的手机号不存在 则抛出异常
        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }

        // 校验短信验证码
        if (!"8888".equals(code)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }

        MemberLoginResp memberLoginResp = BeanUtil.copyProperties(memberDB, MemberLoginResp.class);
//        String token = JwtUtil.createToken(memberLoginResp.getId(), memberLoginResp.getMobile());
//        memberLoginResp.setToken(token);
        return memberLoginResp;
    }



    /**
     * 查询手机号等于mobile的用户 由于mobile是unique的 最多只能查询出一条记录
     * @param mobile
     * @return
     */
    private Member selectByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
