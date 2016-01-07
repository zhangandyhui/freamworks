package com.andy.study.base.log;

import com.andy.study.base.log.interfaces.ILog;

/**
 * Description:
 * Date:2015年12月29日
 * Author:ZhangHui
 */
public class Log {
    public static void write(ILog log){
        log.getLogger().info(log.format());
    }
}
