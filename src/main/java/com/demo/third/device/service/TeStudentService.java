package com.demo.third.device.service;

import com.demo.third.device.dto.ResponseMessage;
import com.demo.third.device.vo.StudentScoreVo;
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
    ResponseMessage queryStudentInfo(TeStudentVo teStudentVo);

    /**
     * @param studentScoreVo
     * @return
     * @Description: 通过学号获取平均成绩
     * @author liuqiang
     * @date 2022/3/9 11:57
     * @Exception
     */
    ResponseMessage queryScoreBySno(StudentScoreVo studentScoreVo);

    /**
     * @Description: 查询所有学生的课程，成绩信息
     * @author liuqiang
     * @date 2022/3/9 15:21
     * @param  studentScoreVo
     * @return
     * @Exception
     */
    ResponseMessage queryAllInfo(StudentScoreVo studentScoreVo);

    /**
     * @Description:查询各科成绩前三名的记录
     * @author liuqiang
     * @date 2022/3/9 15:43
     * @param
     * @return
     * @Exception
     */
    ResponseMessage queryScoreByCourse();

    /**
     * @Description:查询前三名的各科成绩
     * @author liuqiang
     * @date 2022/3/14 10:47
     * @param
     * @return
     * @Exception
     */
    ResponseMessage queryScoreTopThree();
}
