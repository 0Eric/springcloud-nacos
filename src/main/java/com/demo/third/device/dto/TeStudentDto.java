package com.demo.third.device.dto;

import com.demo.third.device.entity.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@ApiModel(value = "学生信息分类")
@Data
public class TeStudentDto {

    @ApiModelProperty(value = "返回信息代码", name = "code", dataType = "String")
    private String code;
    @ApiModelProperty(value = "返回信息名称", name = "msg", dataType = "String")
    private String msg;
    @ApiModelProperty(value = "返回信息结果", name = "resultData", dataType = "Map")
    private Map<String, List<Student>> resultData;


}
