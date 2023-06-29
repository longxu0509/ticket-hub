package com.ustc.train.member.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */
@Data
public class MemberRegisterReq {
    @NotBlank(message = "手机号不能为空")
    private String mobile;
}
