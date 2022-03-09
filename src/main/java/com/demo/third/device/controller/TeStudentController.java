package com.demo.third.device.controller;

import com.demo.third.device.dto.TeStudentDto;
import com.demo.third.device.service.TeStudentService;
import com.demo.third.device.vo.TeStudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stu")
@Api(tags = "学生信息接口")
public class TeStudentController {

    @Autowired
    private TeStudentService teStudentService;

    @ApiOperation(value = "学生信息列表")
    @PostMapping("/list")
    public TeStudentDto list(@RequestBody TeStudentVo teStudentVo) {
        return teStudentService.queryStudentInfo(teStudentVo);
    }

}
