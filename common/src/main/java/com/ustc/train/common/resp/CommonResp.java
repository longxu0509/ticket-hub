package com.ustc.train.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */

@Data
public class CommonResp<T> {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T data;

    public CommonResp() {}

    public CommonResp(T data) {
        this.data = data;
    }
}
