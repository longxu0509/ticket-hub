package com.ustc.train.common.context;

import com.ustc.train.common.resp.MemberLoginResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用ThreadLocal保存 MemberLoginResp 包括 id，mobile，token 信息
 */
public class LoginMemberContext {
    private static final Logger LOG = LoggerFactory.getLogger(LoginMemberContext.class);

    private static ThreadLocal<MemberLoginResp> member = new ThreadLocal<>();

    public static MemberLoginResp getMember() {
        return member.get();
    }

    public static void setMember(MemberLoginResp member) {
        LoginMemberContext.member.set(member);
    }

    public static Long getId() {
        try {
            return member.get().getId();
        } catch (Exception e) {
            LOG.error("获取登录会员信息异常", e);
            throw e;
        }
    }

}
