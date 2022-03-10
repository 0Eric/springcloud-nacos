package com.demo.third.device.constant;

import lombok.Getter;

/**
 * @Describe: 异常代码枚举
 * @author: liuqiang
 * @date: 2022/3/8 17:28
 **/
@Getter
public enum ResponseCode {

    SUCCESS("0000", "成功"),
    EMPTY("3000", "参数缺失"),
    EXCEPTION("4000", "系统异常"),
    TEST("xxxx", "xxxx");


    private final String code;
    private final String msg;


    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
