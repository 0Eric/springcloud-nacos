package com.demo.third.device.service.impl;

import com.demo.third.device.constant.Constant;
import com.demo.third.device.dao.CommonDao;
import com.demo.third.device.dao.TeStudentDao;
import com.demo.third.device.dto.ResponseMessage;
import com.demo.third.device.dto.TeScoreDto;
import com.demo.third.device.dto.TeStudentScoreDto;
import com.demo.third.device.entity.Dic;
import com.demo.third.device.entity.Score;
import com.demo.third.device.entity.Student;
import com.demo.third.device.service.DicService;
import com.demo.third.device.service.TeStudentService;
import com.demo.third.device.util.ResponseUtil;
import com.demo.third.device.util.StringUtils;
import com.demo.third.device.vo.StudentScoreVo;
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

    @Autowired
    private DicService dicService;

    @Autowired
    private CommonDao commonDao;

    /**
     * @Describe: 获取所有学生的基本信息
     * @author: liuqiang
     * @date: 2022/3/8 17:08
     **/
    @Override
    public ResponseMessage queryStudentInfo(TeStudentVo teStudentVo) {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
        try {
            String sex = teStudentVo.getSsex();
            if (StringUtils.isNotEmpty(sex)) {
                teStudentVo.setSsex(dicService.queryAllDicByCode(geneDic(sex, Constant.DIC_TYPE_SEX)));
            }
            List<Student> allStudent = teStudentDao.selectAllStudent(teStudentVo);

            message.setData(allStudent);
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
                message.setData(obtainStudentName(studentScores));
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

    /**
     * @return
     * @Description:查询前三名的各科成绩
     * @author liuqiang
     * @date 2022/3/14 10:47
     * @Exception
     */
    @Override
    public ResponseMessage queryScoreTopThree() {
        ResponseMessage message = ResponseUtil.wrapSuccessResponse();
        List<List<String>> resultList = new ArrayList<>();
        try {
            List<String> courseList = geneCourseList("");
            List<TeStudentScoreDto> studentScores = teStudentDao.queryScoreTopThree();
            for (TeStudentScoreDto dto : studentScores) {
                List<String> scoreList = geneScoreList(dto.getSid(), courseList);
                scoreList.add(0, geneStudentNameBySid(dto.getSid()));
                resultList.add(scoreList);
            }
            courseList.clear();
            courseList.add("class");
            courseList.addAll(geneCourseList("1"));
            resultList.add(0,courseList);
            message.setData(resultList);
        } catch (Exception e) {
            message = ResponseUtil.wrapExceptionResponse(e);
        }

        return message;
    }

    //获取学生姓名和成绩
    private Map obtainStudentName(List<TeStudentScoreDto> studentVos) {
        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> scoreList = new ArrayList<>();
        for (TeStudentScoreDto student : studentVos) {
            nameList.add(student.getSname());
            scoreList.add(student.getAvgscore());
        }
        resultMap.put("name", nameList);
        resultMap.put("score", scoreList);
        return resultMap;
    }

    //通过类型和代码生成字典表实体
    private Dic geneDic(String code, String type) {
        Dic dic = new Dic();
        dic.setCode(code);
        dic.setType(type);
        return dic;
    }

    //获取所有的课程
    private List<String> geneCourseList(String type) {
        List<String> courseList = new ArrayList<>();
        List<Dic> dics = commonDao.selectAllDic(Constant.DIC_TYPE_COURSE);
        for (Dic dic : dics) {
            if (StringUtils.isNotEmpty(type)) {
                courseList.add(dic.getName());
            } else {
                courseList.add(dic.getCode());
            }
        }
        return courseList;
    }

    //根据学号和课程号获取学生的成绩
    private List<String> geneScoreList(String sid, List<String> cids) {
        List<String> scoreList = new ArrayList<>();
        for (String cid : cids) {
            StudentScoreVo d = new StudentScoreVo();
            d.setCid(cid);
            d.setSid(sid);
            List<Score> scores = teStudentDao.queryScoreBySid(d);
            if (!CollectionUtils.isEmpty(scores)) {
                scoreList.add(scores.get(0).getScore());
            }
        }
        return scoreList;
    }

    //根据学号获取名称
    private String geneStudentNameBySid(String sid) {
        String name = "";
        TeStudentVo teStudentVo = new TeStudentVo();
        teStudentVo.setSid(sid);
        List<Student> allStudent = teStudentDao.selectAllStudent(teStudentVo);
        if (!CollectionUtils.isEmpty(allStudent)) {
            name = allStudent.get(0).getSname();
        }
        return name;
    }

}
