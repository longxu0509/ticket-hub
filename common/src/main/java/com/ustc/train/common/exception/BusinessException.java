package com.ustc.train.common.exception;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义的业务异常类 内部聚合了枚举异常
 */
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    BusinessExceptionEnum e;

    /**
     * 业务异常 我们知道具体原因不用打印具体堆栈信息 节省性能
     * @return
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
