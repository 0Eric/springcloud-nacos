package com.demo.third.device.util;

import com.demo.third.device.constant.ResponseCode;
import com.demo.third.device.dto.ResponseMessage;

/**
 * @Describe: 响应信息工具类
 * @author: liuqiang
 * @date: 2022/3/9 10:16
 **/
public class ResponseUtil {

    //返回成功响应
    public static ResponseMessage wrapSuccessResponse() {
        ResponseMessage message = new ResponseMessage();
        message.getHead().setMsg(ResponseCode.SUCCESS.getMsg());
        message.getHead().setCode(ResponseCode.SUCCESS.getCode());
        return message;
    }

    //返回参数缺失响应
    public static ResponseMessage wrapEmptyParameterResponse() {
        ResponseMessage message = new ResponseMessage();
        message.getHead().setMsg(ResponseCode.EMPTY.getMsg());
        message.getHead().setCode(ResponseCode.EMPTY.getCode());
        return message;
    }

    //返回异常响应
    public static ResponseMessage wrapExceptionResponse(Exception e) {
        ResponseMessage message = new ResponseMessage();
        message.getHead().setMsg(ResponseCode.EXCEPTION.getMsg() + "==>" + "具体原因：{" + e.getCause() + "}");
        message.getHead().setCode(ResponseCode.EXCEPTION.getCode());
        return message;
    }


}
