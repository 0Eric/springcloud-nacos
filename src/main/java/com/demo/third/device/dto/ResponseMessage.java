package com.demo.third.device.dto;

import lombok.Data;

/**
 * @Describe: 返回到前端的包装对象
 * @author: liuqiang
 * @date: 2022/3/9 10:13
 **/
@Data

public class ResponseMessage {


    private ResponseHead head = new ResponseHead();
    /**
     * 用户返回给浏览器的数据
     */
    private Object data;

}
