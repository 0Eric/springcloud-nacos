package com.demo.third.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "学生信息")
@TableName("te_student")
public class Student {
    /**
     * 主键id
     */
    @TableId
    @ApiModelProperty(value = "学号", name = "sid", dataType = "String")
    private String sid;
    @ApiModelProperty(value = "姓名", name = "sname", dataType = "String")
    private String sname;
    @ApiModelProperty(value = "年龄", name = "sage", dataType = "String")
    private String sage;
    @ApiModelProperty(value = "性别", name = "ssex", dataType = "String")
    private String ssex;
}
