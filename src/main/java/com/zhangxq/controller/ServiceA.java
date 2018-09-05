package com.zhangxq.controller;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Auther: Administrator
 * @Date: 2018/08/01 01:41
 * @Description:
 */

public class ServiceA {
    @Scheduled(cron ="10/10 * * * * ?")
    public void test(){
        System.out.println("1222");
    }
}
