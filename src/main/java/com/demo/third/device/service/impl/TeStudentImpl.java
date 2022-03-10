package com.demo.third.device.service.impl;

import com.demo.third.device.constant.Constant;
import com.demo.third.device.dao.TeStudentDao;
import com.demo.third.device.dto.ResponseMessage;
import com.demo.third.device.dto.TeScoreDto;
import com.demo.third.device.dto.TeStudentScoreDto;
import com.demo.third.device.entity.Student;
import com.demo.third.device.service.TeStudentService;
import com.demo.third.device.util.DateUtil;
import com.demo.third.device.util.ResponseUtil;
import com.demo.third.device.vo.StudentScoreVo;
import com.demo.third.device.vo.TeStudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
    public ResponseMessage queryStudentInfo(TeStudentVo teStudentVo) {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
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
                    message.setData(resultMap);
                }
            }
        } catch (Exception e) {
            message = ResponseUtil.wrapExceptionResponse(e);
        }
        return message;
    }

    /**
     * @param studentScoreVo
     * @return
     * @Description: 通过学号获取平均成绩
     * @author liuqiang
     * @date 2022/3/9 11:57
     * @Exception
     */
    @Override
    public ResponseMessage queryScoreBySno(StudentScoreVo studentScoreVo) {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
        List<TeStudentScoreDto> studentScores = new ArrayList<>();
        try {
            String type = studentScoreVo.getType();
            if (StringUtils.isEmpty(type)) {
                message = ResponseUtil.wrapEmptyParameterResponse();
            } else {
                switch (type) {
                    case Constant.QUERYSCORE_TYPE_ALL:
                        studentScores = teStudentDao.queryScoreBySno(studentScoreVo.getSid());
                        break;
                    case Constant.QUERYSCORE_TYPE_PASS:
                        studentScores = teStudentDao.queryScorePass(studentScoreVo.getSid());
                        break;
                    case Constant.QUERYSCORE_TYPE_FAIL:
                        studentScores = teStudentDao.queryScoreFail(studentScoreVo.getSid());
                        break;
                }
                message.setData(studentScores);
            }
        } catch (Exception e) {
            message = ResponseUtil.wrapExceptionResponse(e);
        }
        return message;
    }

    /**
     * @param studentScoreVo
     * @return
     * @Description: 查询所有学生的课程，成绩信息
     * @author liuqiang
     * @date 2022/3/9 15:21
     * @Exception
     */
    @Override
    public ResponseMessage queryAllInfo(StudentScoreVo studentScoreVo) {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
        try {
            List<TeStudentScoreDto> studentDtoList = teStudentDao.queryAllInfo(studentScoreVo);
            message.setData(studentDtoList);
        } catch (Exception e) {
            message = ResponseUtil.wrapExceptionResponse(e);
        }
        return message;
    }

    /**
     * @return
     * @Description:查询各科成绩前三名的记录
     * @author liuqiang
     * @date 2022/3/9 15:43
     * @Exception
     */
    @Override
    public ResponseMessage queryScoreByCourse() {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
        try {
            List<TeScoreDto> scoreDtos = teStudentDao.queryScoreByCourse();
            message.setData(scoreDtos);
        } catch (Exception e) {
            ResponseUtil.wrapExceptionResponse(e);
        }
        return message;
    }
}
