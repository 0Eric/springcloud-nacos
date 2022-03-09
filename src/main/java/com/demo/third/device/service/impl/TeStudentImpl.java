package com.demo.third.device.service.impl;

import com.demo.third.device.constant.Constant;
import com.demo.third.device.constant.ResponseCode;
import com.demo.third.device.dao.TeStudentDao;
import com.demo.third.device.dto.TeStudentDto;
import com.demo.third.device.entity.Student;
import com.demo.third.device.service.TeStudentService;
import com.demo.third.device.util.DateUtil;
import com.demo.third.device.vo.TeStudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Describe: 学生信息业务实现类
 * @author: liuqiang
 * @date: 2022/3/8 17:02
 **/
@Service
public class TeStudentImpl implements TeStudentService {

    @Autowired
    private TeStudentDao teStudentDao;

    /**
     * @Describe: 获取所有学生的基本信息
     * @author: liuqiang
     * @date: 2022/3/8 17:08
     **/
    @Override
    public TeStudentDto queryStudentInfo(TeStudentVo teStudentVo) {
        TeStudentDto teStudentDto = new TeStudentDto();
        List<Student> manList = new ArrayList<>();
        List<Student> womanList = new ArrayList<>();
        try {
            List<Student> allStudent = teStudentDao.selectAllStudent(teStudentVo);
            if (!CollectionUtils.isEmpty(allStudent)) {
                for (Student student : allStudent) {
                    String sSex = student.getSsex();
                    student.setSage(DateUtil.getAge(DateUtil.parse(student.getSage())) + "");
                    if (Constant.STUDENT_SEX_MAN.equals(sSex)) {
                        manList.add(student);
                    } else if (Constant.STUDENT_SEX_WOMAN.equals(sSex)) {
                        womanList.add(student);
                    }
                    Map<String, List<Student>> resultMap = new HashMap<>();
                    resultMap.put("man", manList);
                    resultMap.put("woman", womanList);
                    teStudentDto.setCode(ResponseCode.SUCCESS.getCode());
                    teStudentDto.setMsg(ResponseCode.SUCCESS.getMsg());
                    teStudentDto.setResultData(resultMap);
                }
            }
        } catch (Exception e) {
            teStudentDto.setCode(ResponseCode.EXCEPTION.getCode());
            teStudentDto.setMsg(ResponseCode.EXCEPTION.getMsg() + "==>" + "具体原因：{" + e.getCause() + "}");
        }
        return teStudentDto;
    }
}
