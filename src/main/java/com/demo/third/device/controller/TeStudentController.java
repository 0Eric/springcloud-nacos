package com.demo.third.device.controller;

import com.demo.third.device.dto.ResponseMessage;
import com.demo.third.device.service.TeStudentService;
import com.demo.third.device.vo.StudentScoreVo;
import com.demo.third.device.vo.TeStudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stu")
@CrossOrigin
@Api(tags = "学生信息接口")
public class TeStudentController {

    @Autowired
    private TeStudentService teStudentService;

    @ApiOperation(value = "学生信息列表")
    @PostMapping("/list")
    public ResponseMessage list(@RequestBody(required = false) TeStudentVo teStudentVo) {
        return teStudentService.queryStudentInfo(teStudentVo);
    }

    @ApiOperation(value = "查询成绩信息")
    @PostMapping("/queryScore")
    public ResponseMessage queryScore(@RequestBody(required = false) StudentScoreVo studentScoreVo) {
        return teStudentService.queryScoreBySno(studentScoreVo);
    }

    @ApiOperation(value = "查询所有学生课程成绩信息")
    @PostMapping("/queryAllInfo")
    public ResponseMessage queryAllInfo(@RequestBody(required = false) StudentScoreVo studentScoreVo) {
        return teStudentService.queryAllInfo(studentScoreVo);
    }

    @ApiOperation(value = "查询各科成绩前三名的记录")
    @GetMapping("/queryScoreByCourse")
    public ResponseMessage queryScoreByCourse() {
        return teStudentService.queryScoreByCourse();
    }

    @ApiOperation(value = "查询前三名的各科成绩")
    @GetMapping("/queryScoreTopThree")
    public ResponseMessage queryScoreTopThree() {
        return teStudentService.queryScoreTopThree();
    }
}
