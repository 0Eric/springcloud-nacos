package com.demo.third.device.dao;

import com.demo.third.device.dto.TeScoreDto;
import com.demo.third.device.dto.TeStudentScoreDto;
import com.demo.third.device.entity.Student;
import com.demo.third.device.vo.StudentScoreVo;
import com.demo.third.device.vo.TeStudentVo;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Describe: 查询所有学生信息
 * @author: liuqiang
 * @date: 2022/3/8 16:44
 **/
@Api(tags = "")
@Mapper
@Repository
public interface TeStudentDao {

    //查询学生信息列表
    List<Student> selectAllStudent(TeStudentVo teStudentVo);

    //查询学生的平均成绩
    List<TeStudentScoreDto> queryScoreBySno(String sid);

    //查询学生及格的平均成绩
    List<TeStudentScoreDto> queryScorePass(String sid);

    //查询学生不及格的平均成绩
    List<TeStudentScoreDto> queryScoreFail(String sid);

    //查询所有学生的课程，成绩信息
    List<TeStudentScoreDto> queryAllInfo(StudentScoreVo studentScoreVo);

    //查询各科成绩前三名的记录
    List<TeScoreDto> queryScoreByCourse();

}
