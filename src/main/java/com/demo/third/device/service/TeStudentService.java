package com.demo.third.device.service;

import com.demo.third.device.dto.TeStudentDto;
import com.demo.third.device.vo.TeStudentVo;

/**
 * @Describe: 学生信息业务实现类接口
 * @author: liuqiang
 * @date: 2022/3/8 17:01
 **/
public interface TeStudentService {

    /**
     * @Describe: 获取所有学生的基本信息
     * @author: liuqiang
     * @date: 2022/3/8 17:08
     **/
    TeStudentDto queryStudentInfo(TeStudentVo teStudentVo);
}
