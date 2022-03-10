package com.demo.third.device.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentScoreVo {
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

    @ApiModelProperty(value = "查询类型 0：查询所有  1：及格学生   2：不及格学生", name = "type", dataType = "String")
    private String type;
}
