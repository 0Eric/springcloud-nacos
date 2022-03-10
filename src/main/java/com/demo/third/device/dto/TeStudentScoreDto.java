package com.demo.third.device.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Describe: 学生平均成绩表
 * @author: liuqiang
 * @date: 2022/3/9 10:40
 **/
@ApiModel(value = "学生平均成绩表")
@Data
public class TeStudentScoreDto {

    @ApiModelProperty(value = "学号", name = "sid", dataType = "String")
    private String sid;

    @ApiModelProperty(value = "姓名", name = "sname", dataType = "String")
    private String sname;

    @ApiModelProperty(value = "课程编号", name = "cid", dataType = "String")
    private String cid;

    @ApiModelProperty(value = "课程名称", name = "cname", dataType = "String")
    private String cname;

    @ApiModelProperty(value = "教师编号", name = "tid", dataType = "String")
    private String tid;

    @ApiModelProperty(value = "教师姓名", name = "tname", dataType = "String")
    private String tname;

    @ApiModelProperty(value = "学生平均成绩", name = "avgscore", dataType = "String")
    private String avgscore;


}
