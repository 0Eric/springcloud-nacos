package com.demo.third.device.dao;

import com.demo.third.device.entity.Student;
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

    List<Student> selectAllStudent(TeStudentVo teStudentVo);

}
