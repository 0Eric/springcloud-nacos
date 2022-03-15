package com.demo.third.device.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "学生信息查询条件 student_param")
@Data
public class TeStudentVo {
    @ApiModelProperty(value = "学号", name = "sid", dataType = "String")
    private String sid;
    @ApiModelProperty(value = "姓名", name = "sname", dataType = "String")
    private String sname;
    @ApiModelProperty(value = "性别 1:男  2：女", name = "ssex", dataType = "String")
    private String ssex;
}
