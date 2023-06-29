package com.ustc.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * @author xulong
 * @version 1.0
 * @email longxu@mail.ustc.edu.cn
 */

/**
 * 封装了hutool的工具类
 */
public class SnowUtil {
    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}
