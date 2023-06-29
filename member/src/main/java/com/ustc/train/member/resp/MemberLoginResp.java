package com.ustc.train.member.resp;

import lombok.Data;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@Data
public class MemberLoginResp {
    private Long id;

    private String mobile;

    private String token;
}
