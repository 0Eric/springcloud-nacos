package com.demo.third.device.dto;

import lombok.Data;

/**
 * @Describe: 响应结果头
 * @author: liuqiang
 * @date: 2022/3/9 10:12
 **/
@Data
public class ResponseHead {

    private String code;//响应代码

    private String msg;//响应信息
}
